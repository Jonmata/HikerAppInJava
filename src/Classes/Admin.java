package Classes;

public class Admin extends User {

	private boolean isItPrimaryAdmin;
	public Admin(String userName, String password, String phoneNumber,boolean isP) {
		super(userName, password, phoneNumber);
		isItPrimaryAdmin=isP;
	}

	public Admin(User use, boolean b) {
		super(use);
		isItPrimaryAdmin=b; 
	}	
	public boolean isItPrimaryAdmin() {
		return isItPrimaryAdmin;
	}

	public void setItPrimaryAdmin(boolean isItPrimaryAdmin) {
		this.isItPrimaryAdmin = isItPrimaryAdmin;
	}

	@Override
	public String toString() {
		return "Admin ["+super.toString()+"]";
	}
	
	

}
