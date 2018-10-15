package View;
/**
 * @author Wei Zhang
 * @author Yifu Li
 * @author Jiaru Wu
 */


/**
 * Enum class for Direction.
 * 
 */
public enum Direction {
	EAST("east"),
	WEST("west"),
	NORTH("north"),
	SOUTH("south"),
	SOUTHWEST("southwest"),
	SOUTHEAST("southeast"),
	NORTHWEST("northwest"),
	NORTHEAST("northeast");
	
	private String name = null;
	/**
	 * @param s is a String type parameter.
	 * 
	 */
	private Direction(String s){
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
