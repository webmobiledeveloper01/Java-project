package lib;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class RegisterTest {
	
	/* The Register object is declared as a field so it is in scope throughout this class */
	private Register r;

	/* This method will run and create a new Register object instance before every individual unit test */
	@Before
	public void initialiseRegister() {
		r = new Register();
	}

	
	/* -- START OF UNIT TESTS -- */
	
	@Test
	public void testDefaultConstructor() {
		assertEquals("Register should be empty", true, r.isRegisterEmpty());
		assertEquals("Register should be of size zero", 0, r.sizeOfRegister());
		assertEquals("Room capacity should be set to 20", 20, r.getRoomCapacity());
	}
	
	@Test
	public void testCustomConstructor() {
		Register r2 = new Register(10);
		assertEquals("Register should be empty", true, r2.isRegisterEmpty());
		assertEquals("Register should be of size zero", 0, r2.sizeOfRegister());
		assertEquals("Room capaicty should be set to 10", 10, r2.getRoomCapacity());
		
		r2 = new Register(15);
		assertEquals("Room capacity should be set to 15", 15, r2.getRoomCapacity());
	}
	
	@Test
	public void testGetRoomCapacity() {
		assertEquals("Room capacity should return 20", 20, r.getRoomCapacity());
		
		Register r2 = new Register(30);
		assertEquals("Room capacity should return 30", 30, r2.getRoomCapacity());
	}

	@Test
	public void testAddName() {
		r.addName(new Name("Joe", "Bloggs"));
		Name n = new Name("Fred", "Jones");
		r.addName(n);

		assertSame("Register's last element should be the newly added name object", n, r.getName(r.sizeOfRegister()-1));
		assertEquals("Register's size should be two", 2, r.sizeOfRegister());
	}
	
	@Test
	public void testAddNameCapacity() {
		Register r2 = new Register(3);
		r2.addName(new Name("Joe", "Bloggs"));
		Name n = new Name("Fred", "Jones");
		r2.addName(n);

		assertSame("Register's last element should be the newly added name object", n, r2.getName(r2.sizeOfRegister()-1));
		assertEquals("Register's size should be two", 2, r2.sizeOfRegister());
		
		r2.addName(new Name("Anna", "Bloggs"));
		
		assertEquals("Register's size should be three", 3, r2.sizeOfRegister());
		
		r2.addName(new Name("Beth", "Bloggs"));
		
		assertEquals("Register's size should still be three", 3, r2.sizeOfRegister());
	}
	
	@Test
	public void testAddNames() {
		ArrayList<Name> names = new ArrayList<Name>();
		Name n = new Name("Peter", "Bloggs");
		Name n2 = new Name("Tom", "Bloggs");
		Name n3 = new Name("Anna", "Jones");
		names.add(n);
		names.add(n2);
		names.add(n3);
		
		r.addNames(names);

		assertSame("Register's first element should be the newly added name object", n, r.getName(0));
		assertSame("Register's second element should be the newly added name object", n2, r.getName(1));
		assertSame("Register's third element should be the newly added name object", n3, r.getName(2));
		assertEquals("Register's size should be three", 3, r.sizeOfRegister());
		
		names.clear();
		Name n4 = new Name("Joe", "Bloggs");
		names.add(n4);
		
		r.addNames(names);
		
		assertSame("Register's forth element should be the newly added name object", n4, r.getName(3));
		assertEquals("Register's size should be four", 4, r.sizeOfRegister());
	}
	
	@Test
	public void testAddNamesCapacity() {
		Register r2 = new Register(4);
		
		ArrayList<Name> names = new ArrayList<Name>();
		Name n = new Name("Peter", "Bloggs");
		Name n2 = new Name("Tom", "Bloggs");
		Name n3 = new Name("Anna", "Jones");
		names.add(n);
		names.add(n2);
		names.add(n3);
		
		r2.addNames(names);

		assertSame("Register's third element should be the newly added name object", n3, r2.getName(2));
		assertEquals("Register's size should be three", 3, r2.sizeOfRegister());
		
		r2 = new Register(4);
		
		Name n4 = new Name("Joe", "Bloggs");
		r2.addName(n4);
		
		r2.addNames(names);
		
		assertEquals("Register's size should be four", 4, r2.sizeOfRegister());
		
		r2 = new Register(3);
		
		r2.addName(n4);
		r2.addNames(names);
		
		assertEquals("Register's size should be one", 1, r2.sizeOfRegister());	
	}
	
	@Test
	public void testGetName() {
		Name n = new Name("Joe", "Bloggs");
		r.addName(n);
		Name n1 = new Name("Fred", "Jones");
		r.addName(n1);

		assertSame("Register should retrieve the same object added at index 0", n, r.getName(0));
		assertSame("Register should retrieve the same object added at index 1", n1, r.getName(1));
	}

	@Test
	public void testRemoveName() {
		r.addName(new Name("Fred", "Jones"));
		Name n = new Name("Joe", "Bloggs");
		r.addName(n);
		
		Name n1 = r.removeName(1);

		assertSame("Register should remove and return the same object that was added", n, n1);
		assertEquals("Register's size should now be one", 1, r.sizeOfRegister());
	}

	@Test
	public void testSizeOfRegister() {
		assertEquals("Register's size should be zero", 0, r.sizeOfRegister());
		
		r.addName(new Name("Joe", "Bloggs"));
		r.addName(new Name("Fred", "Jones"));
		r.addName(new Name("Tim", "Jones"));

		assertEquals("Register's size should be three", 3, r.sizeOfRegister());
	}

	@Test
	public void testClearRegister() {
		for (int i = 0; i < 10; i++) {
			r.addName(new Name());
		}

		int sizeBeforeClear = r.sizeOfRegister();
		
		assertTrue("Names should have been added to register - clear cannot therefore be tested", sizeBeforeClear > 0);
		
		
		r.clearRegister();
		
		assertEquals("Register's size should be zero after clear", 0, r.sizeOfRegister());
	}

	@Test
	public void testIsRegisterEmpty() {
		assertTrue("Register should initially be empty, i.e. return true", r.isRegisterEmpty());
		
		r.addName(new Name("Joe", "Bloggs"));

		assertFalse("Register should not be empty after a name is added, i.e. return false", r.isRegisterEmpty());
	}

	@Test
	public void testToString() {
		Name n = new Name("Tom", "Bloggs");
		r.addName(n);

		String toStr = r.toString();

		assertTrue("The toString method should be in the standard convention format as taught",
				toStr.startsWith("Register:[") &&
				toStr.contains(String.valueOf(r.getRoomCapacity())) &&
				toStr.contains(n.toString()) &&
				toStr.endsWith("]"));
		
		/* Further check to avoid the result of toString being hardcoded */
		Register r2 = new Register(10);
		n = new Name("Joe", "Bloggs");
		r2.addName(n);
		Name n1 = new Name("Fred", "Jones");
		r2.addName(n1);

		toStr = r2.toString();

		assertTrue("The toString method should be in the standard convention format as taught (2)",
				toStr.startsWith("Register:[") &&
				toStr.contains(String.valueOf(r2.getRoomCapacity())) &&
				toStr.contains(n.toString()) &&
				toStr.contains(n1.toString()) &&
				toStr.endsWith("]"));
	}

	@Test
	public void testSearchRegisterByFirstNameInitial() {
		r.addName(new Name("Joe", "Bloggs"));
		r.addName(new Name("Fred", "Jones"));

		assertTrue("First search should find (J)oe, i.e. return true", r.searchRegisterByFirstNameInitial('J'));
		
		
		r = new Register();
		r.addName(new Name("Tom", "Bloggs"));
		r.addName(new Name("Fred", "Jones"));

		assertFalse("Second search should not find (J)oe, i.e. return false", r.searchRegisterByFirstNameInitial('J'));
		
		
		r = new Register();
		r.addName(new Name("Tom", "Bloggs"));
		r.addName(new Name("Fred", "Jones"));

		assertTrue("Third search should find (F)red, i.e. return true", r.searchRegisterByFirstNameInitial('F'));
		
		
		r = new Register();
		r.addName(new Name("Joe", "Bloggs"));
		r.addName(new Name("Tom", "Jones"));

		assertFalse("Fourth search should not find (F)red, i.e. return false", r.searchRegisterByFirstNameInitial('F'));
	}

	@Test
	public void testCountFirstNameOccurrences() {
		r.addName(new Name("Jon", "Bloggs"));
		r.addName(new Name("Jen", "Jones"));

		assertEquals("First count should return 0", 0, r.countFirstNameOccurrences(new String("Luke")));
		
		
		r = new Register();
		r.addName(new Name("Luke", "Bloggs"));
		r.addName(new Name("Jen", "Jones"));

		assertEquals("Second count should return 1", 1, r.countFirstNameOccurrences(new String("Luke")));
		
		
		r = new Register();
		r.addName(new Name("Luke", "Bloggs"));
		r.addName(new Name("Luke", "Jones"));

		assertEquals("Third count should return 2", 2, r.countFirstNameOccurrences(new String("Luke")));
		
		
		r = new Register();
		r.addName(new Name("Anna", "Bloggs"));
		r.addName(new Name("Fred", "Jones"));

		assertEquals("Fourth count should return 0", 0, r.countFirstNameOccurrences(new String("TOM")));
		
		
		r = new Register();
		r.addName(new Name("Tom", "Bloggs"));
		r.addName(new Name("Jon", "Jones"));

		assertEquals("Fifth count should return 1", 1, r.countFirstNameOccurrences(new String("TOM")));
		
		
		r = new Register();
		r.addName(new Name("Tom", "Bloggs"));
		r.addName(new Name("Tom", "Jones"));

		assertEquals("Sixth count should return 2", 2, r.countFirstNameOccurrences(new String("TOM")));
		
		
		r = new Register();
		r.addName(new Name("Luke", "Bloggs"));
		r.addName(new Name("Jen", "Jones"));

		assertEquals("Seventh count should return 1", 1, r.countFirstNameOccurrences(new String("LuKe")));
		
		
		r = new Register();
		r.addName(new Name("Luke", "Bloggs"));
		r.addName(new Name("Luke", "Jones"));

		assertEquals("Eighth count should return 2", 2, r.countFirstNameOccurrences(new String("luke")));
	}	
	
	@Test
	public void testIterator() {
		r.addName(new Name("Joe", "Bloggs"));
		r.addName(new Name("Fred", "Bones"));

		//NOTE --- There is no assert or fail in this test because the for-each loop below will only work if the Register
		//         class implements Iterable correctly. Otherwise either a compilation error or runtime exception will occur.
		
		for (Name n : r) { }
	}
	
	@Test
	public void testSort() {
		Name n1 = new Name("Ted", "Bloggs");
		Name n2 = new Name("Fred", "Bones");
		Name n3 = new Name("Joe", "Bloggs");
		
		r.addName(n1); r.addName(n2); r.addName(n3);
		r.sortRegister();
	
		assertTrue("Elements should have been sorted based on the compareTo method of Name", r.getName(0) == n3 && r.getName(1) == n1 && r.getName(2) == n2);
	}
	
	
	/* -- GENERAL TESTS TO ENSURE CORRECT USE OF FIELDS AND METHODS -- */
	
	@Test
	public void testFieldModifiers() {
		Field[] fields = Register.class.getDeclaredFields();

		assertTrue("Modifiers cannot be assessed if no fields exist", fields.length > 0);
		
		assertTrue("All fields must be private", Arrays.stream(fields).allMatch(f -> (Modifier.PRIVATE & f.getModifiers()) != 0));
		
		assertTrue("No fields should be static", Arrays.stream(fields).allMatch(f -> (Modifier.STATIC & f.getModifiers()) == 0));
	}
	
	@Test
	public void testFieldNumber() {
		Field[] fields = Register.class.getDeclaredFields();

		assertEquals("The Register class should have two fields", 2, fields.length);
	}
	
	@Test
	public void testFieldTypes() {
		Field[] fields = Register.class.getDeclaredFields();

		boolean correct = true;
		
		if (fields[0].getType().isAssignableFrom(int.class)) {
			correct = ArrayList.class.isAssignableFrom(fields[1].getType()) &&
					Name.class.isAssignableFrom((Class<?>)((ParameterizedType) fields[1].getGenericType()).getActualTypeArguments()[0]);
		} else {
			correct = fields[1].getType().isAssignableFrom(int.class);
			if (correct) {
				correct = ArrayList.class.isAssignableFrom(fields[0].getType()) &&
						Name.class.isAssignableFrom((Class<?>)((ParameterizedType) fields[0].getGenericType()).getActualTypeArguments()[0]);
			}
		}
		
		assertTrue("The Register class should only have fields of type ArrayList<Name> and int", correct);
	}

}
