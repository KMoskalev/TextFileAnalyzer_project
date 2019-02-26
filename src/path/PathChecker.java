package path;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PathChecker {

    public static boolean isDirectory(String path) {
        File pathCheck = new File(path);
        boolean check = pathCheck.isDirectory();
        return check;
    }

    public static List<File> getFilesFromDirectory(String path) {
        File directory = new File(path);
        List<File> filesList = new ArrayList<>();
        File[] filesArray = directory.listFiles();
        for (File file : filesArray) {
            if (file.isHidden()) {
                continue;
            } else {
                filesList.add(file);
            }
        }
        return filesList;
    }
}
