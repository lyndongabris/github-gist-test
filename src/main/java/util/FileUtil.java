package util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.google.common.base.Preconditions.checkNotNull;

public class FileUtil {
    private static void verifyFile(File file) {
        checkNotNull("File cannot be null", file);
        if (!file.exists()) {
            throw new GistFileException("File does not exist");
        }

        if (!file.isFile()) {
            throw new GistFileException("Path does not resolve to a file");
        }

        if (!file.canRead()) {
            throw new GistFileException("Can't read file");
        }
    }

    public static String fileToString(File file) {
        return pathToString(file.toPath());
    }

    public static String pathToString(Path path) {
        verifyFile(path.toFile());
        try {
            return new String (Files.readAllBytes(path), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new GistFileException("IO exception occurred while reading file contents");
        }
    }

    public static String getFIleName(File file) {
        verifyFile(file);
        return file.getName();
    }
}
