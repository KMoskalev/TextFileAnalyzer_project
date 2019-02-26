package launcher;

import statistics.StatisticsWriter;

public class Launcher extends Thread {
    public static void main(String[] args) {

        LauncherLogic.logicInAction(args);

        StatisticsWriter.writeStatFile();
    }
}
