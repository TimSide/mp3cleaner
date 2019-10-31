import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

class AudioInformationParser {

    String parseFileName(String fileName) {
        if (!fileName.contains("-")) {
            return fileName;
        } else {
            return ""; // TODO: parser
        }
    }

    String getArtistName(String filename) {
        int dash = filename.indexOf(" - ");
        return filename.substring(0, dash);
    }

    String getTrackTitle(String filename) {
        int dash = filename.indexOf(" - ") + 3;
        return filename.substring(dash);
    }

    String getParsedTrackLength(long lengthInSeconds) {
        long minutes = TimeUnit.SECONDS.toMinutes(lengthInSeconds);
        long seconds = lengthInSeconds - (minutes * 60);
        return String.format("%02d:%02d", minutes, seconds);
    }
}
