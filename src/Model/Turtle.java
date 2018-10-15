package Model;
/**
 * @author Wei Zhang
 * @author Yifu Li
 * @author Jiaru Wu
 */

import java.io.Serializable;

/**
 * Class for Turtle.
 */
public class Turtle extends Mover implements Serializable{
	/**
	 * Constructor for Turtle.
	 * @param x  Turtle's x position
	 * @param y  Turtle's y position
	 */
	public Turtle(int x,int y) {
		super("Turtle", x, y, 1, 1,65,65);
	}
	

}
