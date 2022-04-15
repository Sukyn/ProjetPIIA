import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class AddUserControl {
    @FXML
    TextField username;
    @FXML
    TextField password;
    @FXML
    TextField role;
    @FXML
    protected void addUser() throws IOException {

        FileWriter file = new FileWriter("src/accounts.json");
        JSONObject jsonObjectNew = new JSONObject();
        jsonObjectNew.put("username", username.getText());
        jsonObjectNew.put("password", password.getText());
        jsonObjectNew.put("role", role.getText());
        VideoPlayer.usersArray.add(jsonObjectNew);
        System.out.println(VideoPlayer.usersArray);
        file.write(VideoPlayer.usersArray.toJSONString());
        file.close();


        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("MenuEditUser.fxml"));
        Scene scene = new Scene(loader.load(),640,400);
        VideoPlayer.primaryStage.setScene(scene);
    }
}
