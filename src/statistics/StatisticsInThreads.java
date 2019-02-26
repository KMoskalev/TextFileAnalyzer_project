package statistics;

public class StatisticsInThreads {

    private String namesOfReadFiles;
    private String namesOfWrittenFiles;

    private int numberOfChangedWordsInOneFile = 0;

    public void setNamesOfReadFiles(String namesOfReadFiles) {
        this.namesOfReadFiles = namesOfReadFiles;
    }

    public String getNamesOfReadFiles() {
        return namesOfReadFiles;
    }

    public void setNamesOfWrittenFiles(String namesOfWrittenFiles) {
        this.namesOfWrittenFiles = namesOfWrittenFiles;
    }

    public String getNamesOfWrittenFiles() {
        return namesOfWrittenFiles;
    }

    public void setNumberOfChangedWordsInOneFile(int number) {
        numberOfChangedWordsInOneFile = number;
    }

    public int getNumberOfChangedWordsInOneFile() {
        return numberOfChangedWordsInOneFile;
    }
}
