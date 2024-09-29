package Classes;

import java.io.Serializable;
import java.util.Map.Entry;
import java.util.TreeMap;

public class UserBag implements Serializable{

	private TreeMap<String,User> userBag;
	private static UserBag userContainer;
	
	private UserBag() {
		super();
		userBag= new TreeMap<>();
	}
	public static UserBag getUserContainer() {
		if(userContainer==null)
			userContainer=new UserBag();
		return userContainer;
		
	}
	
	public User searchForUser(String username,String password) {
		User temp =userBag.get(username.toLowerCase());
		if(temp==null) {
			return null;
		}else
		{
			if(temp.getPassword().equals(password))
				return temp;
			else
				return null;
			
		}
	}
	
	public void addUser(User user) {
		userBag.put(user.getUserName().toLowerCase(), user);
	}
	public static void setUserContainer(UserBag savedUserBag) {
		userContainer=savedUserBag;
		
	}
	public User searchForUser(String username) {
		return userBag.get(username.toLowerCase());
	}
	public TreeMap<String, User> getTree() {

		return userBag;
	}
	
	
}
