package statistics;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StatisticsWriter {

    private static LocalDateTime now = LocalDateTime.now();

    private static String timeStampDate() {
        DateTimeFormatter dtfDate = DateTimeFormatter.ISO_LOCAL_DATE;
        return dtfDate.format(now);
    }

    private static String timeStampTime() {
        DateTimeFormatter dtfTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        return dtfTime.format(now);
    }

    // Static method for statistics file
    public static void writeStatFile() {
        FileWriter statWriter = null;
        try {
            statWriter = new FileWriter("../Project_1.6/src/resources/output/STATISTICS"
                    + "_" + StatisticsWriter.timeStampDate() + "_" + StatisticsWriter.timeStampTime());

            statWriter.write("Date:"
                    + " " + StatisticsWriter.timeStampDate() + "\n"
                    + "Time: " + StatisticsWriter.timeStampTime() + "\n\n");

            statWriter.write("\'String[] args\' is a " + StatisticsSaver.getLauncherLogicMessage() + "\n\n");

            statWriter.write("TXT-files to read:\t" + StatisticsSaver.getNumberOfReadFiles() + "\n");
            statWriter.write("Files written:\t" + StatisticsSaver.getNumberOfWrittenFiles() + "\n");
            statWriter.write("Words replaced:\t" + StatisticsSaver.getNumberOfChangedWords() + "\n\n");

            if (StatisticsSaver.getNumberOfNonTxtfiles() == 0) {
                statWriter.write("All the input files were TXT files.\n\n");
            } else {
                if (StatisticsSaver.getNumberOfNonTxtfiles() == 1) {
                    statWriter.write("There was 1 non-TXT file: "
                            + StatisticsSaver.getNonTxtFiles().get(0) + "\n\n");
                } else {
                    statWriter.write("There were " + StatisticsSaver.getNumberOfNonTxtfiles() + " non-TXT files: ");
                    for (String fileName : StatisticsSaver.getNonTxtFiles()) {
                        statWriter.write(fileName + " ");
                    }
                    statWriter.write("\n\n");
                }
            }

            statWriter.write("Input file:\t" + "Changed words:\t" + "Output file:\n\n");
            for (String line : StatisticsSaver.getStatTable()) {
                statWriter.write(line);
            }

        } catch (IOException e) {
            System.out.println(e + " in writeStatFile() in StatisticsSaver");
        } finally {
            try {
                if (statWriter != null) statWriter.close();
            } catch (IOException e) {
                System.out.println(e + " in finally-statement in writeStatFile() in StatisticsSaver");
            }
        }
    }
}
