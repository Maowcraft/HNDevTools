package maow.hndevtools.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileIO {
    public static final Path OUTPUT_PATH = Paths.get("output");

    public static boolean init() throws IOException {
        if (Files.notExists(OUTPUT_PATH)) {
            Files.createDirectory(OUTPUT_PATH);
            return Files.exists(OUTPUT_PATH);
        }
        return true;
    }
}
