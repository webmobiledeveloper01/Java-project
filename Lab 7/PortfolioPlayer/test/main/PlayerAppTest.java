package main;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import lib.Die;
import lib.Name;
import lib.PairOfDice;
import lib.Player;

public class PlayerAppTest {
	
	/* Please note - when we come to mark the solution to this unit test we will change the input
	 * data set for the players added to the list to ensure the solution works dynamically based
	 * upon any given data set and is not hardcoded in any way.
	 */
	@Test
	public void testExecute() {
		ArrayList<Player> players = new ArrayList<>();
		players.add(new Player(new Name("Joe", "Bloggs"), "Jbloggs31", new PairOfDice()));
		players.add(new Player(new Name("Fred", "Jones"), "Fjones20", new Die()));
		players.add(new Player(new Name("Nila", "Singh"), "Nsing20", new PairOfDice(new Die(5), new Die(5))));
		players.add(new Player(new Name("Anna", "Skye"), "Askye20", new Die()));
		
		String result = PlayerApp.execute(players, 20);
		
		String expectedResult = "FRED, jones\nANNA, skye\n";
		
		assertEquals("The string returned should match the expected result (run 1)", expectedResult, result);
		
		
		/* Test with a second set of input data */
		ArrayList<Player> players2 = new ArrayList<>();
		players2.add(new Player(new Name("David", "Blunt"), "Dblunt20", new PairOfDice()));
		players2.add(new Player(new Name("Tim", "Jonas"), "Tother20", new Die(5)));
		players2.add(new Player(new Name("Remi", "Patel"), "Rpatel20", new Die()));		
		players2.add(new Player(new Name("Toby", "Castle"), "Tcastle20", new PairOfDice(new Die(5), new Die(5))));
		
		
		String result2 = PlayerApp.execute(players2, 20);
		
		String expectedResult2 = "DAVID, blunt\nREMI, patel\nTOBY, castle\n";
		
		assertEquals("The string returned should match the expected result (run 2)", expectedResult2, result2);
		
		
		/* Test with a third set of input data */
		ArrayList<Player> players3 = new ArrayList<>();
		players3.add(new Player(new Name("David", "Blunt"), "Dblunt20", new PairOfDice()));
		players3.add(new Player(new Name("Tim", "Jonas"), "Tjonas35", new Die(5)));
		players3.add(new Player(new Name("Remi", "Patel"), "Rpatel35", new Die()));		
		players3.add(new Player(new Name("Toby", "Castle"), "Tcastle33", new PairOfDice(new Die(5), new Die(5))));
		
		
		String result3 = PlayerApp.execute(players3, 35);
		
		String expectedResult3 = "TIM, jonas\nREMI, patel\n";
		
		assertEquals("The string returned should match the expected result (run 3)", expectedResult3, result3);
	}
	
}
