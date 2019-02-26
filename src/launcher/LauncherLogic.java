package launcher;

import main.Thread;
import path.PathChecker;
import path.FileExtensionChecker;
import statistics.StatisticsSaver;

import java.io.*;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LauncherLogic {

    public static void logicInAction(String[] args) {

        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        if (args.length == 0) {
            System.out.println("There are no args[].");
        } else if (args.length == 1) {
            if (!PathChecker.isDirectory(args[0])) {
                System.out.println("There is one file.");
                StatisticsSaver.setLauncherLogicMessage("file.");
                File file = new File(args[0]);
                if (FileExtensionChecker.getFileExtension(file).equals(".txt")) {
                    Thread thread = new Thread(file.getPath());

                } else {
                    System.out.println("It's not a .txt file");

                    // Statistics
                    StatisticsSaver.nonTxtFilesADD(file.getName());
                    StatisticsSaver.numberOfNonTxtfilesADD();
                }
            } else {
                List<File> files = PathChecker.getFilesFromDirectory(args[0]);
                System.out.println("There are " + files.size() + " files in a directory.");
                StatisticsSaver.setLauncherLogicMessage("directory, containing " + files.size() + " files.");
                for (File file : files) {
                    if (FileExtensionChecker.getFileExtension(file).equals(".txt")) {
                        threadPool.submit(new Thread(file.getPath()));

                    } else {
                        System.out.println("It's not a .txt file");

                        // Statistics
                        StatisticsSaver.nonTxtFilesADD(file.getName());
                        StatisticsSaver.numberOfNonTxtfilesADD();

                    }
                }
            }
        } else {
            for (String filePath : args) {
                System.out.println("There are " + args.length + " file paths in args[].");
                StatisticsSaver.setLauncherLogicMessage("list of " + args.length + " file paths.");
                File file = new File(filePath);
                if (FileExtensionChecker.getFileExtension(file).equals(".txt")) {
                    threadPool.submit(new Thread(file.getPath()));

                } else {
                    System.out.println("It's not a .txt file");

                    // Statistics
                    StatisticsSaver.nonTxtFilesADD(file.getName());
                    StatisticsSaver.numberOfNonTxtfilesADD();
                }
            }
        }
        threadPool.shutdown();
    }
}
