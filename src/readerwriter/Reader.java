package readerwriter;

import statistics.StatisticsSaver;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader {

    // Static read method
    public static synchronized List<String> staticRead(File fileToRead) {
        List<String> readObjOutput = new ArrayList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(fileToRead)));
            while (scanner.hasNext()) {
                readObjOutput.add(scanner.next());
            }

            StatisticsSaver.numberOfReadFilesINCREASE();

        } catch (IOException e) {
            System.out.println(e + " in staticRead() in Reader");
        } finally {
            if (scanner != null) scanner.close();
        }

        return readObjOutput;
    }
}
