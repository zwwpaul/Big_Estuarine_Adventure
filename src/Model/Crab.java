package Model;
/**
 * @author Wei Zhang
 * @author Yifu Li
 * @author Jiaru Wu
 */

import java.io.Serializable;

/**
 * Class for Crab.
 */
public class Crab extends Mover implements Serializable{
	/**
	 * Constructor for Crab.
	 *@param x Crab's x position
	 * @param y Crab's y position
	 */
	public Crab(int x, int y) {
		super("Crab", x, y, 4, 0,60,60);
	}


}
