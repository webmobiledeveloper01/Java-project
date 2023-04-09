package main;

import lib.Name;
import lib.Register;

/**
 * Register app with few methods.
 */
public class RegisterApp {

	/**
	 * It will remove the name at index 1, and add the nm in register.
	 * Then it will iterate through all names and return the string for it.
	 * 
	 * @param nm the name to add
	 * @param regst the register
	 * @return the string for names in the register.
	 */
	public static String execute(Name nm, Register regst) {	
		
		regst.removeName(1);
		regst.addName(nm);
		String emails = "";
		for (int i = 0; i < regst.sizeOfRegister(); i++) {
			Name name = regst.getName(i);
			if (name.getFirstName().length() >= 1 && name.getFamilyName().length() >= 3 &&
					(name.getFirstName().toLowerCase().contains("a") || 
					name.getFirstName().toLowerCase().contains("e"))) {
				emails += name.getFirstName().charAt(0) + "." + 
						name.getFamilyName().substring(0, 3) + "@email.com\n";
			}
		}
		return emails.toLowerCase();
		
	}
}