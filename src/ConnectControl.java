import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import org.json.simple.JSONObject;

import java.io.IOException;

public class ConnectControl {

    @FXML
    TextField username;
    @FXML
    TextField password;

    @FXML
    protected void validateConnexion() throws IOException {
        String username = this.username.getText();
        String password = this.password.getText();
        System.out.println(username);
        System.out.println(password);

        for (Object o : VideoPlayer.usersArray) {
            JSONObject j = (JSONObject) o;
            if (j.get("username").toString().equals(username) && j.get("password").toString().equals(password)) {

                VideoPlayer.setConnectedUser(username);
                if (j.get("role").toString().equals("parent")){
                    VideoPlayer.mainMenu = new Scene(FXMLLoader.load(this.getClass().getResource("MenuAccueilAdulte.fxml")), 640, 400);
                } else if (j.get("role").toString().equals("ado")){
                    VideoPlayer.mainMenu = new Scene(FXMLLoader.load(this.getClass().getResource("MenuAccueilAdo.fxml")), 640, 400);
                } else {
                    VideoPlayer.mainMenu = new Scene(FXMLLoader.load(this.getClass().getResource("MenuAccueil.fxml")), 640, 400);
                }
                VideoPlayer.primaryStage.setScene(VideoPlayer.mainMenu);
                break;
            }
        }

    }
}
