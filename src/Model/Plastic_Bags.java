package Model;
/**
 * @author Wei Zhang
 * @author Yifu Li
 * @author Jiaru Wu
 */

import java.io.Serializable;

/**
 * Class for Plastic_Bags
 */
public class Plastic_Bags extends Mover implements Serializable{
	/**
	 * Constructor for Plastic_Bags
	* @param x Plastic_Bags's x position
	 * @param y Plastic_Bags's y position
	 */
	public Plastic_Bags(int x,int y) {
		super("bag", x, y, 2,2,50,50);
		
	}
	

}
