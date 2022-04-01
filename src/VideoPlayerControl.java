import javafx.fxml.FXML;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class VideoPlayerControl {

    @FXML
    private MediaPlayer mediaPlayer;

    @FXML
    protected void loadVideo(String fileName) {
        mediaPlayer = new MediaPlayer(new Media(fileName));
    }

    @FXML
    protected void togglePlayPause() {
        if (mediaPlayer.getStatus().equals(MediaPlayer.Status.PLAYING)) {
            mediaPlayer.pause();
        } else {
            mediaPlayer.play();
        }
    }

    @FXML
    protected void previous() {
        mediaPlayer.seek(Duration.ZERO);
    }

    @FXML
    protected void next() {
        mediaPlayer.seek(mediaPlayer.getMedia().getDuration());
    }

    @FXML
    protected void modifyVolume(double newVolume) {
        mediaPlayer.setBalance(newVolume);
    }

    /* positionner la lecture à un instant donné de la vidéo grâce à un « slider » (vous
    pouvez vous inspirer de l’exemple donné sur
    https://www.geeksforgeeks.org/javafx-building-a-media-player/) */
    @FXML
    protected void navigateVideo(int newPosition) {

    }
}
