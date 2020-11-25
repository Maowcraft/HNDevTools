package maow.hndevtools.ui.window.tool;

import maow.hndevtools.model.ExtensionInfo;
import maow.hndevtools.ui.ToolWindow;
import maow.hndevtools.ui.component.JListPanel;
import maow.hndevtools.util.extension.Language;
import maow.hndevtools.util.extension.WorkshopVisibility;
import maow.hndevtools.util.swing.CloseOperation;
import maow.hndevtools.xml.doc.ExtensionInfoDocument;

import javax.swing.*;

public class ExtensionInfoWindow extends ToolWindow {
    private final JPanel basicInfoPanel;
    private final JPanel workshopInfoPanel;
    private final JPanel startingElementsPanel;
    private final JPanel miscPanel;
    private final JPanel sequencerPanel;

    private final JButton saveButton = new JButton("Save to File");

    public ExtensionInfoWindow(Settings settings) {
        super(settings
                .setTitle("Extension Info Creation Tool")
                .setWidth(750)
                .setHeight(480)
                .setCloseOperation(CloseOperation.DISPOSE));

        basicInfoPanel = createNewPanel("Basic Info", 2);
        workshopInfoPanel = createNewPanel("Workshop Info", 3);
        startingElementsPanel = createNewPanel("Starting Elements", 2);
        miscPanel = createNewPanel("Misc.", 4);
        sequencerPanel = createNewPanel("Sequencer", 2);

        init();
    }

    @Override
    protected void init() {
        // Basic Information Panel
        JTextField name = addNamedComponent(basicInfoPanel, "Name", new JTextField(), "span, grow");
        JComboBox<Language> language = addNamedComponent(basicInfoPanel, "Language", new JComboBox<>(Language.values()), "");
        JEditorPane description = addEditorComponent(basicInfoPanel, "Description", "span, grow, h 65:80:120");

        // Workshop Information Panel
        JCheckBox isLabyrinths = addComponent(workshopInfoPanel, new JCheckBox("Is Labyrinths?"), "");
        JComboBox<WorkshopVisibility> visibility = addNamedComponent(workshopInfoPanel, "Visibility", new JComboBox<>(WorkshopVisibility.values()), "wrap");
        JEditorPane workshopDescription = addEditorComponent(workshopInfoPanel, "Workshop Description", "span, grow, h 65:80:120, wrap");
        JTextField previewImagePath = addNamedComponent(workshopInfoPanel, "Preview Image Path", new JTextField(), "span, grow");

        // Starting Elements Panel
        JTextField startingNodes = addNamedComponent(startingElementsPanel, "Starting Nodes", new JTextField(), "span, grow, w 75:120:120");
        JTextField startingMission = addNamedComponent(startingElementsPanel, "Starting Mission", new JTextField(), "span, grow");
        JTextField startingActionset = addNamedComponent(startingElementsPanel, "Starting Actionset", new JTextField(), "span, grow");
        JTextField startingTheme = addNamedComponent(startingElementsPanel, "Starting Theme", new JTextField(), "span, grow");

        // Misc Panel
        JListPanel factions = addNamedComponent(miscPanel, "Factions", new JListPanel(), "span, grow");
        JCheckBox hasIntroStartup = addComponent(miscPanel, new JCheckBox("Has Intro Startup", true), "");
        JCheckBox allowsSaves = addComponent(miscPanel, new JCheckBox("Allows Saves", true), "wrap");
        JTextField startingSong = addNamedComponent(miscPanel, "Starting Song", new JTextField(), "span, grow");

        // Sequencer Panel
        JTextField sequencerTarget = addNamedComponent(sequencerPanel, "Sequencer Target", new JTextField(), "span, grow, w 50:80:110");
        JTextField sequencerSpinupTime = addNamedComponent(sequencerPanel, "Sequencer Spin-up Time", new JTextField("0.0"), "span, grow");
        JTextField sequencerFlag = addNamedComponent(sequencerPanel, "Sequencer Flag", new JTextField(), "span, grow");
        JTextField sequencerActionset = addNamedComponent(sequencerPanel, "Sequencer Actionset", new JTextField(), "span, grow");

        saveButton.addActionListener((e) -> {
            ExtensionInfo extensionInfo = new ExtensionInfo();

            setModelPart(extensionInfo, "Name", name);
            setModelPart(extensionInfo, "AllowSaves", allowsSaves);
            setModelPart(extensionInfo, "StartingVisibleNodes", startingNodes);
            setModelPart(extensionInfo, "StartingMission", startingMission);
            setModelPart(extensionInfo, "StartingActions", startingActionset);
            setModelPart(extensionInfo, "Description", description);
            setModelPart(extensionInfo, "HasIntroStartup", hasIntroStartup);
            setModelPart(extensionInfo, "StartingTheme", startingTheme);
            setModelPart(extensionInfo, "IntroStartupSong", startingSong);
            setModelPart(extensionInfo, "SequencerTargetID", sequencerTarget);
            setModelPart(extensionInfo, "SequencerSpinUpTime", sequencerSpinupTime);
            setModelPart(extensionInfo, "SequencerFlagRequiredForStart", sequencerFlag);
            setModelPart(extensionInfo, "ActionsToRunOnSequencerStart", sequencerActionset);
            setModelPart(extensionInfo, "WorkshopDescription", workshopDescription);

            setModelPart(extensionInfo, "WorkshopPreviewImagePath", previewImagePath);
            setModelPart(extensionInfo, "WorkshopTags", getTags(isLabyrinths));

            // Temp parts, for very specific parsing.
            setModelPart(extensionInfo, "TMP_Visibility", visibility);
            setModelPart(extensionInfo, "TMP_Lang", language);
            setModelPart(extensionInfo, "TMP_Factions", factions);

            new ExtensionInfoDocument(extensionInfo).write();
        });

        rootPanel.add(saveButton);
        this.setVisible(true);
    }

    private String getTags(JCheckBox isLabyrinths) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Extensions");
        if (isLabyrinths.isSelected()) {
            stringBuilder.append(", Labyrinths");
        }
        return stringBuilder.toString();
    }
}
