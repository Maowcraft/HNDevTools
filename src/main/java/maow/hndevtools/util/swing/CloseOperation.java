package maow.hndevtools.util.swing;

import javax.swing.*;

public enum CloseOperation {
    EXIT(WindowConstants.EXIT_ON_CLOSE),
    HIDE(WindowConstants.HIDE_ON_CLOSE),
    DISPOSE(WindowConstants.DISPOSE_ON_CLOSE),
    NONE(WindowConstants.DO_NOTHING_ON_CLOSE)
    ;

    public final int id;

    CloseOperation(final int id) {
        this.id = id;
    }
}
