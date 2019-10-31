import com.mpatric.mp3agic.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InvalidDataException, IOException, UnsupportedTagException, NotSupportedException {
        DirectoryParser directoryParser = new DirectoryParser();
        AudioInformationParser audioInformationParser = new AudioInformationParser();

        File selectedFolderPath = new File("C:\\Users\\Admin\\Desktop\\dir");

        List<File> allFilesFromFolder = directoryParser.getAllFilesFromFolder(selectedFolderPath);

        List<File> allMp3Files = directoryParser.getOnlyMp3(allFilesFromFolder);

        File file = new File("C:\\Users\\Admin\\Desktop\\dir\\New");
        file.mkdir();

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
//            System.out.println("Bitrate: " + mp3File.getBitrate() + " kbps " + (mp3File.isVbr() ? "(VBR)" : "(CBR)"));
//            System.out.println("Sample rate: " + mp3File.getSampleRate() + " Hz");
//            System.out.println("Has ID3v1 tag?: " + (mp3File.hasId3v1Tag() ? "YES" : "NO"));
//            System.out.println("Has ID3v2 tag?: " + (mp3File.hasId3v2Tag() ? "YES" : "NO"));
//            System.out.println("Has custom tag?: " + (mp3File.hasCustomTag() ? "YES" : "NO"));
            System.out.println("----------------------------------------------------------------------------");
//
            ID3v2 existingId3v2Tag = null;
//            if (mp3File.hasId3v2Tag()) {
            existingId3v2Tag = mp3File.getId3v2Tag();
//                System.out.println("Track: " + id3v2Tag.getTrack());
//                System.out.println("Artist: " + id3v2Tag.getArtist());
//                System.out.println("Title: " + id3v2Tag.getTitle());
//                System.out.println("Album: " + id3v2Tag.getAlbum());
//                System.out.println("Year: " + id3v2Tag.getYear());
//                System.out.println("Genre: " + id3v2Tag.getGenre() + " (" + id3v2Tag.getGenreDescription() + ")");
//                System.out.println("Comment: " + id3v2Tag.getComment());


//            }
//            if (id3v2Tag != null) {
//            mp3File.setId3v2Tag(id3v2Tag);
//            }
//            mp3File.save("C:\\Users\\Admin\\Desktop\\dir\\New\\" + fullFileName);
//

            ID3v2 id3v2Tag;
            id3v2Tag = new ID3v23Tag();
//            }
            id3v2Tag.setTrack("");
//        id3v2Tag.setArtist("An Artist");
//        id3v2Tag.setTitle("The Title");
            id3v2Tag.setArtist(audioInformationParser.getArtistName(fullFileName));
            id3v2Tag.setTitle(audioInformationParser.getTrackTitle(fullFileName));
            id3v2Tag.setAlbum(existingId3v2Tag.getAlbum());
            id3v2Tag.setYear(existingId3v2Tag.getYear());
            id3v2Tag.setGenre(existingId3v2Tag.getGenre());
            id3v2Tag.setComment(existingId3v2Tag.getComment());
            id3v2Tag.setLyrics(existingId3v2Tag.getLyrics());
            id3v2Tag.setComposer(existingId3v2Tag.getComposer());
            id3v2Tag.setPublisher(existingId3v2Tag.getPublisher());
            id3v2Tag.setOriginalArtist(existingId3v2Tag.getOriginalArtist());
            id3v2Tag.setAlbumArtist(existingId3v2Tag.getAlbumArtist());
            id3v2Tag.setCopyright(existingId3v2Tag.getCopyright());
            id3v2Tag.setUrl(existingId3v2Tag.getUrl());
            id3v2Tag.setEncoder(existingId3v2Tag.getEncoder());


            mp3File.setId3v2Tag(id3v2Tag);

            mp3File.save("C:\\Users\\Admin\\Desktop\\dir\\New\\" + fullFileName);

        }


    }
}
