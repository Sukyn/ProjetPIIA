import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;


public class UserAccessControl {
    String username;
    boolean access;
    UserAccessControl(String username){
        this.username = username;
        this.access = false;
    }
    public void initialize(){
        labelUsername.setText(username);
    }
    @FXML
    Label labelUsername;
    @FXML
    ToggleButton buttonToggleAccess;
    @FXML
    protected void toggleAccess(){
        this.access = !this.access;
    }

}
