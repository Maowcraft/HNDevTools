package maow.hndevtools.model;

public class Node extends Model {
    private final ModelAttribute[] attributes;

    public Node(ModelAttribute... attributes) {
        super("Computer");
        this.attributes = attributes;
        putModelPart(new ModelPart("adminPass", "pass"));
        putModelPart(new ModelPart("ports"));
        putModelPart(new ModelPart("proxy", "time"));
        putModelPart(new ModelPart("portsForCrack", "val"));
        putModelPart(new ModelPart("firewall", "level", "solution", "additionalTime"));
        putModelPart(new ModelPart("trace", "time"));
        putModelPart(new ModelPart("admin", "type", "resetPassword", "isSuper"));
        putModelPart(new ModelPart("portRemap"));
        putModelPart(new ModelPart("tracker"));;
        putModelPart(new ModelPart(""));
    }

    public ModelAttribute[] getAttributes() {
        return attributes;
    }
}
