/*import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class View extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Exemple FXML");
        //R�cup�re la description de la vue dans le fichier FXML
        GridPane myPane = (GridPane) FXMLLoader.load(getClass().getResource("testSceneBuilder.fxml"));
        Scene myScene = new Scene(myPane, 234*4, 80*5);
        primaryStage.setScene(myScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
*/
import java.io.File;
import javafx.util.Duration;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.Group;
import javafx.scene.Scene;
public class VideoPlayer extends Application {
    private MediaPlayer mediaPlayer;

    @Override
    public void start(Stage primaryStage) throws Exception {
        String videoPath = "C:\\IIA\\video\\test_video.mp4";
        String videoFileURIStr = new
                File(videoPath).toURI().toString();
//Instantiating Media class
        Media activeVideo = new Media(videoFileURIStr);
//Media media = new Media("");
//Instantiating MediaPlayer class
        this.mediaPlayer = new MediaPlayer(activeVideo);
//Instantiating MediaView class
        MediaView mediaView = new MediaView(mediaPlayer);
//by setting this property to true, the Video will be played
        mediaPlayer.setAutoPlay(true);
//Setting group and scene
        Group root = new Group();
        root.getChildren().add(mediaView);
        Scene scene = new Scene(root,500,400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Example video player");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }


}