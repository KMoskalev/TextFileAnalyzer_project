package path;

import java.io.File;

/**
 * Accepts a File object.
 * Returns either a name of a file or its extension.
 */
public class FileExtensionChecker {

    public static String getFileName(File file) {
        String fileName;
        fileName = file.getName().substring(0, (file.getName().lastIndexOf(".")));
        return fileName;
    }

    public static String getFileExtension(File file) {
        String fileExtension;
        fileExtension = file.getName().substring(file.getName().lastIndexOf("."));
        return fileExtension;
    }
}
