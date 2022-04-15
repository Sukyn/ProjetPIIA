import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToolBar;
import org.json.simple.JSONObject;

import java.io.IOException;

public class EditUserControl {

    public void initialize() throws IOException {
        for (Object o : VideoPlayer.usersArray){
            JSONObject j = (JSONObject) o;
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("UserView.fxml"));
            loader.setController(new UserViewControl(j.get("username").toString()));
            Parent p = loader.load();
            userList.getItems().add(p);
        }
        System.out.println(userList.getItems());

    }

    @FXML
    ToolBar userList;

    @FXML
    protected void openMenu() throws IOException {
        VideoPlayer.primaryStage.setScene(VideoPlayer.mainMenu);
    }

    @FXML
    protected void menuAddUser() throws IOException {
        Parent p = new FXMLLoader().load(this.getClass().getResource("MenuAddUser.fxml"));
        Scene scene = new Scene(p,640,400);
        VideoPlayer.primaryStage.setScene(scene);
    }



    @FXML
    protected void disconnect() throws IOException {
        VideoPlayer.setConnectedUser(null);
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("MenuAccueil.fxml"));
        VideoPlayer.mainMenu = new Scene(loader.load(),640,400);
        VideoPlayer.primaryStage.setScene(VideoPlayer.mainMenu);
    }

}