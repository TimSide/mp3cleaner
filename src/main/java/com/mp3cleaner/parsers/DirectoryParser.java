package com.mp3cleaner.parsers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DirectoryParser {

    private File selectedFolderPath = new File("C:\\Users\\Admin\\Desktop\\dir");

    public List<File> getAllFilesFromFolder(final File folder) {
        List<File> foundFiles = new ArrayList<>();

        for (final File fileEntry : Objects.requireNonNull(folder.listFiles())) {
            if (fileEntry.isDirectory()) {
                foundFiles.addAll(getAllFilesFromFolder(fileEntry));
            } else {
                foundFiles.add(fileEntry);
            }
        }
        return foundFiles;
    }

    public List<File> getOnlyMp3(List<File> unfilteredFiles) {
        return unfilteredFiles.stream()
                .filter(file -> file.getName().toLowerCase().endsWith(".mp3"))
                .collect(Collectors.toList());
    }
}
