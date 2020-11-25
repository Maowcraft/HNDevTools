package maow.hndevtools.model;

public class ModelAttribute {
    private final String name;
    private String value;

    public ModelAttribute(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public ModelAttribute(String name) {
        this(name, null);
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
