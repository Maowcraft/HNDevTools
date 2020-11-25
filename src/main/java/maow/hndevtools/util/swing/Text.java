package maow.hndevtools.util.swing;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Text {
    private final Font font;
    private final List<Component> labels;

    public Text(Font font) {
        this.font = font;
        this.labels = new ArrayList<>();
    }

    public Text add(String text, int formatting, int size) {
        final JLabel label = new JLabel(text);
        label.setFont(font.deriveFont(formatting, size));
        labels.add(label);
        return this;
    }

    public Text add(String text, int formatting) {
        return this.add(text, formatting, font.getSize());
    }

    public Text add(String text) {
        return this.add(text, font.getStyle(), font.getSize());
    }

    public final List<Component> getText() {
        return labels;
    }
}
