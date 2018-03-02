
import java.util.Scanner;
import java.util.ArrayList;

public class Unit {
	
	private static ArrayList<User> usersRegisteds = new ArrayList<User>();
	private static ArrayList<Community> comuunitsRegisteds = new ArrayList<Community>();
	

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
		
		System.out.printf("[1] Requests of friends pending%n[2] Communits on%n[3] Add new friend%n[4] Send mensage%n" +
				"[5] Information about user%n[6] Edit profile%n[7] Create new Community%n[8] Manage community%n[9] Delete account%n");
		
		int option = input.nextInt();
		int optionAux = 0;
		String loginAux = null;
		boolean seachAux;
		
		switch(option){
			case 1:
				User.requestsPending(userCurrent);
				break;
			case 2:
				optionAux = 1;
				for(Community communityAux : comuunitsRegisteds){
					System.out.printf("[%d] Name: %s%nDescription: %s%n", optionAux++,communityAux.getName(),communityAux.getDescription());
				}
				System.out.println("Deseja participar de alguma ?%n[1] Yes [2] No");
				if(input.nextInt() == 1){
					System.out.println("Digite o numero correspondente a ela: ");
					optionAux = input.nextInt();
					Community communityAux = comuunitsRegisteds.get(optionAux -1);
					communityAux.addRequest(userCurrent);
					System.out.println("Adm irá ver sua solicitacao");
				}
				
				break;
			case 3:
				System.out.print("Login of user: ");
				loginAux = input.next();
				seachAux = false;
				for(User userAux : usersRegisteds){
					if(userAux.getLogin().equals(loginAux)){
						seachAux = true;
						userAux.addRequest(userCurrent);
					}
				}
				if(!seachAux)
					System.out.println("User not found!");
				else
					System.out.println("Request send!");
				break;
			case 4:
				System.out.print("Login of user: ");
				loginAux = input.next();
				seachAux = false;
				for(User userAux : usersRegisteds){
					if(userAux.getLogin().equals(loginAux)){
						seachAux = true;
						userAux.sendMenssage(new Menssage(userCurrent));
					}
				}
				if(!seachAux)
					System.out.println("User not found!");
				else
					System.out.println("Menssage send!");
				break;
			case 5:
				System.out.print("Login of user: ");
				loginAux = input.next();
				seachAux = false;
				for(User userAux : usersRegisteds){
					if(userAux.getLogin().equals(loginAux)){
						seachAux = true;
						userAux.informations();
					}
				}
				if(!seachAux)
					System.out.println("User not found!");
				
				break;
			case 6:
				userCurrent.editProfile();
				break;
			case 7:
				comuunitsRegisteds.add(new Community(userCurrent));
				break;
			case 8:
				seachAux = false;
				for(Community communityAux : comuunitsRegisteds ){
					if(communityAux.getManager() == userCurrent){
						seachAux = true;
						communityAux.manager();
					}
				}
				if(!seachAux)
					System.out.println("You don't have community");
				break;
			case 9:
				System.out.printf("You want delete you accont ?%n[1] Yes [2] No%n");
				if(input.nextInt() == 1){
					usersRegisteds.remove(userCurrent);
					//falta deletar na comunidade tb
				}
				break;
			default:
				System.out.println("Invalid option!");
				break;
		}
		
		
	}

}
