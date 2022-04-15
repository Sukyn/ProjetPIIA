import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.media.Media;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;

public class MenuControl {
    @FXML
    TextField searchField;

    @FXML
    ListView videoList;
    @FXML
    Button buttonConnexion;
    @FXML
    Button buttonValidateConnexion;
    @FXML
    Button buttonAccount;
    @FXML
    ToggleButton buttonToggleMode;
    @FXML
    Button buttonAddVideo;

    public void initialize() throws IOException {
        for (Object o : VideoPlayer.videoArray) {
            JSONObject j = (JSONObject) o;
            JSONArray allowedUserList = (JSONArray) j.get("userList");
            boolean isAllowed = false;
            if (VideoPlayer.connectedUser != null){
                for (Object name : allowedUserList) {
                    if (name.toString().equals("everyone") || name.toString() == VideoPlayer.connectedUser.get("username")){
                        isAllowed = true;
                        break;
                    }
                }
                if (VideoPlayer.connectedUser.get("role").toString().equals("parent"))
                    isAllowed = true;

            } else {
                for (Object name : allowedUserList) {
                    if (name.toString().equals("everyone")){
                        isAllowed = true;
                        break;
                    }
                }
            }
            if (isAllowed)
                videoList.getItems().add(j.get("name"));
        }
        System.out.println(videoList.getItems());

    }

    @FXML
    protected void addVideo() throws IOException {
        FXMLLoader l = new FXMLLoader();
        AddVideoControl controller = new AddVideoControl();
        l.setController(controller);
        Parent p = l.load(this.getClass().getResource("MenuAddVideo.fxml"));
        Scene scene = new Scene(p,640,400);
        VideoPlayer.primaryStage.setScene(scene);
        // Ca en fait ca devrait ouvrir un autre menu, le code c'est pour validate
    }

    @FXML
    protected void openVideo() throws IOException {
        System.out.println(videoList.getSelectionModel().getSelectedItem());
        if (videoList.getSelectionModel().getSelectedItem() != null){
            for (Object o: VideoPlayer.videoArray) {
                JSONObject j = (JSONObject) o;
                if (videoList.getSelectionModel().getSelectedItem() == j.get("name")) {
                    FXMLLoader loader = new FXMLLoader(this.getClass().getResource("MenuVideoPlayer.fxml"));
                    loader.setController(new VideoPlayerControl(new Media(j.get("link").toString())));
                    Scene scene = new Scene(loader.load(), 640, 400);
                    VideoPlayer.primaryStage.setScene(scene);
                }

            }

        }
    }

    @FXML
    protected void switchMode() {
        // Change le mode
    }

    @FXML
    protected void openAccount() throws IOException {
        // Ouvre un compte
        Scene scene;
        if (VideoPlayer.connectedUser.get("role").toString().equals("parent")) {
            FXMLLoader l = new FXMLLoader();
            l.setController(new EditUserControl());
            scene = new Scene(l.load(this.getClass().getResource("MenuEditUser.fxml")),640,400);
        } else {
            scene = new Scene(FXMLLoader.load(this.getClass().getResource("MenuEditUserAdo.fxml")),640,400);
        }
        VideoPlayer.primaryStage.setScene(scene);
    }

    @FXML
    protected void connect() throws IOException {
        // page de connexion
        Scene scene = new Scene(FXMLLoader.load(this.getClass().getResource("MenuConnect.fxml")),640,400);
        VideoPlayer.primaryStage.setScene(scene);
    }
}
