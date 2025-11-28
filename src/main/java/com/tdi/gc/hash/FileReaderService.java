package com.tdi.gc.hash;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class FileReaderService {

    private final File dir;

    public FileReaderService(File dir) {
        this.dir = dir;
    }

    public void showFilesInDir() {
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException("Choose the directory, please!");
        }

        for (var file : Objects.requireNonNull(dir.listFiles())) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }
    }

    public String readFile(String fileName) {
        var file = findFile(dir, fileName);

        var sb = new StringBuilder();

        char[] buffer = new char[1028];
        try (var reader = new FileReader(file)) {
            int read = 0;
            while ((read = reader.read(buffer)) != -1) {
                sb.append(buffer, 0, read);
            }
        } catch (IOException ex) {
            throw new RuntimeException("Exception while reading the file!", ex);
        }

        return sb.toString();
    }

    private File findFile(File dir, String fileName) {
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException("Choose the directory, please!");
        }

        for (var file : Objects.requireNonNull(dir.listFiles())) {
            if (file.isFile() && file.getName().equals(fileName)) {
                return file;
            }
        }

        throw new IllegalArgumentException("File not found with name: " + fileName);
    }
}
