package Classes;

import java.io.Serializable;
import java.util.LinkedList;

import javafx.scene.Node;

public class User implements Serializable{

	private String userName,password,phoneNumber;
	private LinkedList<User> followers, following;
	private LinkedList<History> hikingHistory;
	private LinkedList<Reviews> reviewsWrote; 
	public User(String userName, String password, String phoneNumber) {
		super();
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		followers=new LinkedList<>();
		following=new LinkedList<>();
		hikingHistory=new LinkedList<>();
		reviewsWrote= new LinkedList<>();
	}
	public User(User use) {
		this.userName = use.getUserName();
		this.password = use.getPassword();
		this.phoneNumber = use.getPhoneNumber();
		this.followers=use.getFollowers();
		this.following=use.getFollowing();
		this.hikingHistory=use.getHikingHistory();
		this.reviewsWrote=use.getReviews();
	}
	public User(String userName2, String password2, String phoneNumber2, LinkedList<User> following2,
			LinkedList<User> followers2, LinkedList<History> hikingHistory2, LinkedList<Reviews> reviews) {
		userName=userName2;
		password=password2;
		phoneNumber=phoneNumber2;
		following=following2;
		followers=followers2;
		hikingHistory=hikingHistory2;
		reviewsWrote= reviews; 
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public LinkedList<User> getFollowers() {
		return followers;
	}

	public LinkedList<User> getFollowing() {
		return following;
	}

	public Class<?> getThisClass() {
		return this.getClass();
	}
	public LinkedList<History> getHikingHistory() {
		return hikingHistory;
	}
	public void addToFollowers(User user) {
		followers.add(user);
	}
	public void addToFollowing(User user) {
		following.add(user);
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", phoneNumber=" + phoneNumber
				+ ", hikingHistory=" + hikingHistory + "]";
	}
	public LinkedList<Reviews> getReviews() {
		return reviewsWrote;
	}
	
}
