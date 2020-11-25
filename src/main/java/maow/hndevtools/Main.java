package maow.hndevtools;

import maow.hndevtools.ui.Window;
import maow.hndevtools.ui.window.MainWindow;
import maow.hndevtools.util.FileIO;

import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        if (!FileIO.init()) {
            throw new IOException("Error occurred while trying to initialize HN DevTools's files/folders.");
        }
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        new MainWindow(new Window.Settings());
    }
}
