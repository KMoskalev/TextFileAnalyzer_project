package analyzer;

import statistics.StatisticsSaver;

import java.util.ArrayList;
import java.util.List;

public class Analyzer {

    private List<String> readObjOutput = new ArrayList<>();
    private String wordToReplace;
    private String replacement;

    private int numberOfChangedWordsInOneFile = 0;

    public Analyzer(List<String> readObjOutput, String wordToReplace, String replacement) {
        this.readObjOutput = readObjOutput;
        this.wordToReplace = wordToReplace;
        this.replacement = replacement;
    }

    // Non-static analyze method
    public List<String> analyze() {
        List<String> wordsToAnalyze = readObjOutput;
        List<String> analyzedList = new ArrayList<>();
        for (String word : wordsToAnalyze) {
            if (word.equals(wordToReplace)) {
                analyzedList.add(replacement);

                numberOfChangedWordsInOneFile++;
                StatisticsSaver.numberOfChangedWordsINCREASE();

            } else {
                analyzedList.add(word);
            }
        }
        return analyzedList;
    }

    public int getNumberOfChangedWordsInOneFile() {
        return numberOfChangedWordsInOneFile;
    }
}
