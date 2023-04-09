package lib;

/**
 * It represents the player in the game.
 */
public class Player implements Comparable<Player> {

	// Attributes..
	private String gamerTag;
	private Name name;
	private Rollable rollable;

	/**
	 * Default constructor to initialize the attributes.
	 */
	public Player() {

		this(new Name(), "", new PairOfDice());

	}

	/**
	 * Constructor with gamer tag and name.
	 * 
	 * @param name     the name of player
	 * @param gamerTag the gamer tag of player
	 */
	public Player(Name name, String gamerTag) {

		this(name, gamerTag, new PairOfDice());

	}

	/**
	 * Constructor with all parameters.
	 * 
	 * @param name     the name of player
	 * @param gamerTag the gamer tag of player
	 * @param rollable the pair of dice to roll
	 */
	public Player(Name name, String gamerTag, Rollable rollable) {

		this.gamerTag = gamerTag;
		this.name = name;
		this.rollable = rollable;

	}

	/**
	 * Set the full player name.
	 * 
	 * @param name the full name
	 */
	public void setFullPlayerName(String name) {

		String[] names = name.toLowerCase().split(" ");
		if (names.length == 2) {
			for (int i = 0; i < names.length; i++) {
				if (!names[i].isEmpty()) {
					names[i] = Character.toUpperCase(names[i].charAt(0)) + names[i].substring(1);
				}
			}
			this.name.setFirstName(names[0]);
			this.name.setFamilyName(names[1]);
		}

	}

	/**
	 * It will generate the gamer tag for the player according to the number.
	 * 
	 * @param number it should be in range of 1 to 100.
	 */
	public void generateGamerTag(int number) {

		if (number >= 1 && number <= 100) {
			String fullname = name.getFirstName() + name.getFamilyName();
			String reverse = (new StringBuilder(fullname)).reverse().toString();
			this.gamerTag = reverse.toLowerCase() + number;
		}

	}

	/**
	 * It will roll the dice.
	 */
	public void rollDice() {

		rollable.roll();

	}

	/**
	 * It will return the score after rolling dice.
	 * 
	 * @return score of dice
	 */
	public int getDiceScore() {

		return rollable.getScore();

	}

	/**
	 * Getter for the gamerTag
	 *
	 * @return value of gamerTag
	 */
	public String getGamerTag() {

		return gamerTag;

	}

	/**
	 * Getter for the name
	 *
	 * @return value of name
	 */
	public Name getName() {

		return name;

	}

	/**
	 * Getter for the rollable
	 *
	 * @return value of rollable
	 */
	public Rollable getRollable() {

		return rollable;

	}

	/**
	 * To update the value of gamerTag.
	 *
	 * @param gamerTag updated value
	 */
	public void setGamerTag(String gamerTag) {

		this.gamerTag = gamerTag;

	}

	/**
	 * To update the value of name.
	 *
	 * @param name updated value
	 */
	public void setName(Name name) {

		this.name = name;

	}

	/**
	 * To update the value of rollable.
	 *
	 * @param rollable updated value
	 */
	public void setRollable(Rollable rollable) {

		this.rollable = rollable;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo(Player o) {

		int compare = name.compareTo(o.name);
		if (compare == 0) {
			compare = gamerTag.compareTo(o.gamerTag);
		}
		return compare;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {

		return "Player:[Gamer Tag: " + gamerTag + ", Name: " + name + ", Rollable: " + rollable + "]";

	}

}
