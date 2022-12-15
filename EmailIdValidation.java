package emailvalidation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailIdValidation {
	
	public static final String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9_.-]+$";
	
	public static void main(String[] args) {
		
		boolean stillRunning = true;
		String scannerInput;
		
		Scanner scan = new Scanner(System.in);
		
		List <String> emailList = new ArrayList<String>();
		HashMap<String, Boolean> emailMap = new HashMap<String, Boolean>();
		
		Pattern pattern = Pattern.compile(regex);
		
		System.out.println("Welcome to Email Validation" + "\n");
		
		//main loop
		while(stillRunning = true) {
			System.out.println("Please enter the emails to validate");
			System.out.println("Enter 'F' when done");
			while(true) {
				scannerInput = scan.next();
				if(scannerInput.compareToIgnoreCase("F") == 0) {
					break;
				}
				emailList.add(scannerInput);
			}
			System.out.println("Results:" + "\n");
			//checking emails against regex parser
			for(String email : emailList) {
				Matcher matcher = pattern.matcher(email);
				System.out.println(email + " is " + (matcher.matches() ? " valid":" invalid"));
				emailMap.put(email, matcher.matches());
			}
			//continue with email validation or access log of already processed emails
			while(true) {
				System.out.println("\n" +"Type 'log' to view all the emails attempted...");
				System.out.println("Enter any key to continue or type 'exit' to exit");
				scannerInput = scan.next();
				if(scannerInput.compareTo("log") == 0) {
					int numEntry = 0;
					for(HashMap.Entry<String, Boolean> entry : emailMap.entrySet()) {
						numEntry += 1;
						String email = entry.getKey();
						Boolean valid = entry.getValue();
						System.out.println(numEntry + ": " + "Email: " + email + "\n" + "   Validity: " + valid );
					}
				}else if(scannerInput.compareToIgnoreCase("exit") == 0) {
					stillRunning = false;
					break;
				}else {
					break;
				}
			}
			if(stillRunning == false) {
				break;
			}
		}
		scan.close();
	}
}
