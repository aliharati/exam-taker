public class User {
	private String name;
	private int score;
	
	/**
	 * Constructs a User object with the specified name and initializes the score to 0.
	 *
	 * @param name  The name of the user
	 */
	public User(String name) {
		this.name = name;
		this.score = 0;
	}
	
	/**
	 * Constructs a User object with the specified name and score.
	 *
	 * @param name   The name of the user
	 * @param score  The score of the user
	 */
	public User(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	/**
	 * Adds the specified amount to the user's score.
	 *
	 * @param amount  The amount to be added to the score
	 */
	public void addToScore(int amount) {
		score += amount;
	}
	
	/**
	 * Returns the name of the user.
	 *
	 * @return The name of the user
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the score of the user.
	 *
	 * @return The score of the user
	 */
	public int getScore() {
		return score;
	}
	
	
}
