package maow.hndevtools.util.extension;

import maow.hndevtools.util.EnumUtils;

public enum WorkshopVisibility {
    PUBLIC(0),
    FRIENDS_ONLY(1),
    PRIVATE(2),
    ;

    public final int id;

    WorkshopVisibility(final int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return EnumUtils.getName(this);
    }

    public static WorkshopVisibility get(String name) {
        for (WorkshopVisibility visibility : values()) {
            if (name.toUpperCase().equals(visibility.name())) {
                return visibility;
            }
        }
        return WorkshopVisibility.PRIVATE;
    }
}
