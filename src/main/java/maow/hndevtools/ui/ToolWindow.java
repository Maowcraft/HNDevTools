package maow.hndevtools.ui;

import maow.hndevtools.model.Model;
import maow.hndevtools.model.ModelPart;
import maow.hndevtools.ui.component.JListPanel;
import maow.hndevtools.util.EnumUtils;
import net.miginfocom.swing.MigLayout;
import org.apache.commons.text.WordUtils;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public abstract class ToolWindow extends Window {
    protected final JPanel rootPanel;

    public ToolWindow(Settings settings) {
        super(settings);

        rootPanel = new JPanel();
        this.add(rootPanel);
    }

    protected JPanel createNewPanel(String name, int wrapWidth) {
        return createNewSubPanel(rootPanel, name, wrapWidth);
    }

    protected JPanel createNewSubPanel(JPanel superPanel, String name, int wrapWidth) {
        JPanel panel = new JPanel(new MigLayout("wrap " + wrapWidth));
        panel.setBorder(new TitledBorder(name));
        superPanel.add(panel);
        return panel;
    }

    protected JEditorPane addEditorComponent(JPanel panel, String name, String componentConstraints) {
        JEditorPane editorPane = new JEditorPane();
        addNamedComponent(panel, name, new JScrollPane(editorPane), componentConstraints);
        return editorPane;
    }

    protected <T extends Component> T addComponent(JPanel panel, T component, String componentConstraints) {
        panel.add(component, componentConstraints);
        return component;
    }

    protected <T extends Component> T addNamedComponent(JPanel panel, String name, T component, String componentConstraints) {
        JLabel label = new JLabel(name);
        panel.add(label);
        panel.add(component, componentConstraints);
        return component;
    }

    protected void setModelPart(Model model, String name, Component component) {
        this.setModelPart(model, name, getValue(component));
    }

    protected void setModelPart(Model model, String name, String value) {
        ModelPart part = model.getModelPart(name);
        if (part != null) {
            part.setValue(value);
        } else {
            model.putModelPart(new ModelPart(name, value));
        }
    }

    private String getValue(Component component) {
        if (component instanceof JTextComponent) {
            return ((JTextComponent) component).getText();
        } else if (component instanceof JCheckBox) {
            return WordUtils.capitalize(String.valueOf(((JCheckBox) component).isSelected()));
        } else if (component instanceof JComboBox) {
            return EnumUtils.getName((Enum<?>) Objects.requireNonNull(((JComboBox<?>) component).getSelectedItem()));
        } else if (component instanceof JListPanel) {
            return collapseListValues(Collections.list(((JListPanel) component).getValues()));
        } else if (component instanceof JSpinner) {
            return String.valueOf(((JSpinner) component).getValue());
        }
        return null;
    }

    private String collapseListValues(ArrayList<String> strings) {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        for (String string : strings) {
            builder.append(string);
            if (i < strings.size() - 1) {
                builder.append(",");
            }
        }
        return builder.toString();
    }
}
