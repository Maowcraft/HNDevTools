package maow.hndevtools.ui;

import maow.hndevtools.util.swing.CloseOperation;

import javax.swing.*;

public abstract class Window extends JFrame {
    public Window(Settings settings) {
        initSettings(settings);
    }

    private void initSettings(Settings settings) {
        this.setTitle(settings.title);
        this.setSize(settings.width, settings.height);
        this.setResizable(settings.resizable);
        this.setDefaultCloseOperation(settings.closeOp);
        if (settings.centerOnStart) {
            this.setLocationRelativeTo(null);
        }
    }

    protected abstract void init();

    public static final class Settings {
        protected String title = "Unnamed Window";
        protected int width = 100;
        protected int height = 100;
        protected boolean resizable = true;
        protected int closeOp = WindowConstants.DISPOSE_ON_CLOSE;
        protected boolean centerOnStart = false;

        public final Settings setTitle(final String title) {
            this.title = title;
            return this;
        }

        public final Settings setWidth(final int width) {
            this.width = width;
            return this;
        }

        public final Settings setHeight(final int height) {
            this.height = height;
            return this;
        }

        public final Settings notResizable() {
            this.resizable = false;
            return this;
        }

        public final Settings setCloseOperation(final CloseOperation closeOp) {
            if (closeOp != null) {
                this.closeOp = closeOp.id;
            }
            return this;
        }

        public final Settings centerOnStart() {
            this.centerOnStart = true;
            return this;
        }
    }
}
