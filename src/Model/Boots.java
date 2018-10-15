package Model;
/**
 * @author Wei Zhang
 * @author Yifu Li
 * @author Jiaru Wu
 */

import java.io.Serializable;

/**
 * Class for Boots
 */
public class Boots extends Mover implements Serializable{
	/**
	 * Constructor for Boots.
	 * @param x Boot's x position
	 * @param y Boot's y position
	 */
	public Boots(int x,int y) {
		super("Boots",x, y, 1, 2,70,75);
	}

}
