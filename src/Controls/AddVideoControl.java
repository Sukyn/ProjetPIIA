package Controls;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import javafx.fxml.FXML;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AddVideoControl {

    @FXML
    protected void openMenu() {

    }
    @FXML
    protected void validate() throws IOException {
        String name = "";
        String category = "";
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
                    file.write(jsonObject.toJSONString());
            file.flush();
            if (index == array.size() - 1) {
                JSONObject jsonObjectNew = new JSONObject();
                jsonObjectNew.put("name", name);
                jsonObjectNew.put("category", category);
                file.write(jsonObjectNew.toJSONString());
                file.close();
            }

        }
    }
}
