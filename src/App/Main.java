package App;

import Classes.Admin;
import Classes.Trails;
import Classes.TrailsBag;
import Classes.UserBag;
import Enum_Classes.Difficultylevel;
import Enum_Classes.TrailTypeE;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			Tools.Utils.backUp();
            System.out.println("Executing shutdown prosess: Cleanup and save data");
        }));
		//Restores the data from the last time the program has ran
		Tools.Utils.restore();
		
		//test trail dummies
		String[] trialNames = {"Bob","GreenDay","mayflower","GreenWoods"};
		if(TrailsBag.getTB().getTrailContainer().isEmpty())
			for(int i=0; i<4;i++) {
				TrailsBag.getTB().getTrailContainer().add(new Trails(trialNames[i],"a", Difficultylevel.easy , i, i ,TrailTypeE.loop));
			}
		
		//The hard codes admit user 
		if(!(UserBag.getUserContainer().getTree().containsKey("admin")))
				UserBag.getUserContainer().getTree().put("admin",new Admin("admin","SCCC" ,"631-276-6969" , true));
		
		launch(args);

		
	}

	@Override
	public void start(Stage mainStage) throws Exception {
		Parent root= FXMLLoader.load(getClass().getResource("/Views/LoginView.fxml"));
		mainStage.setScene(new Scene(root));
		mainStage.show();	
	}

}
