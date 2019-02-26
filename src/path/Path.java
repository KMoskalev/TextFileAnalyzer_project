package path;

import java.io.File;

/**
 * Accepts a String path to a file or directory.
 * Returns a File object.
 */
public class Path {

    // Static method
    public synchronized static File staticGetFileToRead(String path) {
        File fileToRead = new File(path);
        return fileToRead;
    }
}