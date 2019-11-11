package com.mp3cleaner;

import com.mp3cleaner.errors.FolderNotSelectedException;
import com.mp3cleaner.parsers.DirectoryParser;

import java.io.File;
import java.util.List;

public class Mp3Cleaner {
    private DirectoryParser directoryParser = new DirectoryParser();

    public Mp3Cleaner() {
    }

    public List<File> getMusicFilesFromSelectedPath(File selectedFolder) throws FolderNotSelectedException {
        return directoryParser.getAllMp3FilesFromFolder(selectedFolder);
    }
}
