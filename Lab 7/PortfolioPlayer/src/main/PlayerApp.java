package main;

import java.util.ArrayList;

import lib.Player;

/**
 * Player app.
 */
public class PlayerApp {

	/**
	 * It will execute and find the players with same
	 * surname and number in gamer tag.
	 * 
	 * @param participants list of participants
	 * @param number gamer number
	 * @return result data
	 */
	public static String execute(ArrayList<Player> participants, int number) {
		
		String result = "";
		for (Player each: participants) {
			String gamerTag = each.getGamerTag();
			if (gamerTag.contains(each.getName().getFamilyName().toLowerCase()) 
					&& gamerTag.endsWith(String.valueOf(number))) {
				result += each.getName().getFirstName().toUpperCase() + ", " +
					each.getName().getFamilyName().toLowerCase() + "\n";
			}
		}
		return result;
	
	}
	
}
