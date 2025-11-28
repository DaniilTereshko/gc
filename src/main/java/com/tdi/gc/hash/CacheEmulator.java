package com.tdi.gc.hash;

import java.io.File;
import java.util.Scanner;

public class CacheEmulator {

    private final static Scanner sc = new Scanner(System.in);
    private final FileReaderService fileReaderService;
    private final FileCache fileCache;

    public CacheEmulator(FileReaderService fileReaderService, FileCache fileCache) {
        this.fileReaderService = fileReaderService;
        this.fileCache = fileCache;
    }

    public static void main(String[] args) {
        System.out.println("Hello! Enter directory with files: ");
        File dir = new File(sc.nextLine());

        if (!dir.isDirectory()) {
            System.out.println("Invalid directory! Exiting...");
            return;
        }

        var fileReaderService1 = new FileReaderService(dir);
        new CacheEmulator(fileReaderService1, new FileCache(fileReaderService1)).run();
    }

    private void run() {
        while (true) {
            printMenu();
            String choice = sc.nextLine();

            switch (choice) {
                case "1" -> fileReaderService.showFilesInDir();
                case "2" -> readFile();
                case "3" -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Choose value from 1 to 3, please");
            }
        }
    }

    private void printMenu() {
        System.out.println("""
                Choose action:
                1 - view files
                2 - enter file to read
                3 - exit
                """);
    }

    private void readFile() {
        System.out.println("Enter file name: ");
        String fileName = sc.nextLine();
        String content = fileCache.getValue(fileName);
        System.out.println(content);
    }
}
