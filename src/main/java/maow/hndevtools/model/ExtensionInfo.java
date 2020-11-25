package maow.hndevtools.model;

public final class ExtensionInfo extends Model {
    public ExtensionInfo() {
        super("HacknetExtension");
        putModelPart(new ModelPart("Language"));
        putModelPart(new ModelPart("Name"));
        putModelPart(new ModelPart("AllowSaves"));
        putModelPart(new ModelPart("StartingVisibleNodes"));
        putModelPart(new ModelPart("StartingMission"));
        putModelPart(new ModelPart("StartingActions"));
        putModelPart(new ModelPart("Description"));
        putModelPart(new ModelPart("StartsWithTutorial")).setValue("False");
        putModelPart(new ModelPart("HasIntroStartup"));
        putModelPart(new ModelPart("StartingTheme"));
        putModelPart(new ModelPart("IntroStartupSong"));
        putModelPart(new ModelPart("SequencerTargetID"));
        putModelPart(new ModelPart("SequencerSpinUpTime"));
        putModelPart(new ModelPart("SequencerFlagRequiredForStart"));
        putModelPart(new ModelPart("ActionsToRunOnSequencerStart"));
        putModelPart(new ModelPart("WorkshopDescription"));
        putModelPart(new ModelPart("WorkshopVisibility"));
        putModelPart(new ModelPart("WorkshopTags"));
        putModelPart(new ModelPart("WorkshopPreviewImagePath"));
    }
}
