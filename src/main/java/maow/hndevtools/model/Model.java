package maow.hndevtools.model;

import java.util.HashMap;
import java.util.Map;

public class Model {
    private final String name;
    protected final Map<String, ModelPart> modelParts = new HashMap<>();

    public Model(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ModelPart putModelPart(ModelPart part) {
        modelParts.put(part.getName(), part);
        return part;
    }

    public ModelPart getModelPart(String id) {
        return modelParts.get(id);
    }

    public void removeModelPart(String id) {
        modelParts.remove(id);
    }

    public Map<String, ModelPart> getModelParts() {
        return modelParts;
    }
}
