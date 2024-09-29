package Classes;

import javafx.scene.layout.Background;

public class BackgroundsForwebsite{

	private Background[] backgrounds ;
	private static int elenum;
	private static BackgroundsForwebsite background;
	private BackgroundsForwebsite() {
		backgrounds = new Background[6];
		elenum=0;
	}
	
	public static BackgroundsForwebsite getInstanceOfBackground() {
		if(background==null) {
			background=new BackgroundsForwebsite();
		}
		return background;
		
	}
	public static void setInstanceOfBackground(BackgroundsForwebsite set) {
		background=set; 

		
	}
	public void addToList(Background b) {
		backgrounds[elenum++]=b;
	}
	public Background getFromList(int i) {
		return backgrounds[i-1];
	}
}
