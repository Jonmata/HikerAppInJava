package Controls;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Classes.ActiveUser;
import Classes.BackgroundsForwebsite;
import Classes.User;
import Classes.UserBag;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginViewControl implements Initializable{

	Parent root;
	Stage stage;
	Scene scene;
	
    @FXML
    private Button LoginButton;

    @FXML
    private Label SignUpLable;

    @FXML
    private PasswordField passwordText;

    @FXML
    private TextField userNametext;
    @FXML
    private VBox vboxOfLogin;
    
    @FXML
    void SwichTwoSignUp(MouseEvent event) throws IOException {

   		root=FXMLLoader.load(getClass().getResource("/Views/SignUpView.fxml"));
    	stage =(Stage)((Node) event.getSource()).getScene().getWindow();
    	scene =new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }

    @FXML
    void switchToMainView(ActionEvent event) throws IOException {
    	String usernametemp=userNametext.getText().toLowerCase().trim();
    	String passwordtemp= passwordText.getText();
    	if(!(usernametemp.isBlank()||passwordtemp.isBlank())) {
    		User tempUser =UserBag.getUserContainer().searchForUser(usernametemp,passwordtemp );
    		if(tempUser==null) {
    			Alert info = new Alert(AlertType.INFORMATION);
    			info.setContentText("Counldnt fine the user please check your Password\nor you could signup if you dont have a account with us");
    			info.show();
    		}else {
    			ActiveUser.setaUser(tempUser);
    			
    			root=FXMLLoader.load(getClass().getResource("/Views/MainView.fxml"));
    			stage =(Stage)((Node) event.getSource()).getScene().getWindow();
    			scene =new Scene(root);
    			stage.setScene(scene);
    			stage.show();
    		}

    	}else {
    		Alert info = new Alert(AlertType.INFORMATION);
			info.setContentText("dont leave any of the fields empty");
			info.show();
    	}
    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		vboxOfLogin.setBackground(BackgroundsForwebsite.getInstanceOfBackground().getFromList(1));

		
	}

}

