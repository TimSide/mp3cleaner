package com.mp3cleaner.parsers;

import com.mp3cleaner.errors.FolderNotSelectedException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DirectoryParser {
    private boolean allowMp3 = true;
    private boolean allowWav = false;

    public List<File> getAllMp3FilesFromFolder(final File folder) throws FolderNotSelectedException {
        if (folder == null) {
            throw new FolderNotSelectedException();
        }

        System.out.println("Current folder: " + folder.getName());

        List<File> foundFiles = new ArrayList<>();

        if (folder.listFiles() != null) {
            for (final File file : Objects.requireNonNull(folder.listFiles())) {
                if (file.isDirectory()) {
                    getAllMp3FilesFromFolder(file).forEach(f -> {
                        if (filterFile(f)) {
                            foundFiles.add(f);
                        }
                    });
                } else {
                    if (filterFile(file)) {
                        foundFiles.add(file);
                    }
                }
            }
        }
        return foundFiles;
    }

    /**
     * @param file: accept file, checks for turned filters (mp3 or wav)
     * @return true: if input file is mp3 or wav, else returns false
     */
    private boolean filterFile(File file) {
        if (allowMp3) {
            if (isMp3(file)) return true;
        }
        if (allowWav) {
            if (isWav(file)) return true;
        }
        return false;
    }

    private boolean isMp3(File file) {
        return file.getName().endsWith(".mp3");
    }

    private boolean isWav(File file) {
        return file.getName().endsWith(".wav");
    }
}
