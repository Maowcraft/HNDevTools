package maow.hndevtools.util.extension;

import maow.hndevtools.util.EnumUtils;

public enum NodeType {
    EMPTY(4),
    SERVER(3),
    HOME(2),
    CORPORATE(1),
    ;

    public final int id;

    NodeType(final int id) {
        this.id = id;
    }

    public static NodeType get(String name) {
        for (NodeType type : values()) {
            if (name.toUpperCase().equals(type.name())) {
                return type;
            }
        }
        return NodeType.EMPTY;
    }

    @Override
    public String toString() {
        return EnumUtils.getName(this);
    }
}
