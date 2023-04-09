package lib;

import java.util.ArrayList;

/**
 * It is the register for the names to record.
 */
public class Register {

	// Attributes..
	private ArrayList<Name> names;
	private int capacity;

	/**
	 * Default constructor with capacity of 20.
	 */
	public Register() {

		this(20);

	}

	/**
	 * Constructor to initialize with capacity.
	 * 
	 * @param capacity the capacity of register.
	 */
	public Register(int capacity) {

		this.capacity = capacity;
		this.names = new ArrayList<>();

	}

	/**
	 * Check if register is empty.
	 * 
	 * @return true if register is empty else false.
	 */
	public boolean isRegisterEmpty() {

		return names.isEmpty();

	}

	/**
	 * Getter for size of register.
	 * 
	 * @return size of register
	 */
	public int sizeOfRegister() {

		return names.size();

	}

	/**
	 * Getter for room capacity.
	 * 
	 * @return capacity of room
	 */
	public int getRoomCapacity() {

		return capacity;

	}

	/**
	 * Add name into the register, if there is space in register
	 * 
	 * @param name the name to add
	 */
	public void addName(Name name) {

		if (names.size() < capacity) {
			this.names.add(name);
		}

	}

	/**
	 * Add names into the register if there is space in register
	 * 
	 * @param list the list with names
	 */
	public void addNames(ArrayList<Name> list) {

		for (int i = 0; i < list.size(); i++) {
			addName(list.get(i));
		}

	}

	/**
	 * Search the register with first name with given character.
	 * 
	 * @param in the initial
	 * @return true if found else false
	 */
	public boolean searchRegisterByFirstNameInitial(char in) {

		String initial = String.valueOf(in);
		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).getFirstName().startsWith(initial)) {
				return true;
			}
		}
		return false;

	}

	/**
	 * It will count first name occurrences in the register.
	 * 
	 * @param name first name
	 * @return count of occurrences.
	 */
	public int countFirstNameOccurrences(String name) {

		int count = 0;
		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).getFirstName().equalsIgnoreCase(name)) {
				count++;
			}
		}
		return count;

	}

	/**
	 * It will get name at given index.
	 * 
	 * @param i given index
	 * @return name if found else null
	 */
	public Name getName(int i) {

		if (i >= 0 && i < names.size()) {
			return names.get(i);
		}
		return null;

	}

	/**
	 * It will remove the name at given index.
	 * 
	 * @param i given index
	 * @return name if removed else null
	 */
	public Name removeName(int i) {

		if (i >= 0 && i < names.size()) {
			return names.remove(i);
		}
		return null;

	}
	
	/**
	 * It will remove all entries.
	 */
	public void clearRegister() {

		this.names.clear();

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {

		return "Register:[Capacity: " + capacity + ", List: " + names + "]";

	}

}
