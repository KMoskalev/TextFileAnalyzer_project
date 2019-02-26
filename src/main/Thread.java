package main;

import analyzer.Analyzer;
import path.Path;
import readerwriter.Reader;
import readerwriter.Writer;
import statistics.StatisticsInThreads;
import statistics.StatisticsSaver;

import java.io.File;
import java.util.List;

public class Thread implements Runnable {

    java.lang.Thread thread;
    private String path;

    public Thread(String path) {
        this.path = path;
        thread = new java.lang.Thread(this);
    }

    @Override
    public void run() {

        System.out.println("Thread STARTING for " + path);

        StatisticsInThreads statisticsInThreads = new StatisticsInThreads();

        // Static - Get file
        File fileToRead = Path.staticGetFileToRead(path);

        // Static - Read
        List<String> wordsToAnalyze = Reader.staticRead(fileToRead);

        statisticsInThreads.setNamesOfReadFiles(fileToRead.getName());

        // Non-static - Analyze
        Analyzer analyzer = new Analyzer(wordsToAnalyze, "text", "***");
        List<String> analyzedWords = analyzer.analyze();

        statisticsInThreads.setNumberOfChangedWordsInOneFile(analyzer.getNumberOfChangedWordsInOneFile());

        // Static - Write
        Writer.staticWrite(fileToRead, analyzedWords);

        statisticsInThreads.setNamesOfWrittenFiles(Writer.getNameOfWrittenFile());

        StatisticsSaver.statTableADD(statisticsInThreads.getNamesOfReadFiles() + "\t\t"
                + statisticsInThreads.getNumberOfChangedWordsInOneFile() + "\t\t\t"
                + statisticsInThreads.getNamesOfWrittenFiles() + "\n");

        System.out.println("Thread ending for " + path);
    }
}
