import java.util.Scanner;


public class Main {

	static Scanner input = new Scanner(System.in);
	
		
	public static void main(String[] args) {
		
		int option;
		
		while(true){
			
			
			System.out.printf("***iFace***%n[1] Login%n[2] Register");
			
			option = input.nextInt();
			
			if(option == 1)
				Unit.login();
			else if(option == 2)
				Unit.register();
			else
				System.out.println("Invalid input");
		}
		
		
		
		
	}
	

}
