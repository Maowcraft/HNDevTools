package maow.hndevtools.ui.window.tool;

import maow.hndevtools.model.Node;
import maow.hndevtools.ui.ToolWindow;
import maow.hndevtools.ui.component.JListPanel;
import maow.hndevtools.util.extension.AdminType;
import maow.hndevtools.util.extension.NodeIcon;
import maow.hndevtools.util.extension.NodeType;
import maow.hndevtools.util.swing.CloseOperation;

import javax.swing.*;

public class NodeWindow extends ToolWindow {
    private final JPanel basicInfoPanel;
    private final JPanel linkedNodesPanel;
    private final JPanel accountsPanel;

    private final JPanel securityInfoPanel;
    private final JPanel securityInfoFirewallSubPanel;
    private final JPanel securityInfoAdminSubPanel;
    private final JPanel securityInfoPortsSubPanel;

    private final JPanel filesystemPanel;
    private final JPanel daemonsPanel;

    private final JButton saveButton = new JButton("Save to File");

    public NodeWindow(Settings settings) {
        super(settings
                .setTitle("Node Creation Tool")
                .setWidth(1115)
                .setHeight(965)
                .setCloseOperation(CloseOperation.DISPOSE));

        basicInfoPanel = createNewPanel("Basic Info", 4);
        linkedNodesPanel = createNewPanel("Linked Nodes", 2);
        accountsPanel = createNewPanel("Accounts", 2);
        securityInfoPanel = createNewPanel("Security Info", 2);
        securityInfoFirewallSubPanel = createNewSubPanel(securityInfoPanel, "Firewall", 2);
        securityInfoAdminSubPanel = createNewSubPanel(securityInfoPanel, "Admin", 2);
        securityInfoPortsSubPanel = createNewSubPanel(securityInfoPanel, "Ports", 2);
        filesystemPanel = createNewPanel("Filesystem", 2);
        daemonsPanel = createNewPanel("Daemons", 2);

        init();
    }

    @Override
    protected void init() {
        // Basic Information Panel
        JTextField id = addNamedComponent(basicInfoPanel, "ID", new JTextField(), "span, grow");
        JTextField name = addNamedComponent(basicInfoPanel, "Name", new JTextField(), "span, grow");
        JTextField ip = addNamedComponent(basicInfoPanel, "IP Address", new JTextField(), "span, grow");
        JSpinner security = addNamedComponent(basicInfoPanel, "Security Value", new JSpinner(), "span, grow");
        JCheckBox allowsDefaultBootModule = addComponent(basicInfoPanel, new JCheckBox("Allows Default Boot Module"), "wrap");
        JComboBox<NodeIcon> icon = addNamedComponent(basicInfoPanel, "Icon", new JComboBox<>(NodeIcon.values()), "wrap");
        JComboBox<NodeType> type = addNamedComponent(basicInfoPanel, "Type", new JComboBox<>(NodeType.values()), "");

        // Linked Nodes Panel
        JListPanel dlinks = addNamedComponent(linkedNodesPanel, "Linked Nodes (id,position,total,distance,force)", new JListPanel(), "span, grow");

        // Accounts Panel
        JListPanel accounts = addNamedComponent(accountsPanel, "Accounts (username,password,type)", new JListPanel(), "span, grow");

        // Security Information Panel
        // -- Proxy
        JSpinner proxyTime = addNamedComponent(createNewSubPanel(securityInfoPanel, "Proxy", 1), "Proxy Time", new JSpinner(new SpinnerNumberModel(-1, -1, Integer.MAX_VALUE, 1)), "span");
        // -- Firewall
        JSpinner firewallLevel = addNamedComponent(securityInfoFirewallSubPanel, "Level", new JSpinner(new SpinnerNumberModel(-1, -1, Integer.MAX_VALUE, 1)), "span, grow, w 65:75:85");
        JTextField firewallSolution = addNamedComponent(securityInfoFirewallSubPanel, "Solution", new JTextField(), "span, grow");
        JSpinner firewallAdditionalTime = addNamedComponent(securityInfoFirewallSubPanel, "Additional Time", new JSpinner(), "span, grow");
        // -- Admin
        JComboBox<AdminType> adminType = addNamedComponent(securityInfoAdminSubPanel, "Type", new JComboBox<>(AdminType.values()), "");
        JCheckBox resetPassword = addComponent(securityInfoAdminSubPanel, new JCheckBox("Reset Password"), "");
        JCheckBox isSuper = addComponent(securityInfoAdminSubPanel, new JCheckBox("Is Super?"), "wrap");
        // -- Ports
        JListPanel ports = addNamedComponent(securityInfoPortsSubPanel, "Port List", new JListPanel(), "span, grow");
        JListPanel portRemap = addNamedComponent(securityInfoPortsSubPanel, "Port Remaps", new JListPanel(), "span, grow");
        // -- Basic
        JCheckBox tracker = addComponent(securityInfoPanel, new JCheckBox("Has Tracker?"), "span");
        JSpinner trace = addNamedComponent(securityInfoPanel, "Trace Time", new JSpinner(new SpinnerNumberModel(-1, -1, Integer.MAX_VALUE, 1)), "span, grow");

        // Filesystem Panel
        JListPanel files = addNamedComponent(filesystemPanel, "Files (path+name,content)", new JListPanel(), "span, grow");

        // TODO: Add daemons panel
        // TODO: Finish save button

        saveButton.addActionListener((e) -> {
            Node node = new Node();
        });
        
        rootPanel.add(saveButton);
        this.setVisible(true);
    }
}
