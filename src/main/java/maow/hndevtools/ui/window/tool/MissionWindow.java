package maow.hndevtools.ui.window.tool;

import maow.hndevtools.ui.ToolWindow;
import maow.hndevtools.util.swing.CloseOperation;

public class MissionWindow extends ToolWindow {
    public MissionWindow(Settings settings) {
        super(settings
                .setTitle("Mission Creation Tool")
                .setWidth(400)
                .setHeight(400)
                .setCloseOperation(CloseOperation.DISPOSE));

        init();
    }

    @Override
    protected void init() {
        this.setVisible(true);
    }
}
