package Classes;

public class ActiveUser {

	private static User aUser;
	public static User getaUser() {
		return aUser;
	}
	public static void setaUser(User aUser) {
		ActiveUser.aUser = aUser;
	}
}
