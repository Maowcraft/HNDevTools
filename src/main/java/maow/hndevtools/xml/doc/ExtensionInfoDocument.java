package maow.hndevtools.xml.doc;

import maow.hndevtools.model.ExtensionInfo;
import maow.hndevtools.util.EnumUtils;
import maow.hndevtools.util.extension.Language;
import maow.hndevtools.util.extension.WorkshopVisibility;

public class ExtensionInfoDocument extends XMLDocument {
    public ExtensionInfoDocument(ExtensionInfo model) {
        super(model);

        WorkshopVisibility visibility = WorkshopVisibility.get((String) model.getModelPart("TMP_Visibility").getValue());
        addElement("WorkshopVisibility", String.valueOf(visibility.id));

        Language language = Language.get((String) model.getModelPart("TMP_Lang").getValue());
        addElement("Language", language.code);
        addElement("WorkshopLanguage", EnumUtils.getName(language));

        String factions = (String) model.getModelPart("TMP_Factions").getValue();
        for (String faction : factions.split(",")) {
            addElement("Faction", faction.trim());
        }

        model.removeModelPart("TMP_Visibility");
        model.removeModelPart("TMP_Lang");
        model.removeModelPart("TMP_Factions");
    }
}
