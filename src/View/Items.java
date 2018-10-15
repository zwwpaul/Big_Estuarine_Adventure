package View;

/**
 * Enum class for trash, animal and UI stuff.
 * 
 */
public enum Items {

	TRASH3("new_trash3"), 
	BATTERY("Battery"),
	TRASH("Trash"),
	GAMEOVER("gameover"),
	SUCCESS("success"),
	NEW_TRASH("new_trash"),
	TURTLE("turtle"),
	BLUEFISH("bluefish"),
	CRAB("crab");

	private String name = null;

	/**
	 * @param s
	 *            is a String type parameter.
	 * 
	 */
	private Items(String s) {
		name = s;
	}

	/**
	 * @return It will return a string of Direction.
	 * 
	 */
	public String getName() {
		return name;
	}
}
