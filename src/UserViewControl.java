import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class UserViewControl {
    String username;
    UserViewControl(String username){
        this.username = username;
    }

    public void initialize(){
        labelUsername.setText(username);
    }


    @FXML
    protected void editUser(){

    }

    @FXML
    Label labelUsername;
    @FXML
    protected void removeUser() throws IOException {
        FileWriter file = new FileWriter("src/accounts.json");
        for (Object o : VideoPlayer.usersArray) {
            JSONObject j = (JSONObject) o;
            if (j.get("username").toString().equals(labelUsername.getText())) {
                VideoPlayer.usersArray.remove(j);
                file.write(VideoPlayer.usersArray.toJSONString());
                file.close();
                break;
            }
        }
        Parent menu = new FXMLLoader().load(this.getClass().getResource("MenuEditUser.fxml"));
        Scene scene = new Scene(menu,640,400);
        VideoPlayer.primaryStage.setScene(scene);
    }
}
