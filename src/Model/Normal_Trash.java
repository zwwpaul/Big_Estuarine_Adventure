package Model;
/**
 * @author Wei Zhang
 * @author Yifu Li
 * @author Jiaru Wu
 */

import java.io.Serializable;

/**
 * Class for Normal_Trash.
 */
public class Normal_Trash extends Mover implements Serializable{
	/**
	 * Constructor for Normal_Trash.
	 * @param x Normal_Trash's x position
	 * @param y Normal_Trash's y position
	 */
	public Normal_Trash(int x,int y) {
		super("ntrash", x, y, 1, 2,50,50);
	}

}
