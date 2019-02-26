package readerwriter;

import path.FileExtensionChecker;
import statistics.StatisticsSaver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Writer {

    private static String nameOfWrittenFile;

    // Static write method
    public static synchronized void staticWrite(File fileToWrite, List<String> analyzedWords) {
        FileWriter writer = null;
        try {
            writer = new FileWriter("../Project_1.6/src/resources/output/"
                    + FileExtensionChecker.getFileName(fileToWrite) + "_edited"
                    + FileExtensionChecker.getFileExtension(fileToWrite));
            nameOfWrittenFile = FileExtensionChecker.getFileName(fileToWrite) + "_edited"
                    + FileExtensionChecker.getFileExtension(fileToWrite);
            for (String word : analyzedWords) {
                writer.write(word + " ");
            }

            StatisticsSaver.numberOfWrittenFilesINCREASE();

        } catch (IOException e) {
            System.out.println(e + " in staticWriter() in Writer");
        } finally {
            try {
                if (writer != null) writer.close();
            } catch (IOException e) {
                System.out.println(e + " in finally-statement in staticWriter() in Writer");
            }
        }
    }

    public static String getNameOfWrittenFile() {
        return nameOfWrittenFile;
    }
}
