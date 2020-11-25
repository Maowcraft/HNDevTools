package maow.hndevtools.util.extension;

import maow.hndevtools.util.EnumUtils;

public enum Language {
    ENGLISH("en-us"),
    GERMAN("de-de"),
    FRENCH("fr-be"),
    RUSSIAN("ru-ru"),
    SPANISH("es-ar"),
    KOREAN("ko-kr"),
    JAPANESE("ja-jp"),
    CHINESE("zh-cn"),
    ;

    public final String code;

    Language(final String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return EnumUtils.getName(this) + " (" + code + ")";
    }

    public static Language get(String name) {
        for (Language language : values()) {
            if (name.toUpperCase().equals(language.name())) {
                return language;
            }
        }
        return Language.ENGLISH;
    }
}
