package Controls;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import Classes.ActiveUser;
import Classes.Admin;
import Classes.BackgroundsForwebsite;
import Classes.History;
import Classes.Reviews;
import Classes.Trails;
import Classes.TrailsBag;
import Classes.User;
import Classes.UserBag;
import Enum_Classes.Difficultylevel;
import Enum_Classes.TrailTypeE;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class MainViewControl implements Initializable {
    @FXML
    private TextField levelText;

    @FXML
    private Button removeTrailButton;
    @FXML
    private TextField typeText;
    @FXML
    private TextField trailNameText;
    @FXML
    private TextField lengthText;
	@FXML
	private TextField eleText;

    @FXML
    private Button addtrailButton;

    @FXML
    private TextField addyText;

    @FXML
    private Tab adminTab1;

    @FXML
    private Tab adminTab2;
    
    @FXML
    private TextField DateTextField;

    @FXML
    private Button DepromoteButton;

    @FXML
    private TextField DistanceWalkedTextField;

    @FXML
    private Label Followers;

    @FXML
    private TableView<History> HistoryDisplay;

    @FXML
    private TableColumn<User, String> PhoneNumberColumn;

    @FXML
    private Button PromoteButton;

    @FXML
    private Label ReviewList;

    @FXML
    private TableColumn<User, LinkedList<Reviews>> ReviewWroteColumn;

    @FXML
    private TextField TimeEndTextField;

    @FXML
    private TextField TimeStartTextField;

    @FXML
    private TextField TrialTextField;

    @FXML
    private TableView<User> UserDisplay;

    @FXML
    private Label UserNameLabelDisplay;

    @FXML
    private Button add_History_Button;

    @FXML
    private Button add_Review_Button;

    @FXML
    private TableColumn<Trails, String> address;

    @FXML
    private TableColumn<Trails, String> address1;

    @FXML
    private Label changePasswordLabel;

    @FXML
    private TableColumn<History, LocalDate> dateColumn;

    @FXML
    private TableView<Trails> display;

    @FXML
    private TableView<Trails> display1;

    @FXML
    private TableColumn<History, Double> distanceWalkedColumn;

    @FXML
    private Button editTrailButton;

    @FXML
    private TableColumn<Trails, Double> elev;

    @FXML
    private TableColumn<Trails, Double> elev1;

    @FXML
    private TableColumn<History, String> endColumn;

    @FXML
    private TableColumn<User, LinkedList<User>> followerColumn;

    @FXML
    private Label following;

    @FXML
    private TableColumn<User, LinkedList<User>> followingColumn;

    @FXML
    private TableColumn<Trails, Double> length;

    @FXML
    private TableColumn<Trails, Double> length1;

    @FXML
    private TableColumn<Trails, Difficultylevel> level;

    @FXML
    private TableColumn<Trails, Difficultylevel> level1;

    @FXML
    private Button removeFromHistoryButton;

    @FXML
    private TextField searchBar;

    @FXML
    private Button searchButton;

    @FXML
    private TableColumn<History, String> startTimeColumn;

    @FXML
    private VBox trailHVbox;

    @FXML
    private TableColumn<Trails, String> trailNames;

    @FXML
    private TableColumn<Trails, String> trailNames1;

    @FXML
    private TableColumn<Trails, TrailTypeE> trailType;

    @FXML
    private TableColumn<Trails, TrailTypeE> trailType1;

    @FXML
    private VBox trialAVbox;

    @FXML
    private TableColumn<History, String> trialNameculumn;

    @FXML
    private VBox trialSVbox;

    @FXML
    private TableColumn<User, String> userNameColumn;
    

    @FXML
    private TableColumn<User, Class<?>> userTypeColumn;

    @FXML
    private Button viewReviewButton;
    

    @FXML
    void addtrailbuttonClicked(ActionEvent event) {
    	String tN =trailNameText.getText();
    	String tT=typeText.getText();
    	String lT=lengthText.getText();
    	String eT= eleText.getText();
    	String add = addyText.getText();
    	String lv = levelText.getText();
        
    	if(tN.isBlank()||tT.isBlank()||lT.isBlank()||eT.isBlank()||add.isBlank()||lv.isBlank()) {
    		messageToUser("Cant leave any fileds blank to add to a new trail");
    		return;
    	}else
    	{
    		try {
    		double len,ele;
    			len= Double.parseDouble(lT);
    			ele=Double.parseDouble(eT);
    			Difficultylevel dl = Difficultylevel.easy.getDifficulty(lv);
    			TrailTypeE tTE = TrailTypeE.loop.getType(tT);
    			if(dl==null||tTE==null) {
    				messageToUser("You have to enter a difficulty level of hard, easy or moderate\nAnd for Trail Type enter loop, out_and_back or point_to_point");
    				return;
    			}
    			TrailsBag.getTB().getTrailContainer().add(new Trails(tN,add,dl,len,ele,tTE));
    			checkAdminTrailTableUpdate();
    		}catch(NumberFormatException e) {
    			messageToUser("The length and elevation textFileds cant have words in them only numbers");
    			return;
    		}
    	}
    }
    
    @FXML
    void revomeTrailButtonCliked(ActionEvent event) {

    	Trails t = display1.getSelectionModel().getSelectedItem();
    	if(t==null) {
    		messageToUser("Choose a trail from the table view to remove a trial");
    		return;
    	}else {
    		TrailsBag.getTB().getTrailContainer().remove(t);
    		checkAdminTrailTableUpdate();
    		return;
    	}
    }

    @FXML
    void PromoteAUser(ActionEvent event) {

    	User use= UserDisplay.getSelectionModel().getSelectedItem();
    	//false because there can only be one primary Admin
    	if(use!=null) {
    		UserBag.getUserContainer().getTree().replace(use.getUserName(), use, new Admin(use,false));
    		checkAdminUserTableUpdate();
    		messageToUser("user Promoted");
    	}else {
    		messageToUser("choose a user in the user table");
    	}
    	
    }

    @FXML
    void addReviewToTrialHistory(ActionEvent event) {

    	History chosen = HistoryDisplay.getSelectionModel().getSelectedItem();
    	
    	if(chosen==null) {
    		messageToUser("Please select a item to give it a review");
    		return;
    	}
    	TextInputDialog tID = new TextInputDialog();
    	tID.setTitle("Write the Review");
    	tID.setHeaderText("enter the text here");
    	String userWrite; 
    	while(true) {
    		Optional<String> userText = tID.showAndWait();
    	
    		if(userText.isPresent()) {
    			userWrite=userText.get();
    			break;
    		}
    	}
    	List<Integer> numberList = List.of(1, 2, 3, 4, 5);
        ChoiceDialog<Integer> numberDialog = new ChoiceDialog<>(numberList.get(0), numberList);
        numberDialog.setTitle("Trails rating");
        numberDialog.setHeaderText("Please select a number of stars:");
        while(true) {
        	Optional<Integer> numberResult = numberDialog.showAndWait();
        	if(numberResult.isPresent()) {
        		ActiveUser.getaUser().getReviews().add(new Reviews(ActiveUser.getaUser().getUserName(),userWrite,numberResult.get()));
        		chosen.getTrailWalked().addReview(new Reviews(ActiveUser.getaUser().getUserName(),userWrite,numberResult.get()));
        		return;
        	}
        }
    }

    @FXML
    void addToTableHistory(ActionEvent event) {

    	String temptrail = TrialTextField.getText();
    	String tempLength = DistanceWalkedTextField.getText();
    	String tempDate = DateTextField.getText();
    	String tempStart = TimeStartTextField.getText();
    	String  tempEnd = TimeEndTextField.getText();
    	
    	if(!(temptrail.isBlank()||tempLength.isBlank()||tempStart.isBlank()||tempEnd.isBlank()||tempDate.isBlank()))
    	{
    		try {
    	
    		LocalDate temp = checkDateFormat(tempDate);
    		if(TrailsBag.getTB().search(temptrail).isPresent()&&!(temp==null)) {
    			ActiveUser.getaUser().getHikingHistory().add(new History(
    				TrailsBag.getTB().search(temptrail).get(),Double.parseDouble(tempLength),temp,tempStart,tempEnd
    				));
    			checkHistoryTableUpdate();
    		}else{
    			messageToUser("Check all your fields and make  sure the trial name is spelled corectly or date is corectly formated");
    			return;
    		}
    		}catch(Exception e) {
    			messageToUser("Check all your fields and make  sure the length waked is a number");
    			return;
    		}
    	}else {
			messageToUser("Check all your fields ");
			return;
    	}
    }

    @FXML
    void changePassword(MouseEvent event) {

    	TextInputDialog info = new TextInputDialog();
    	info.setTitle("Change your password");
    	info.setContentText("New Password:");
    	Optional<String>user = info.showAndWait();
    	if(user.isPresent()) {
    		ActiveUser.getaUser().setPassword(user.get());
    	}else {
    		return;
    	}
 
    	
    }

    @FXML
    void changeUserName(MouseEvent event) {

    	TextInputDialog info = new TextInputDialog();
    	info.setTitle("Change your UserName");
    	info.setContentText("New username:");
    	Optional<String>user = info.showAndWait();
    	if(user.isPresent()) {
    		UserBag.getUserContainer().getTree().put(user.get(), ActiveUser.getaUser());
    		UserBag.getUserContainer().getTree().remove(ActiveUser.getaUser().getUserName());
    		ActiveUser.getaUser().setUserName(user.get());
    		UserNameLabelDisplay.setText(ActiveUser.getaUser().getUserName());
    	}else {
    		return;
    	}
    	
    }

    @FXML
    void depromoteAdmin(ActionEvent event) {

    	User use = UserDisplay.getSelectionModel().getSelectedItem();
    	if(use.getUserName().equalsIgnoreCase("admin")) {
    		messageToUser("You can't demote yourself");
    		return; 
    	}
    	UserBag.getUserContainer().getTree().remove(use.getUserName());
    	UserBag.getUserContainer().addUser(new User(use.getUserName(), use.getPassword(), use.getPhoneNumber(),
    			use.getFollowing(), use.getFollowers(), use.getHikingHistory(), use.getReviews()));
    	checkAdminUserTableUpdate();
    }

    @FXML
    void lookAtReviewsSearchTab(ActionEvent event) {

    	Trails userChoosen= display.getSelectionModel().getSelectedItem();
    	if(userChoosen==null) {
    		messageToUser("Please choose a trail");
    		return;
    	}
    	ObservableList<Reviews> rList = FXCollections.observableArrayList(userChoosen.getReviews());
    	ListView<Reviews> lV = new ListView<>(rList);
    	Alert reviews = new Alert(AlertType.INFORMATION);
    	reviews.setTitle("The reviews it has: ");
		reviews.setHeaderText("choose a review and press follow to follow the user \n You can't follow yourself:");
    	reviews.getDialogPane().setContent(lV);
    	reviews.getButtonTypes().addAll(new ButtonType("Follow Back"));
    	if(lV!=null) {
    	while(true) {
    		Optional<ButtonType> op = reviews.showAndWait();
    		if(op.get()!=ButtonType.OK) {
    			Reviews chosen = lV.getSelectionModel().getSelectedItem();
    			if(chosen!=null)
    				if(!chosen.getUserName().equalsIgnoreCase(ActiveUser.getaUser().getUserName())) {
    					ActiveUser.getaUser().addToFollowing(UserBag.getUserContainer().getTree().get(chosen.getUserName()));
    					UserBag.getUserContainer().getTree().get(chosen.getUserName()).addToFollowers(ActiveUser.getaUser());
    					return;
    				}
    		}else if(op.get()==ButtonType.OK) {
    			reviews.close();
    			return; 
    		}
    	}
    	}
    	
    }
    @FXML
    void removeHistoryButtonCliked(ActionEvent event) {

    	History chosen =HistoryDisplay.getSelectionModel().getSelectedItem();
    	if(chosen==null) {
    		messageToUser("You need to choose a history to remove");
    	}else {
    		ActiveUser.getaUser().getHikingHistory().remove(chosen);
    		checkHistoryTableUpdate();
    	}
    }

    @FXML
    void searchButtonCliked(ActionEvent event) {

    	String temp = searchBar.getText();
    	if(temp.isBlank()) {
    		messageToUser("Enter something in the search bar");
    		return;
    	}else {
    		try {
    			double testNum= Double.parseDouble(temp);
    			List<Trails> list = TrailsBag.getTB().search(s->s.getElev()<=testNum||s.getLength()<=testNum).collect(Collectors.toList());
				ObservableList<Trails> op = FXCollections.observableArrayList(list);
				checkSearchTableUpdate(op);
				return;
    			
    		}catch(Exception e) {
    			Difficultylevel lev= Difficultylevel.easy.getDifficulty(temp);
    			TrailTypeE type= TrailTypeE.loop.getType(temp);
    			if(lev==null&&type==null) {
    				List<Trails> list = TrailsBag.getTB().search(s->s.getAddress().contains(temp)||s.getTrailNames().contains(temp)).collect(Collectors.toList());
    				ObservableList<Trails> op = FXCollections.observableArrayList(list);
    				checkSearchTableUpdate(op);
    				return;
    			}else if(lev==null) {
    				List<Trails> list = TrailsBag.getTB().search(s->s.getTrailType().equals(type)).collect(Collectors.toList());
    				ObservableList<Trails> op = FXCollections.observableArrayList(list);
    				checkSearchTableUpdate(op);
    				return;
    			}else {
    				List<Trails> list = TrailsBag.getTB().search(s->s.getLevel().equals(lev)).collect(Collectors.toList());
    				ObservableList<Trails> op = FXCollections.observableArrayList(list);
    				checkSearchTableUpdate(op);
    				return;
    			}
    		}
    	}
    }

    @FXML
    void showTheUsersReviews(MouseEvent event) {

    	ObservableList<Reviews> rList = FXCollections.observableArrayList(ActiveUser.getaUser().getReviews());
    	ListView<Reviews> lV = new ListView<>(rList);
    	
    	Alert reviews = new Alert(AlertType.INFORMATION);
    	reviews.setTitle("Your Reviews");
    	reviews.getDialogPane().setContent(lV);
    	reviews.showAndWait();
    }

    @FXML
    void showUsersFollowers(MouseEvent event) {

    	ObservableList<User> foList = FXCollections.observableArrayList(ActiveUser.getaUser().getFollowers());
    	ListView<User> lV = new ListView<>(foList);
    	
    	Alert followers = new Alert(AlertType.INFORMATION);
    	followers.setTitle("Your Followers");
    	followers.getDialogPane().setContent(lV);
    	followers.getButtonTypes().add(new ButtonType("Block User"));
    	while(true) {
    		Optional<ButtonType> op=followers.showAndWait();
    		if(op.get()!=ButtonType.OK) {
    			User userBlock= lV.getSelectionModel().getSelectedItem();
    			if(userBlock!=null) {
    				UserBag.getUserContainer().getTree().get(userBlock.getUserName()).getFollowing().remove(ActiveUser.getaUser());
    				ActiveUser.getaUser().getFollowers().remove(UserBag.getUserContainer().getTree().get(userBlock.getUserName()));
    				followers.close();
    			}
    		}else if(op.get()==ButtonType.OK) {
    			followers.close();
    			return; 
    		}
    	}
    	
    }

    @FXML
    void showUsersFollowing(MouseEvent event) {

    	ObservableList<User> fList = FXCollections.observableArrayList(ActiveUser.getaUser().getFollowing());
    	ListView<User> lV = new ListView<>(fList);
    	
    	Alert following = new Alert(AlertType.INFORMATION);
    	following.setTitle("Who you are Following");
    	following.getDialogPane().setContent(lV);
    	following.showAndWait();
    }
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//set background picture
		trailHVbox.setBackground(BackgroundsForwebsite.getInstanceOfBackground().getFromList(3));
		trialAVbox.setBackground(BackgroundsForwebsite.getInstanceOfBackground().getFromList(4));
		trialSVbox.setBackground(BackgroundsForwebsite.getInstanceOfBackground().getFromList(5));
		UserNameLabelDisplay.setText(ActiveUser.getaUser().getUserName());
		
		//table view of the search 
		ObservableList<Trails> observableList = FXCollections.observableArrayList(TrailsBag.getTB().getTrailContainer());
		checkSearchTableUpdate(observableList );
		
		//table view for the history 
		checkHistoryTableUpdate();
		
		//check if the user is a admin or regular user
		if(ActiveUser.getaUser().getClass()==Admin.class) {
			adminTab1.setDisable(false);
			adminTab2.setDisable(false);
			checkAdminTrailTableUpdate();
			checkAdminUserTableUpdate();
			if(((Admin) ActiveUser.getaUser()).isItPrimaryAdmin()) {
				DepromoteButton.setDisable(false);
			}
		}
		
	}
    //table view for admin trails
    private void checkAdminTrailTableUpdate() {
		ObservableList<Trails> observableList = FXCollections.observableArrayList(TrailsBag.getTB().getTrailContainer());
		trailNames1.setCellValueFactory(new PropertyValueFactory<Trails,String>("trailNames"));
		address1.setCellValueFactory(new PropertyValueFactory<Trails,String>("Address"));
		level1.setCellValueFactory(new PropertyValueFactory<Trails,Difficultylevel>("level"));
		length1.setCellValueFactory(new PropertyValueFactory<Trails,Double>("Length"));
		elev1.setCellValueFactory(new PropertyValueFactory<Trails,Double>("Elev"));
		trailType1.setCellValueFactory(new PropertyValueFactory<Trails,TrailTypeE>("trailType"));
		display1.setItems(observableList);
	}
    //table view for admin users
    private void checkAdminUserTableUpdate() {
    	ObservableList<User> observableList =FXCollections.observableArrayList(UserBag.getUserContainer().getTree().values());
		userTypeColumn.setCellValueFactory(new PropertyValueFactory<User,Class<?>>("thisClass"));
		userNameColumn.setCellValueFactory(new PropertyValueFactory<User,String>("userName"));
		PhoneNumberColumn.setCellValueFactory(new PropertyValueFactory<User,String>("phoneNumber"));
		followerColumn.setCellValueFactory(new PropertyValueFactory<User,LinkedList<User>>("followers"));
		followingColumn.setCellValueFactory(new PropertyValueFactory<User,LinkedList<User>>("following"));
		ReviewWroteColumn.setCellValueFactory(new PropertyValueFactory<User,LinkedList<Reviews>>("Reviews"));
		UserDisplay.setItems(observableList);
    }
	//table view for search
	private void checkSearchTableUpdate(ObservableList<Trails> observableList2) {
		trailNames.setCellValueFactory(new PropertyValueFactory<Trails,String>("trailNames"));
		address.setCellValueFactory(new PropertyValueFactory<Trails,String>("Address"));
		level.setCellValueFactory(new PropertyValueFactory<Trails,Difficultylevel>("level"));
		length.setCellValueFactory(new PropertyValueFactory<Trails,Double>("Length"));
		elev.setCellValueFactory(new PropertyValueFactory<Trails,Double>("Elev"));
		trailType.setCellValueFactory(new PropertyValueFactory<Trails,TrailTypeE>("trailType"));
		display.setItems(observableList2);
	}
	//table view for the history 
	private void checkHistoryTableUpdate() {
		ObservableList<History> oL = FXCollections.observableArrayList(ActiveUser.getaUser().getHikingHistory());
		if( !oL.isEmpty()) {
			trialNameculumn.setCellValueFactory(new PropertyValueFactory<History,String>("trailName"));
			distanceWalkedColumn.setCellValueFactory(new PropertyValueFactory<History,Double>("DistanceWalked"));
			dateColumn.setCellValueFactory(new PropertyValueFactory<History,LocalDate>("date"));
			startTimeColumn.setCellValueFactory(new PropertyValueFactory<History,String>("StartTime"));
			endColumn.setCellValueFactory(new PropertyValueFactory<History,String>("EndTime"));
		}
		
		HistoryDisplay.setItems(oL);
	}

	private void messageToUser(String str) {
		Alert info =new Alert(AlertType.INFORMATION);
		info.setContentText(str);
		info.show();
	}
	
    //Checks if the date they entered is in the correct format
    private LocalDate checkDateFormat(String tempdate) {
    	LocalDate ld =null;
    	DateTimeFormatter form = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    	try {
    		ld = LocalDate.parse(tempdate,form);
    		if(ld.format(form).equals(tempdate)) {
    			return ld; 
    		}
    	}catch(DateTimeParseException exp) {
    		return null;
    	}
    	return null;
    	
    }
	

}