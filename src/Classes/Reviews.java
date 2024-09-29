package Classes;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Objects;

public class Reviews implements Serializable{

	private String userName; 
	private LinkedList<String> comment= new LinkedList<>();
	private LocalDateTime timePost;
	private int rateing; 
	
	public Reviews(String name,String com, int rate) {
		userName=name; 
		rateing=rate;
		comment.add(com);
		timePost=LocalDateTime.now();
	}

	public LinkedList<String> getComment() {
		return comment;
	}

	public int getRateing() {
		return rateing;
	}

	public void setComment(LinkedList<String> comment) {
		this.comment = comment;
	}

	public void setRateing(int rateing) {
		this.rateing = rateing;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setTimePost(LocalDateTime timePost) {
		this.timePost = timePost;
	}

	@Override
	public String toString() {
		DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		return "Reviews userName=" + userName + ", comment=" + comment + ", timePost=" + timePost.format(form) + ", rateing="
				+ rateing+(char)(9733) + "]";
	}

	

	
	
	
	
}
