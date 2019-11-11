package com.mp3cleaner.ui;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import com.mp3cleaner.errors.FolderNotSelectedException;
import com.mp3cleaner.parsers.DirectoryParser;
import javafx.fxml.FXML;
import javafx.stage.DirectoryChooser;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.List;

@SuppressWarnings("SpringJavaAutowiringInspection")
public class MainController {

    private DirectoryParser directoryParser;

    // Инъекции JavaFX
    @FXML
    private JFXTextField tf_path;

    @FXML
    private JFXCheckBox checkbox_mp3;

    @FXML
    private JFXCheckBox checkbox_wav;

    /**
     * Инициализация контроллера от JavaFX.
     * Метод вызывается после того как FXML загрузчик произвел инъекции полей.
     * <p>
     * Обратите внимание, что имя метода <b>обязательно</b> должно быть "initialize",
     * в противном случае, метод не вызовется.
     * <p>
     * Также на этом этапе еще отсутствуют бины спринга
     * и для инициализации лучше использовать метод,
     * описанный аннотацией @PostConstruct,
     * который вызовется спрингом, после того, как им будут произведены все инъекции.
     * {@link MainController#init()}
     */
    @FXML
    public void initialize() {
        this.directoryParser = new DirectoryParser(checkbox_mp3.isSelected(), checkbox_wav.isSelected());
    }

    /**
     * На этом этапе уже произведены все возможные инъекции.
     */
    @PostConstruct
    public void init() {
    }

    @FXML
    public void selectFolder() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Select directory with audio files");
        File directory = directoryChooser.showDialog(tf_path.getScene().getWindow());

        if (directory != null) {
            tf_path.setText(directory.getAbsolutePath());
            directoryParser.setSelectedDirectory(directory);
            getFiles();
        }
    }


    @FXML
    public void mp3CheckboxChange() {
        this.directoryParser.setAllowMp3(checkbox_mp3.isSelected());
    }

    @FXML
    public void wavCheckboxChange() {
        this.directoryParser.setAllowWav(checkbox_wav.isSelected());
    }

    @FXML
    public void getFiles() {
        try {
            File selectedDirectory = directoryParser.getSelectedDirectory();
            List<File> filesFromSelectedPath = directoryParser.getAllMp3FilesFromDirectory(selectedDirectory);

            // TODO: add files to player playlist
            filesFromSelectedPath.forEach(System.out::println);
        } catch (FolderNotSelectedException e) {
            e.getMessage();
        }
    }

//    @FXML
//    public void addContact() throws IOException, NotSupportedException {
////        String name = txtName.getText();
////        String phone = txtPhone.getText();
////        String email = txtEmail.getText();
////        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(phone) || StringUtils.isEmpty(email)) {
////            return;
////        }
////
////        Contact contact = new Contact(name, phone, email);
////        contactService.save(contact);
////        data.add(contact);
////
////        // чистим поля
////        txtName.setText("");
////        txtPhone.setText("");
////        txtEmail.setText("");
//
//
////        DirectoryParser directoryParser = new DirectoryParser();
////        AudioInformationParser audioInformationParser = new AudioInformationParser();
////
////        File selectedFolderPath = new File("C:\\Users\\Admin\\Desktop\\dir");
////
////        List<File> allFilesFromFolder = directoryParser.getAllMp3FilesFromDirectory(selectedFolderPath);
////
////        List<File> allMp3Files = directoryParser.getOnlyMp3(allFilesFromFolder);
////
////        File file = new File("C:\\Users\\Admin\\Desktop\\dir\\New");
////        file.mkdir();
////
////        System.out.println("----------------------------------------------------------------------------");
////        for (File currentFile : allMp3Files) {
////
////            Mp3File mp3File;
////            try {
////                mp3File = new Mp3File(currentFile);
////            } catch (IOException | UnsupportedTagException | InvalidDataException e) {
////                System.err.println("Cannot read file " + currentFile.getName());
////                continue;
////            }
////
////            long lengthInSeconds = mp3File.getLengthInSeconds();
////
////            String fullFileName = currentFile.getName();
////            System.out.printf("%7s %s \n", audioInformationParser.getParsedTrackLength(lengthInSeconds), fullFileName);
//////            System.out.println("Bitrate: " + mp3File.getBitrate() + " kbps " + (mp3File.isVbr() ? "(VBR)" : "(CBR)"));
//////            System.out.println("Sample rate: " + mp3File.getSampleRate() + " Hz");
//////            System.out.println("Has ID3v1 tag?: " + (mp3File.hasId3v1Tag() ? "YES" : "NO"));
//////            System.out.println("Has ID3v2 tag?: " + (mp3File.hasId3v2Tag() ? "YES" : "NO"));
//////            System.out.println("Has custom tag?: " + (mp3File.hasCustomTag() ? "YES" : "NO"));
////            System.out.println("----------------------------------------------------------------------------");
//////
////            ID3v2 existingId3v2Tag = null;
//////            if (mp3File.hasId3v2Tag()) {
////            existingId3v2Tag = mp3File.getId3v2Tag();
//////                System.out.println("Track: " + id3v2Tag.getTrack());
//////                System.out.println("Artist: " + id3v2Tag.getArtist());
//////                System.out.println("Title: " + id3v2Tag.getTitle());
//////                System.out.println("Album: " + id3v2Tag.getAlbum());
//////                System.out.println("Year: " + id3v2Tag.getYear());
//////                System.out.println("Genre: " + id3v2Tag.getGenre() + " (" + id3v2Tag.getGenreDescription() + ")");
//////                System.out.println("Comment: " + id3v2Tag.getComment());
////
////
//////            }
//////            if (id3v2Tag != null) {
//////            mp3File.setId3v2Tag(id3v2Tag);
//////            }
//////            mp3File.save("C:\\Users\\Admin\\Desktop\\dir\\New\\" + fullFileName);
//////
////
////            ID3v2 id3v2Tag;
////            id3v2Tag = new ID3v23Tag();
//////            }
////            id3v2Tag.setTrack("");
//////        id3v2Tag.setArtist("An Artist");
//////        id3v2Tag.setTitle("The Title");
////            id3v2Tag.setArtist(audioInformationParser.getArtistName(fullFileName));
////            id3v2Tag.setTitle(audioInformationParser.getTrackTitle(fullFileName));
////            id3v2Tag.setAlbum(existingId3v2Tag.getAlbum());
////            id3v2Tag.setYear(existingId3v2Tag.getYear());
////            id3v2Tag.setGenre(existingId3v2Tag.getGenre());
////            id3v2Tag.setComment(existingId3v2Tag.getComment());
////            id3v2Tag.setLyrics(existingId3v2Tag.getLyrics());
////            id3v2Tag.setComposer(existingId3v2Tag.getComposer());
////            id3v2Tag.setPublisher(existingId3v2Tag.getPublisher());
////            id3v2Tag.setOriginalArtist(existingId3v2Tag.getOriginalArtist());
////            id3v2Tag.setAlbumArtist(existingId3v2Tag.getAlbumArtist());
////            id3v2Tag.setCopyright(existingId3v2Tag.getCopyright());
////            id3v2Tag.setUrl(existingId3v2Tag.getUrl());
////            id3v2Tag.setEncoder(existingId3v2Tag.getEncoder());
////
////
////            mp3File.setId3v2Tag(id3v2Tag);
////
////            mp3File.save("C:\\Users\\Admin\\Desktop\\dir\\New\\" + fullFileName);
////
////        }
//
//
//    }
}
