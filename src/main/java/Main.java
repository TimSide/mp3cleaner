import com.mpatric.mp3agic.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws InvalidDataException, IOException, UnsupportedTagException, NotSupportedException {
        DirectoryParser directoryParser = new DirectoryParser();
        AudioInformationParser audioInformationParser = new AudioInformationParser();

        File selectedFolderPath = new File("C:\\Users\\Admin\\Desktop\\Armin Van Buuren - Balance (2019)");

        List<File> allFilesFromFolder = directoryParser.getAllFilesFromFolder(selectedFolderPath);

        List<File> allMp3Files = directoryParser.getOnlyMp3(allFilesFromFolder);


        System.out.println("----------------------------------------------------------------------------");
        for (File currentFile : allMp3Files) {

            Mp3File mp3File;
            try {
                mp3File = new Mp3File(currentFile);
            } catch (FileNotFoundException e) {
                System.err.println("Cannot read file " + currentFile.getName());
                continue;
            }

            long lengthInSeconds = mp3File.getLengthInSeconds();

            String fullFileName = currentFile.getName();
            System.out.printf("%7s %s \n", audioInformationParser.getParsedTrackLength(lengthInSeconds), fullFileName);
            System.out.println("----------------------------------------------------------------------------");
//
            ID3v2 id3v2Tag = null;
//
//            if (mp3File.hasId3v2Tag()) {
//                id3v2Tag = mp3File.getId3v2Tag();
//                System.out.println("Track: " + id3v2Tag.getTrack());
//                System.out.println("Artist: " + id3v2Tag.getArtist());
//                System.out.println("Title: " + id3v2Tag.getTitle());
//                System.out.println("Album: " + id3v2Tag.getAlbum());
//                System.out.println("Year: " + id3v2Tag.getYear());
//                System.out.println("Genre: " + id3v2Tag.getGenre() + " (" + id3v2Tag.getGenreDescription() + ")");
//                System.out.println("Comment: " + id3v2Tag.getComment());
//
//                id3v2Tag.setArtist(audioInformationParser.getArtistName(fullFileName));
//                id3v2Tag.setTitle(audioInformationParser.getTrackTitle(fullFileName));
//            }
//            if (id3v2Tag != null) {
//                mp3File.setId3v2Tag(id3v2Tag);
//            }
//            mp3File.save("Mp3FileWithTags.mp3");

//            System.out.println("Length of this mp3 is: " + mp3File.getLengthInSeconds() + " seconds");
//            System.out.println("Bitrate: " + mp3File.getBitrate() + " kbps " + (mp3File.isVbr() ? "(VBR)" : "(CBR)"));
//            System.out.println("Sample rate: " + mp3File.getSampleRate() + " Hz");
//            System.out.println("Has ID3v1 tag?: " + (mp3File.hasId3v1Tag() ? "YES" : "NO"));
//            System.out.println("Has ID3v2 tag?: " + (mp3File.hasId3v2Tag() ? "YES" : "NO"));
//            System.out.println("Has custom tag?: " + (mp3File.hasCustomTag() ? "YES" : "NO"));
//
        }
//        ID3v2 id3v2Tag;
//
//        Mp3File mp3file = new Mp3File("Mp3FileWithoutTags.mp3");
//        if (mp3file.hasId3v2Tag()) {
//            id3v2Tag = mp3file.getId3v2Tag();
//        } else {
//            // mp3 does not have an ID3v2 tag, let's create one..
//            id3v2Tag = new ID3v24Tag();
//            mp3file.setId3v2Tag(id3v2Tag);
//        }
//        id3v2Tag.setTrack("5");
//        id3v2Tag.setArtist("An Artist");
//        id3v2Tag.setTitle("The Title");
//        id3v2Tag.setAlbum("The Album");
//        id3v2Tag.setYear("2001");
//        id3v2Tag.setGenre(12);
//        id3v2Tag.setComment("Some comment");
//        id3v2Tag.setLyrics("Some lyrics");
//        id3v2Tag.setComposer("The Composer");
//        id3v2Tag.setPublisher("A Publisher");
//        id3v2Tag.setOriginalArtist("Another Artist");
//        id3v2Tag.setAlbumArtist("An Artist");
//        id3v2Tag.setCopyright("Copyright");
//        id3v2Tag.setUrl("http://foobar");
//        id3v2Tag.setEncoder("The Encoder");
//
//        mp3file.setId3v2Tag(id3v2Tag);
//        mp3file.save("new");


//            long lengthInSeconds = mp3File.getLengthInSeconds();
//            audioInformationParser.printLengthOfFile(lengthInSeconds);


//            Mp3File mp3File = new Mp3File(currentFile);
//            System.out.println("Length in sec: " + mp3File.getLengthInSeconds());
//        }


    }
}
