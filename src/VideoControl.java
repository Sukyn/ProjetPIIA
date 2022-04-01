import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class VideoControl {

    @FXML
    private MediaPlayer mediaPlayer;

    @FXML
    protected void loadVideo(String fileName) {
        mediaPlayer = new MediaPlayer(new Media(fileName));
    }

    @FXML
    protected void runVideo() {
        mediaPlayer.play();
    }

    @FXML
    protected void pauseVideo() {
        mediaPlayer.pause();
    }

    @FXML
    protected void goToStart() {
        mediaPlayer.seek(Duration.ZERO);
    }

    @FXML
    protected void goToEnd() {
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
