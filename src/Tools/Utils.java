package Tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import Classes.BackgroundsForwebsite;
import Classes.TrailsBag;
import Classes.UserBag;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;



public class Utils {

	public static void backUp() {
		try{
			FileOutputStream fileOutputStream = new FileOutputStream("BackUpFile/saveFile.dat");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(UserBag.getUserContainer());
			objectOutputStream.writeObject(TrailsBag.getTB());
			objectOutputStream.close();
			}catch(IOException e){
			  e.printStackTrace();
			}
	}
	
	public static void restore() {
		
        File directoryPath = new File("/Users/jonathanmata/eclipse-workspace/fall2023DataStructures/HikerApp_FinalProject_Mata_Not_Working/picture");

        File[] filesList = directoryPath.listFiles();

        for (File file : filesList) {
            try {
                // Create Image from file
                Image image = new Image(file.toURI().toString());

                // Set up background image
                BackgroundImage backgroundImage = new BackgroundImage(
                    image,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.DEFAULT,
                    BackgroundSize.DEFAULT
                );

                // Add to background list
                BackgroundsForwebsite.getInstanceOfBackground().addToList(new Background(backgroundImage));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
	
		
		try {			
			FileInputStream fi = new FileInputStream("BackUpFile/saveFile.dat");
			ObjectInputStream oi = new ObjectInputStream(fi);
			UserBag.setUserContainer((UserBag) oi.readObject());
			TrailsBag.setTB((TrailsBag) oi.readObject());
			oi.close();
		}  catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	

}