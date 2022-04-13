package MainClasses;
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

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;

public class VideoPlayer extends Application {
    private MediaPlayer mediaPlayer;
    public static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        VideoPlayer.primaryStage = primaryStage;
//Instantiating Media class
//Media media = new Media("");
//Instantiating MediaPlayer class
//Instantiating MediaView class
//by setting this property to true, the Video will be played
//Setting group and scene
        Parent p = null;
        try {
            p = FXMLLoader.load(getClass().getResource("/home/julien/Documents/S6/piia/ProjetPIIA/src/interfaces/MenuAccueil.fxml"));
        } catch (IOException e) {}
        Scene scene = new Scene(p,500,400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Example video player");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }


}