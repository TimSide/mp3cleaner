//package com.mp3cleaner;
//
//import com.mp3cleaner.errors.FolderNotSelectedException;
//import com.mp3cleaner.parsers.AudioInformationParser;
//import com.mp3cleaner.parsers.DirectoryParser;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.util.Comparator;
//import java.util.List;
//
//public class CustomTest {
//    private final String pathTestDirectory = "test directory";
//    private final String pathTestSubDirectory = "test sub-directory";
//
//
//    private AudioInformationParser audioInformationParser = new AudioInformationParser();
////    private DirectoryParser directoryParser = new DirectoryParser();
//
//    @Before
//    public void createFakeDirectoriesForTest() throws IOException {
//        File rootDirectory = new File(pathTestDirectory);
//        File subDirectory = new File(pathTestDirectory + "\\" + pathTestSubDirectory);
//
//        rootDirectory.mkdir();
//        subDirectory.mkdir();
//
//        new File(pathTestDirectory + "\\One.mp3").createNewFile();
//        new File(pathTestDirectory + "\\Two.mp3").createNewFile();
//        new File(pathTestDirectory + "\\Text.txt").createNewFile();
//        new File(pathTestDirectory + "\\" + pathTestSubDirectory + "\\Three in sub directory.mp3").createNewFile();
//    }
//
//
//    @Test
//    public void whenGetArtistName() {
//        String originalFileName = "David Guetta, Martin Garrix & Brooks - Like I Do (Extended Mix).mp3";
//        String artistName = audioInformationParser.getArtistName(originalFileName);
//
//        Assert.assertEquals("David Guetta, Martin Garrix & Brooks", artistName);
//    }
//
//    @Test
//    public void whenGetTrackTitle() {
//        String originalFileName = "David Guetta, Martin Garrix & Brooks - Like I Do (Extended Mix).mp3";
//        String trackTitle = audioInformationParser.getTrackTitle(originalFileName);
//
//        Assert.assertEquals("Like I Do (Extended Mix)", trackTitle);
//    }
//
//    @Test
//    public void whenGetAllFilesFromDirectoryAndIncludedDirectories() throws FolderNotSelectedException {
//        List<File> allFilesFromFolder = directoryParser.getAllMp3FilesFromDirectory(new File(pathTestDirectory));
//
//        Assert.assertEquals(4, allFilesFromFolder.size());
//    }
//
//    @Test
//    public void whenFilterFilesByExtension() throws FolderNotSelectedException {
////        List<File> allFilesFromFolder = directoryParser.getAllMp3FilesFromDirectory(new File(pathTestDirectory));
////        List<File> filteredFiles = directoryParser.getOnlyMp3(allFilesFromFolder);
////
////        filteredFiles.forEach(file -> Assert.assertTrue(file.getName().endsWith(".mp3")));
//    }
//
//
//    @After
//    public void deleteDirectoryWithFileByPath() throws IOException {
//        Files.walk(Path.of(pathTestDirectory))
//                .sorted(Comparator.reverseOrder())
//                .map(Path::toFile)
//                .forEach(File::delete);
//    }
//
//    @Test
//    public void test() throws FolderNotSelectedException {
//
//        File file = new File("C:\\");
//        directoryParser.getAllMp3FilesFromDirectory(file);
//    }
//}