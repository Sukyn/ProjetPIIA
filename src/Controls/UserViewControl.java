package Controls;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UserViewControl {


    @FXML
    protected void editUser(){

    }

    @FXML
    Label labelUsername;
    @FXML
    protected void removeUser() throws IOException {
        String username = labelUsername.getText();
        Object obj = null;
        try {
            obj = JSONValue.parse(new FileReader("accounts.JSON"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        JSONArray array = (JSONArray) obj;
        FileWriter file = new FileWriter("accounts.JSON");
        for (int index = 0; index < array.size(); ++index) {
            JSONObject jsonObject = (JSONObject) array.get(index);
            if (jsonObject.get("username") != username) {
                file.write(jsonObject.toJSONString());
                file.flush();
            }
            if (index == array.size() - 1)
                file.close();
        }
    }
}
