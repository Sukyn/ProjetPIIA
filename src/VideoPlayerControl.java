import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollBar;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class VideoPlayerControl {
    Media video;
    VideoPlayerControl(Media video){
        this.video = video;
    }

    public void initialize(){
        loadVideo(this.video.getSource());
        videoView.setMediaPlayer(mediaPlayer);
        this.togglePlayPause();
        System.out.println(volumeBar.getValue());
        volumeBar.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {mediaPlayer.setVolume(new_val.doubleValue());});
    }

    @FXML
    private MediaPlayer mediaPlayer;
    @FXML
    MediaView videoView;

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
    ScrollBar volumeBar;

    /* positionner la lecture à un instant donné de la vidéo grâce à un « slider » (vous
    pouvez vous inspirer de l’exemple donné sur
    https://www.geeksforgeeks.org/javafx-building-a-media-player/) */
    @FXML
    protected void navigateVideo(int newPosition) {
    }

    @FXML
    protected void openMenu() {
        VideoPlayer.primaryStage.setScene(VideoPlayer.mainMenu);
    }

}
