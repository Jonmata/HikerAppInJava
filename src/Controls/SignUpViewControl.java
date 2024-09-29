package Controls;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

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
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class SignUpViewControl implements Initializable {

	private Parent root;
	private Stage stage;
	private Scene scene;
	private Alert info;
    @FXML
    private PasswordField passwordCoonfirmation;

    @FXML
    private PasswordField passwordText;

    @FXML
    private TextField phoneNumberText;

    @FXML
    private Button signUpButton;

    @FXML
    private Label signUpLable;

    @FXML
    private TextField userNameTextFiled;

    @FXML
    private VBox signupVbox;
    @FXML
    void addUserToList(ActionEvent event) throws IOException, InterruptedException {

    	info = new Alert(AlertType.INFORMATION);
    	//getting the rest  of the info and making a new user adding them to the 
    	//UserBag
    	String username = userNameTextFiled.getText().trim();
    	String phone = phoneNumberText.getText();
    	if(username.isBlank()||phone.isBlank()) {
    		info.setContentText("Please full in all the text fileds to sign up");
    		info.show();
    		return;
    	}
    	//checks if the username is in use or not 
    	if(UserBag.getUserContainer().searchForUser(username)!=null)
    	{
    		info.setContentText("Please use a different username that username is in use");
    		info.show();
    		return;
    	}
    	//get password and check if both passwords entered is the same
    	String password = passwordText.getText();
    	String confirmPass = passwordCoonfirmation.getText();
    	if(!(password.equals(confirmPass))) {
    		info.setContentText("Paswords are not the same try agian");
    		info.show();
    		return;
    	}
    	//adds user to the tree
    	UserBag.getUserContainer().addUser(new User(username,password,phone));
    	//Tell the user that they have been add successfully
    	info.setContentText("You have been added successfully. ");
    	Optional<ButtonType> op = info.showAndWait();
    	
    	//changes scenes to the login scene
    	if(op.isPresent()) {	
    		root=FXMLLoader.load(getClass().getResource("/Views/LoginView.fxml"));
    		stage =(Stage)((Node) event.getSource()).getScene().getWindow();
    		scene =new Scene(root);
    		stage.setScene(scene);
    		stage.show();
    	}
    	
    	
    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		signupVbox.setBackground(BackgroundsForwebsite.getInstanceOfBackground().getFromList(2));
		
	}

}