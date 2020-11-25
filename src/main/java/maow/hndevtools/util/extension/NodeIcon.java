package maow.hndevtools.util.extension;

import maow.hndevtools.util.EnumUtils;

public enum NodeIcon {
    LAPTOP("laptop"),
    CHIP("chip"),
    KELLIS("kellis"),
    TABLET("tablet"),
    EPHONE("ePhone"),
    EPHONE_2("ePhone2"),

    // Labyrinths
    PSYLANCE("Psylance"),
    PACIFIC_AIR("PacificAir"),
    ALCHEMIST("Alchemist"),
    DLC_LAPTOP("DLCLaptop"),
    DLC_PC_1("DLCPC1"),
    DLC_PC_2("DLCPC2"),
    DLC_SERVER("DLCServer"),
    ;

    public final String id;

    NodeIcon(final String id) {
        this.id = id;
    }

    public static NodeIcon get(String name) {
        for (NodeIcon icon : values()) {
            if (name.toUpperCase().equals(icon.name())) {
                return icon;
            }
        }
        return NodeIcon.CHIP;
    }

    @Override
    public String toString() {
        return EnumUtils.getName(this);
    }
}
