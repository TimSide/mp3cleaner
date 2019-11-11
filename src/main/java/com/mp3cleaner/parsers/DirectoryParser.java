package com.mp3cleaner.parsers;

import com.mp3cleaner.errors.FolderNotSelectedException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DirectoryParser {
    private boolean allowMp3;
    private boolean allowWav;
    private File selectedDirectory;

    public DirectoryParser(boolean allowMp3, boolean allowWav) {
        this.allowMp3 = allowMp3;
        this.allowWav = allowWav;
        this.selectedDirectory = null;
    }

    public List<File> getAllMp3FilesFromDirectory(final File selectedDirectory) throws FolderNotSelectedException {
        if (selectedDirectory == null) {
            throw new FolderNotSelectedException();
        }

//        System.out.println("Current folder: " + folder.getName());

        List<File> foundFiles = new ArrayList<>();

        if (selectedDirectory.listFiles() != null) {
            for (final File file : Objects.requireNonNull(selectedDirectory.listFiles())) {
                if (file.isDirectory()) {
                    getAllMp3FilesFromDirectory(file).forEach(f -> {
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

    public File getSelectedDirectory() {
        return selectedDirectory;
    }

    public void setSelectedDirectory(File selectedDirectory) {
        this.selectedDirectory = selectedDirectory;
    }

    public void setAllowMp3(boolean allowMp3) {
        System.out.println("MP3: " + allowMp3);
        this.allowMp3 = allowMp3;
    }

    public void setAllowWav(boolean allowWav) {
        System.out.println("WAV: " + allowWav);
        this.allowWav = allowWav;
    }
}
