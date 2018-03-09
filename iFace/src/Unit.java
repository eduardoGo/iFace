
import java.util.Scanner;
import java.util.ArrayList;

public class Unit {
	
	private static ArrayList<User> usersRegisteds = new ArrayList<User>();
	private static ArrayList<Community> communitsRegisteds = new ArrayList<Community>();
	

	static Scanner input = new Scanner(System.in);
	
	public static void login() {
		System.out.print("Login: ");
		String login = input.next();
		System.out.print("Password: ");
		String password = input.next();
		
		boolean foundUser=false;
		User userCurrent = null;
		
		for(User userAux : usersRegisteds){
			if(userAux.getLogin().equals(login)){
				foundUser = true;
				if(userAux.getPassword().equals(password)){
					userCurrent = userAux;
				}else{
					System.out.println("Password incorrect!");
				}
			}
		}
		
		if(!foundUser)
			System.out.println("User not found!");
		else if(userCurrent != null)
			lobby(userCurrent);
		
	}
	
	public static void register() {
		usersRegisteds.add(new User());
	}
	
	private static void lobby(User userCurrent){
		
		
			while(true){
				
				System.out.println("===========");
				System.out.printf("[1] Requests of friends pending%n[2] Communits on%n[3] Add new friend%n[4] Send mensage%n" +
						"[5] Information about user%n[6] Edit profile%n[7] Create new Community%n[8] Manage community%n[9] Delete account%n[10] Menssages received%n" +
						"[11] My communits%n[12] My friends%n[13] Exit%n");
				System.out.println("===========");
				
				int option = input.nextInt();
				boolean seachAux;
				
				switch(option){
					case 1:
						User.requestsPending(userCurrent);
						break;
					case 2:
						communitsOn(userCurrent);
						break;
					case 3:
						addNewFriend(userCurrent);
						break;
					case 4:
						sendMenssage(userCurrent);
						break;
					case 5:
						informations();
						break;
					case 6:
						userCurrent.editProfile();
						break;
					case 7:
						communitsRegisteds.add(new Community(userCurrent));
						break;
					case 8:
						seachAux = false;
						for(Community communityAux : communitsRegisteds ){
							if(communityAux.getManager() == userCurrent){
								seachAux = true;
								communityAux.manager(communityAux);
								break;
							}
						}
						if(!seachAux)
							System.out.println("You don't have community");
						break;
					case 9:
						System.out.printf("You want delete you accont ?%n[1] Yes [2] No%n");
						if(input.nextInt() == 2)
							break;
						
						for(Community currentCommunity : userCurrent.getCommunits())
							currentCommunity.deleteUser(userCurrent);
						
						usersRegisteds.remove(userCurrent);
						
						return;
					case 10:
						menssagesReceived(userCurrent);
						break;
					case 11:
						myCommunits(userCurrent);
						break;
					case 12:
						myFriends(userCurrent);
						break;
					case 13:
						return;
					default:
						System.out.println("Invalid option!");
						break;
				}
				
			}	
		}
		

	private static void informations(){
		
		User userAux = searchUser();
		if(userAux == null)
			return;
		
		userAux.informations();
		
	}
	private static void myFriends(User user){
		if(user.getFriends().size() == 0){
			System.out.println("No friends");
			return;
		}
		for(User userAux : user.getFriends())
			System.out.printf("Name: %s Age: %d%n", userAux.getName(),userAux.getAge());
		
	}
	private static void myCommunits(User user){
		if(user.getCommunits().size() == 0){
			System.out.println("No communits");
			return;
		}
			
		for(Community currentCommunity : user.getCommunits())
			System.out.printf("Name: %s%nDescription: %s%n", currentCommunity.getName(),currentCommunity.getDescription());
		
	}
	private static void menssagesReceived(User user){
		if(user.getMenssagesReceived().size() == 0){
			System.out.println("No menssages");
			return;
		}
		for(Menssage currentMenssage : user.getMenssagesReceived())
			System.out.printf("[%s] : %s%n",currentMenssage.getUser().getName(),currentMenssage.getMenssage());
		
	}
	private static void sendMenssage(User user){
		
		User userAux = searchUser();
		if(userAux == null)
			return;
		
		userAux.sendMenssage(new Menssage(user));
	
		System.out.println("Menssage send!");
	}
	private static void addNewFriend(User user){
		
		
		User userAux = searchUser();
		
		if(userAux == null)
			return;
		
		userAux.addRequest(user);
		
		
			System.out.println("Request send!");
	}
	private static void communitsOn(User user){
		int option = 1;
		if(communitsRegisteds.size() == 0){
			System.out.println("No communits");
			return;
		}
			
		for(Community communityAux : communitsRegisteds){
			System.out.printf("[%d] Name: %s%nDescription: %s%n", option++,communityAux.getName(),communityAux.getDescription());
		}
		System.out.printf("You want participate ?%n[1] Yes [2] No");
		
		if(input.nextInt() == 2)
			return;
		
			System.out.println("Enter the number corresponding to it: ");
			option = input.nextInt();
			Community communityAux = communitsRegisteds.get(option -1);
			communityAux.addRequest(user);
			System.out.println("Adm will see your request");
		
	}
	
	private static User searchUser(){
		
		String loginAux;
		User user = null;
	
		do{
			System.out.print("Login of user: ");
			loginAux = input.next();
			for(User userAux : usersRegisteds)
				if(userAux.getLogin().equals(loginAux))
					user = userAux;
					
			if(user == null){
				System.out.println("User not found!");
				System.out.printf("[1] Try again [2] Exit");
				if(input.nextInt() == 2)
					return null;
			}
				
		}while(user == null);
		
		return user;
		
	}
	

}
