package maow.hndevtools.model;

import java.util.ArrayList;
import java.util.List;

public class ModelPart {
    private final String name;
    private final ModelAttribute[] attributes;
    private Object value;

    public ModelPart(String name, String... attributes) {
        this.name = name;
        final List<ModelAttribute> attributesList = new ArrayList<>();
        for (String attribute : attributes) {
            attributesList.add(new ModelAttribute(attribute));
        }
        this.attributes = attributesList.toArray(new ModelAttribute[0]);
    }

    public ModelPart(String name, ModelAttribute... attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    public ModelPart(String name) {
        this(name, new ModelAttribute[0]);
    }

    public ModelAttribute[] getAttributes() {
        return attributes;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
