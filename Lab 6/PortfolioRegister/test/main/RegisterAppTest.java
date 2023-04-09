package main;

import static org.junit.Assert.*;

import org.junit.Test;

import lib.Name;
import lib.Register;

public class RegisterAppTest {

	/* Please note - when we come to mark the solution to this unit test we will change the input
	 * data set for the names added to the register to ensure the solution works dynamically based
	 * upon any given data set and is not hardcoded in any way.
	 */
	@Test
	public void testExecute() {
		Register r = new Register(10);
		r.addName(new Name("Joe", "Bloggs"));
		r.addName(new Name("Fred", "Jones"));
		r.addName(new Name("Nila", "Singh"));		
		
		String result = RegisterApp.execute(new Name("Cassie", "Downturn"), r);
		
		String expectedResult = "j.blo@email.com\nn.sin@email.com\nc.dow@email.com\n";
		
		assertEquals("The string returned should match the expected result (run 1)", expectedResult, result);
		
		
		/* Test with a second set of input data */
		Register r2 = new Register(10);
		r2.addName(new Name("Tim", "Russ"));
		r2.addName(new Name("David", "Blunt"));
		r2.addName(new Name("Remi", "Patel"));		
		
		String result2 = RegisterApp.execute(new Name("Cassie", "Downturn"), r2);
		
		String expectedResult2 = "r.pat@email.com\nc.dow@email.com\n";
		
		assertEquals("The string returned should match the expected result (run 2)", expectedResult2, result2);	
	}
	
}
