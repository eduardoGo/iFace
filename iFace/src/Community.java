import java.util.ArrayList;
import java.util.Scanner;


public class Community {

	private String name;
	private User manager;
	private String description;
	private ArrayList<User> members = new ArrayList<User>();
	private ArrayList<User> requests = new ArrayList<User>();
	private ArrayList<Menssage> menssagesReceived = new ArrayList<Menssage>();
	
	
	
	
	Scanner input = new Scanner(System.in);
	
	public Community(User manager) {
		System.out.print("Name: ");
		this.name = input.nextLine();
		this.manager = manager;
		System.out.print("Description: ");
		this.description = input.nextLine();
		System.out.println("Finish!");
	}
	
	public void manager(){
		
		
		System.out.println("***Manager Community***");
		int option = 0;
		int contAux = 0;
		while(true){
			System.out.printf("[1] Look members%n[2] Look requests%n[3] Menssagens receiveds[4] Back to menu principal%n");
			option = input.nextInt();
			contAux = 0;
			switch(option){
				case 1:
					contAux = 1;
					for(User userAux : members)
						System.out.printf("[%d] Name: %s Login: %s%n", contAux++,userAux.getName(),userAux.getLogin());
					
					System.out.println("Finish!");
				break;
				case 2:
					contAux = 1;
					for(User userAux : requests){
						System.out.printf("[%d] Name: %s Login: %s%n", contAux++,userAux.getName(),userAux.getLogin());
						System.out.println("[1] Accept [2] Reject");
						if(input.nextInt() == 1)
							members.add(userAux);
					}
					requests.clear();
					System.out.println("Finish!");
					break;
				case 3:
					contAux = 1;
					for(Menssage menssageCurrent : menssagesReceived)
						System.out.printf("[%d] Name: %s Login: %s%nMenssage:%n%s%n", contAux++,menssageCurrent.getUser().getName(),
								menssageCurrent.getUser().getLogin(),menssageCurrent.getMenssage());
					
					menssagesReceived.clear();
					System.out.println("Finish!");
					break;
				case 4:
					return;
				default:
					System.out.println("Invalid option!");
					break;
			}
		}
		
	}
	
	
	public void addRequest(User userCurrent){
		this.requests.add(userCurrent);
	}
	public ArrayList<User> getRequests() {
		return requests;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<User> getMembers() {
		return members;
	}
	public void setMembers(ArrayList<User> members) {
		this.members = members;
	}
	public User getManager() {
		return manager;
	}
	public void setManager(User manager) {
		this.manager = manager;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
