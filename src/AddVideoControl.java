import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.stage.FileChooser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AddVideoControl {
    ArrayList<UserAccessControl> userAccessControls;
    @FXML
    Media video;
    @FXML
    ToolBar userAccessList;
    @FXML
    ToggleButton buttonToggleAccess;
    @FXML
    Label labelUsername;
    public void initialize() throws IOException {
        userAccessControls = new ArrayList<>();
        FXMLLoader loader;
        for (Object o : VideoPlayer.usersArray) {
            JSONObject j = (JSONObject) o;
            if (j.get("role").toString().equals("ado")) {
                loader = new FXMLLoader(this.getClass().getResource("UserAccessView.fxml"));
                UserAccessControl controler = new UserAccessControl(j.get("username").toString());
                loader.setController(controler);
                Parent p = loader.load();
                System.out.println(p);
                userAccessList.getItems().add(p);
                userAccessControls.add(controler);
            }
        }
        loader = new FXMLLoader(this.getClass().getResource("UserAccessView.fxml"));
        UserAccessControl controler = new UserAccessControl("everyone");
        loader.setController(controler);
        Parent p = loader.load();
        System.out.println(p);
        userAccessList.getItems().add(p);
        userAccessControls.add(controler);
        System.out.println(userAccessList.getItems());
        videoTitle.textProperty().bind(videoTitleProperty);
    }

    private final StringProperty videoTitleProperty = new SimpleStringProperty("None");
    public StringProperty VideoTitleProperty() {
        return videoTitleProperty ;
    }

    public final String getVideoTitleProperty() {
        return VideoTitleProperty().get();
    }

    public final void setVideoTitleProperty(String position) {
        VideoTitleProperty().set(position);
    }

    @FXML
    TextArea videoDescription;

    @FXML
    protected void openMenu() {
        VideoPlayer.primaryStage.setScene(VideoPlayer.mainMenu);
    }
    @FXML
    protected void validate() throws IOException {
        String name = videoTitle.getText();
        String link = video.getSource();
        String description = videoDescription.getText();

        FileWriter file = new FileWriter("src/videos.json");
        JSONObject vid = new JSONObject();
        vid.put("name",name);
        vid.put("link", link);
        vid.put("description", description);
        JSONArray allowedUsers = new JSONArray();
        for (UserAccessControl u : userAccessControls) {
            if (u.access){
                allowedUsers.add(u.username);
            }
        }
        vid.put("userList", allowedUsers);
        for (Object o: VideoPlayer.videoArray) {
            JSONObject j = (JSONObject) o;
            if (j.get("name").toString().equals(name)){
                VideoPlayer.videoArray.remove(o);
                break;
            }
        }
        VideoPlayer.videoArray.add(vid);
        file.write(VideoPlayer.videoArray.toJSONString());
        file.close();
        if (VideoPlayer.connectedUser.get("role").toString().equals("parent")){
            VideoPlayer.mainMenu = new Scene(FXMLLoader.load(this.getClass().getResource("MenuAccueilAdulte.fxml")), 640, 400);
        } else if (VideoPlayer.connectedUser.get("role").toString().equals("ado")){
            VideoPlayer.mainMenu = new Scene(FXMLLoader.load(this.getClass().getResource("MenuAccueilAdo.fxml")), 640, 400);
        } else {
            VideoPlayer.mainMenu = new Scene(FXMLLoader.load(this.getClass().getResource("MenuAccueil.fxml")), 640, 400);
        }
        VideoPlayer.primaryStage.setScene(VideoPlayer.mainMenu);
    }


    @FXML
    ImageView videoMiniature;
    @FXML
    Label videoTitle;
    @FXML
    protected void selectVideo() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");

        if (fileChooser != null){
            File f = fileChooser.showOpenDialog(VideoPlayer.primaryStage);
            video = new Media(f.toURI().toString());
            System.out.println(video);
            setVideoTitleProperty(f.getName());
        }
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("MenuAddVideo.fxml"));
        loader.setController(this);
        Scene scene = new Scene(loader.load(),640,400);
        VideoPlayer.primaryStage.setScene(scene);
    }


}
