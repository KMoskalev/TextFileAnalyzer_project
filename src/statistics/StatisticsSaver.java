package statistics;

import java.util.*;

public class StatisticsSaver {

    private static int numberOfReadFiles;
    private static int numberOfChangedWords;
    private static int numberOfWrittenFiles;

    private static List<String> namesOfReadFiles = new ArrayList<>();
    private static List<String> namesOfWrittenFiles = new ArrayList<>();

    private static String fileBeingAnalysed;
    private static int numberOfChangedWordsInOneFile;
    private static String fileBeingWritten;
    private static List<String> resultsTable = new ArrayList<>();
    private static int numberOfNonTxtfiles;
    private static List<String> nonTxtFiles = new ArrayList<>();

    private static String launcherLogicMessage;

    // NEW
    private static List<String> statTable = new ArrayList<>();

    public static List<String> getStatTable() {
        return statTable;
    }

    public static void statTableADD(String entry) {
        statTable.add(entry);
    }

    // Getters and setters
    public static int getNumberOfReadFiles() {
        return numberOfReadFiles;
    }

    public static int getNumberOfChangedWords() {
        return numberOfChangedWords;
    }

    public static int getNumberOfWrittenFiles() {
        return numberOfWrittenFiles;
    }

    public static List<String> getNamesOfReadFiles() {
        return namesOfReadFiles;
    }

    public static List<String> getNamesOfWrittenFiles() {
        return namesOfWrittenFiles;
    }

    public static void setLauncherLogicMessage(String launcherLogicMessage) {
        StatisticsSaver.launcherLogicMessage = launcherLogicMessage;
    }

    public static String getLauncherLogicMessage() {
        return launcherLogicMessage;
    }

    public static void numberOfReadFilesINCREASE() {
        numberOfReadFiles++;
    }

    public static void numberOfChangedWordsINCREASE() {
        numberOfChangedWords++;
    }

    public static void numberOfWrittenFilesINCREASE() {
        numberOfWrittenFiles++;
    }

    public static void numberOfChangedWordsInOneFileINCREASE() {
        numberOfChangedWordsInOneFile++;
    }

    public static void namesOfReadFilesADD(String fileName) {
        namesOfReadFiles.add(fileName);
    }

    public static void namesOfWrittenFilesADD(String fileName) {
        namesOfWrittenFiles.add(fileName);
    }

    public static String getFileBeingAnalysed() {
        return fileBeingAnalysed;
    }

    public static void setFileBeingAnalysed(String fileBeingAnalysed) {
        StatisticsSaver.fileBeingAnalysed = fileBeingAnalysed;
    }

    public static String getFileBeingWritten() {
        return fileBeingWritten;
    }

    public static void setFileBeingWritten(String fileBeingWritten) {
        StatisticsSaver.fileBeingWritten = fileBeingWritten;
    }

    public static int getNumberOfChangedWordsInOneFile() {
        return numberOfChangedWordsInOneFile;
    }

    public static void setNumberOfChangedWordsInOneFile(int numberOfChangedWordsInOneFile) {
        StatisticsSaver.numberOfChangedWordsInOneFile = numberOfChangedWordsInOneFile;
    }

    public static List<String> getResultsTable() {
        return resultsTable;
    }

    public static void resultsTableADD(String inputFile, int numberOfChanges, String outputFile) {
        resultsTable.add(inputFile + "\t\t" + numberOfChanges + "\t\t\t\t" + outputFile + "\n");
    }

    public static int getNumberOfNonTxtfiles() {
        return numberOfNonTxtfiles;
    }

    public static List<String> getNonTxtFiles() {
        return nonTxtFiles;
    }

    public static void numberOfNonTxtfilesADD() {
        numberOfNonTxtfiles++;
    }

    public static void nonTxtFilesADD(String fileName) {
        nonTxtFiles.add(fileName);
    }
}
