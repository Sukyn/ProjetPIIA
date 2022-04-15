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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class VideoPlayer extends Application {
    private MediaPlayer mediaPlayer;
    public static Stage primaryStage;
    public static Scene mainMenu;
    public static JSONObject connectedUser;
    public static JSONArray usersArray;
    public static JSONArray videoArray;

    @Override
    public void start(Stage primaryStage) throws IOException {
        VideoPlayer.primaryStage = primaryStage;
        try {
            FileReader f = new FileReader("src/accounts.json");
            usersArray = (JSONArray) new JSONParser().parse(f);
            System.out.println(usersArray);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            FileReader f = new FileReader("src/videos.json");
            videoArray = (JSONArray) new JSONParser().parse(f);
            System.out.println(videoArray);
        } catch (ParseException e) {
            e.printStackTrace();
        }
//Instantiating Media class
//Media media = new Media("");
//Instantiating MediaPlayer class
//Instantiating MediaView class
//by setting this property to true, the Video will be played
//Setting group and scene
        Parent menu = null;
        menu = FXMLLoader.load(this.getClass().getResource("MenuAccueil.fxml"));

        mainMenu = new Scene(menu,640,400);
        primaryStage.setScene(mainMenu);
        primaryStage.setTitle("Example video player");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    public static void setConnectedUser(String username){
        if (username == null){
            connectedUser = null;
        } else {
            for (Object o : usersArray) {
                JSONObject j = (JSONObject) o;
                if (j.get("username").toString().equals(username))
                    connectedUser = j;
            }
        }
    }


}