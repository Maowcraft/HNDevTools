package maow.hndevtools.util;

import org.apache.commons.text.WordUtils;

public class EnumUtils {
    public static String getName(Enum<?> e) {
        return WordUtils.capitalizeFully(e.name().replaceAll("_", " "));
    }
}
