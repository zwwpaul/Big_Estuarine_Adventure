package Model;
/**
 * @author Wei Zhang
 * @author Yifu Li
 * @author Jiaru Wu
 */

import java.io.Serializable;

/**
 * Class for Fish.
 */
public class Fish extends Mover implements Serializable{
	/**
	 * Constructor for Fish.
	 * @param x Fish's x position
	 * @param y Fish's y position
	 */
	public Fish(int x,int y) {
		super("Fish", x, y, 2, 0,70,49);
	}
}
