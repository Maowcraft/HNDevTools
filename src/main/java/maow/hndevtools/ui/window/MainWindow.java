package maow.hndevtools.ui.window;

import maow.hndevtools.ui.Window;
import maow.hndevtools.ui.window.tool.ExtensionInfoWindow;
import maow.hndevtools.ui.window.tool.MissionWindow;
import maow.hndevtools.ui.window.tool.NodeWindow;
import maow.hndevtools.util.swing.CloseOperation;
import maow.hndevtools.util.swing.Fonts;
import maow.hndevtools.util.swing.Text;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainWindow extends Window {
    private final JPanel textPanel;
    private final JPanel buttonPanel;

    public MainWindow(Settings settings) {
        super(settings
                .setTitle("HN DevTools")
                .setWidth(325)
                .setHeight(175)
                .notResizable()
                .setCloseOperation(CloseOperation.EXIT)
                .centerOnStart()
        );

        // Root Panel
        JPanel rootPanel = new JPanel();
        add(rootPanel);

        // Text Panel
        textPanel = new JPanel();
        textPanel.setLayout(new MigLayout("wrap 1"));
        rootPanel.add(textPanel);

        // Button Panel
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new MigLayout("wrap 2"));
        rootPanel.add(buttonPanel);

        init();
    }

    @Override
    protected void init() {
        // Text Panel
        this.addText(
                new Text(Fonts.ARIAL)
                        .add("HN DevTools - Unofficial Extension Dev Toolsuite")
                        .add("Developed by Maow#1616", Font.BOLD)
        );

        // Button Panel
        this.addToolButton("Create Ext. Info", (e) -> new ExtensionInfoWindow(new Settings()));
        this.addToolButton("Create Node", (e) -> new NodeWindow(new Settings()));
        this.addToolButton("Create Mission", (e) -> new MissionWindow(new Settings()));

        this.setVisible(true);
    }

    private void addText(Text text) {
        for (Component textComponent : text.getText()) {
            textPanel.add(textComponent);
        }
    }

    private void addToolButton(String name, ActionListener listener) {
        final JButton button = new JButton(name);
        button.addActionListener(listener);
        buttonPanel.add(button);
    }
}
