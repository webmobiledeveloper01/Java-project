package lib;

/**
 * It represents the player in the game.
 */
public class Player {

	// Attributes..
	private String gamerTag;
	private Name name;
	private PairOfDice pairOfDice;

	/**
	 * Default constructor to initialize the attributes.
	 */
	public Player() {

		this("", new Name(), new PairOfDice());

	}

	/**
	 * Constructor with gamer tag and name.
	 * 
	 * @param gamerTag the gamer tag of player
	 * @param name     the name of player
	 */
	public Player(String gamerTag, Name name) {

		this(gamerTag, name, new PairOfDice());

	}

	/**
	 * Constructor with all parameters.
	 * 
	 * @param gamerTag   the gamer tag of player
	 * @param name       the name of player
	 * @param pairOfDice the pair of dice to roll
	 */
	public Player(String gamerTag, Name name, PairOfDice pairOfDice) {

		this.gamerTag = gamerTag;
		this.name = name;
		this.pairOfDice = pairOfDice;

	}

	/**
	 * It will roll the dice.
	 */
	public void rollDice() {

		pairOfDice.roll();

	}

	/**
	 * It will return the score after rolling dice.
	 * 
	 * @return score of dice
	 */
	public int getDiceScore() {

		return pairOfDice.getScore();

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
	 * Getter for the pairOfDice
	 *
	 * @return value of pairOfDice
	 */
	public PairOfDice getPairOfDice() {

		return pairOfDice;

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
	 * To update the value of pairOfDice.
	 *
	 * @param pairOfDice updated value
	 */
	public void setPairOfDice(PairOfDice pairOfDice) {

		this.pairOfDice = pairOfDice;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {

		return "Gamer Tag: " + gamerTag + ", Name: " + name + ", Pair Of Dice: " + pairOfDice;

	}

}
