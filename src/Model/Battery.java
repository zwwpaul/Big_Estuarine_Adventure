package Model;
/**
 * @author Wei Zhang
 * @author Yifu Li
 * @author Jiaru Wu
 */

import java.io.Serializable;

/**
 * Class for Battery.
 */
public class Battery extends Mover implements Serializable{
	/**
	 * Constructor for Battery
	 * @param x Battery's x position
	 * @param y Battery's y position
	 */
	public Battery(int x,int y) {
		super("Battery", x, y, 0,2,50,50 );
	}

}
