import java.util.Scanner;


public class Menssage {

	private User user;
	private String menssage;
	
	Scanner input = new Scanner(System.in);
	
	public Menssage(User user) {
		System.out.println("Type the Menssage:");
		this.menssage = input.nextLine();
		this.user = user;
		
	}

	public User getUser() {
		return user;
	}

	public String getMenssage() {
		return menssage;
	}
	
	

}
