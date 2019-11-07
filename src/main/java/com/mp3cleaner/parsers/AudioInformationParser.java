package com.mp3cleaner.parsers;

import java.util.concurrent.TimeUnit;

public class AudioInformationParser {

    String parseFileName(String fileName) {
        if (!fileName.contains("-")) {
            return fileName;
        } else {
            return ""; // TODO: parser
        }
    }

    public String getArtistName(String filename) {
        int dash = filename.indexOf(" - ");
        return filename.substring(0, dash);
    }

    public String getTrackTitle(String filename) {
        int dash = filename.indexOf(" - ") + 3;
        int fileFormat = filename.lastIndexOf(".");
        return filename.substring(dash, fileFormat);
    }

    public String getParsedTrackLength(long lengthInSeconds) {
        long minutes = TimeUnit.SECONDS.toMinutes(lengthInSeconds);
        long seconds = lengthInSeconds - (minutes * 60);
        return String.format("%02d:%02d", minutes, seconds);
    }
}
