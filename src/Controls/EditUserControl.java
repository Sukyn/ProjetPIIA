package Controls;

import javafx.fxml.FXML;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EditUserControl {
    @FXML
    protected void openMenu(){}

    @FXML
    protected void addUser() throws IOException {
        String password = "";
        String role = "";
        String username = "";
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
            jsonObject.remove(username);
            file.write(jsonObject.toJSONString());
            file.flush();
            if (index == array.size() - 1) {
                JSONObject jsonObjectNew = new JSONObject();
                jsonObjectNew.put("username", username);
                jsonObjectNew.put("password", password);
                jsonObjectNew.put("role", role);
                file.write(jsonObjectNew.toJSONString());
                file.close();
            }

        }
    }

    @FXML
    protected void disconnect(){}

}