import java.util.ArrayList;
import java.util.Scanner;


public class User {

	private String login;
	private String password;
	private String name;
	private String email = "-";
	private int age;
	private ArrayList<User> friends = new ArrayList<User>();
	private ArrayList<Community> communits = new ArrayList<Community>();
	private ArrayList<User> requests = new ArrayList<User>();
	private ArrayList<Menssage> menssagesReceived = new ArrayList<Menssage>();
	
	
	static Scanner input = new Scanner(System.in);
	
	public User() {
		System.out.print("Your name: ");
		this.name = input.next();
		
		System.out.print("New login: ");
		this.login = input.next();
		
		System.out.print("New password: ");
		this.password = input.next();
		
		System.out.print("Your age: ");
		this.age = input.nextInt();
		
		
		System.out.println("User created");
		
		
	}
	
	
	
	public static void requestsPending(User userCurrent){
		int cont = 1;
		
		if(userCurrent.requests.size() == 0){
			System.out.println("No request");
			return;
		}
			
		for(User userAux : userCurrent.requests){
			System.out.printf("[%d] %s%n", cont++,userAux.name);
			System.out.println("[1] Accept [2] Reject");
			if(input.nextInt() == 1){
				userCurrent.friends.add(userAux);
			}
		}
	}
	
	public void informations(){
		System.out.printf("Name: %s%nEmail: %s%nAge: %d%n",
				this.name,this.email,this.age);
	}
	
	public void editProfile(){
		System.out.printf("[1] Name%n[2] Email%n[3] Login%n[4] Password%nSelecione o que deseja alterar: ");
		int optionAux = input.nextInt();
		switch(optionAux){
			case 1:
				System.out.print("New name: ");
				this.name = input.nextLine();
				break;
			case 2:
				System.out.print("New email: ");
				this.email = input.next();
				break;
			case 3:
				System.out.print("New login: ");
				this.login = input.next();
				break;
			case 4:
				System.out.print("New password: ");
				this.password = input.next();
				break;
			default:
				System.out.println("Invalid option!");
				break;
		}
		System.out.println("Finish!");
	}
	
	
	
	public ArrayList<User> getFriends() {
		return friends;
	}



	public int getAge() {
		return age;
	}



	public ArrayList<Menssage> getMenssagesReceived() {
		return menssagesReceived;
	}



	public ArrayList<Community> getCommunits() {
		return communits;
	}


	public String getName() {
		return name;
	}

	public void sendMenssage(Menssage menssage){
		this.menssagesReceived.add(menssage);
	}
	public void addRequest(User user){
		this.requests.add(user);
		
	}
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
	
}
