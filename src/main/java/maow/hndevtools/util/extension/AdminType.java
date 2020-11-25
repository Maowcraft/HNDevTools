package maow.hndevtools.util.extension;

import maow.hndevtools.util.EnumUtils;

public enum AdminType {
    FAST,
    PROGRESS,
    NONE,
    ;

    public static AdminType get(String name) {
        for (AdminType type : values()) {
            if (name.equals(type.name().toLowerCase())) {
                return type;
            }
        }
        return AdminType.NONE;
    }

    @Override
    public String toString() {
        return EnumUtils.getName(this);
    }
}
