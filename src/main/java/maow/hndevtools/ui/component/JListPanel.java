package maow.hndevtools.ui.component;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

public class JListPanel extends JPanel implements ListSelectionListener {
    private final DefaultListModel<String> model;
    private final JList<String> list;

    private final JTextField field;
    private final JButton remove;

    public JListPanel() {
        this.setLayout(new MigLayout("wrap 2"));

        model = new DefaultListModel<>();

        list = new JList<>(model);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.addListSelectionListener(this);
        list.setVisibleRowCount(1);
        this.add(new JScrollPane(list), "span, grow, wrap, h 60:70:80");

        JButton add = new JButton("Add");
        AddListener listener = new AddListener(add);
        add.addActionListener(listener);
        this.add(add);

        field = new JTextField();
        field.addActionListener(listener);
        this.add(field, "span, grow");

        remove = new JButton("Remove");
        remove.addActionListener((e) -> {
            if (model.getSize() > 0) {
                int index = list.getSelectedIndex();
                model.remove(index);
                if (model.getSize() == 0) {
                    remove.setEnabled(false);
                } else {
                    if (index == model.getSize()) {
                        index--;
                    }
                    list.setSelectedIndex(index);
                    list.ensureIndexIsVisible(index);
                }
            }
        });
        this.add(remove);
    }

    private class AddListener implements ActionListener, DocumentListener {
        private final JButton button;

        public AddListener(JButton button) {
            this.button = button;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = field.getText();
            if (name.equals("") || model.contains(name)) {
                Toolkit.getDefaultToolkit().beep();
                field.requestFocusInWindow();
                field.selectAll();
                return;
            }

            model.addElement(field.getText());
            field.requestFocusInWindow();
            field.setText("");
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            button.setEnabled(true);
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            if (e.getDocument().getLength() > 0) {
                button.setEnabled(false);
            }
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            if (e.getDocument().getLength() > 0) {
                button.setEnabled(false);
            }
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting()) {
            remove.setEnabled(list.getSelectedIndex() != -1);
        }
    }

    public Enumeration<String> getValues() {
        return model.elements();
    }
}
