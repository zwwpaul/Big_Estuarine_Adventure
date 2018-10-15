package Model;
/**
 * @author Wei Zhang
 * @author Yifu Li
 * @author Jiaru Wu
 */

import java.io.Serializable;

/**
 * Class for Mover.
 */
public class Mover implements Serializable{
	private int xloc;
	private int yloc;
	private int xInc;
	private int yInc;
	private int width;
	private int height;
	
	private String name;
	boolean caught;
	//count time penalty
	boolean iscount;

	/**
	 * getter of width
	 * @return The width  
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * setter of width
	 * @param width of mover
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * getter of height 
	 * @return Height of Mover 
	 */
	public int getHeight() {
		return height;
	}


	/**
	 * setter of height
	 * @param height of mover
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * getter of Y position
	 * @return  Position of Mover 
	 */
	public int getYloc() {
		return yloc;
	}

	/**
	 * setter of Y position
	 * @param yloc position of mover
	 */
	public void setYloc(int yloc) {
		this.yloc = yloc;
	}

	/**
	 * getter of speed in x direction
	 * @return speed in x direction of Mover 
	 */
	public int getxInc() {
		return xInc;
	}
	
	/**
	 * setter of speed in x direction
	 * @param xInc The speed in x direction of mover
	 */
	public void setxInc(int xInc) {
		this.xInc = xInc;
	}

	/**
	 * getter of speed in y direction
	 * @return The speed in y direction
	 */
	public int getyInc() {
		return yInc;
	}

	/**
	 * setter of speed in y direction
	 * @param yInc The speed in y direction
	 */
	public void setyInc(int yInc) {
		this.yInc = yInc;
	}

	/**
	 * getter of x position
	 * @return Returns the x position of mover
	 */
	public int getXloc() {
		return xloc;
	}

	/**
	 * setter of x position
	 * @param xloc The x position of mover
	 */
	public void setXloc(int xloc) {
		this.xloc = xloc;
	}

	/**
	 * getter of name 
	 * @return name of mover 
	 */
	public String getName() {
		return name;
	}
	/**
	 * setter of name 
	 * @param name of mover
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Constructor for Move
	 * @param name of mover
	 * @param x position
	 * @param y position
	 * @param xInc speed in x direction
	 * @param yInc speed in y direction
	 * @param width of mover
	 * @param height of mover 
	 */
	public Mover(String name, int x, int y, int xInc, int yInc,int width,int height) {
		this.xloc = x;
		this.yloc = y;
		this.xInc = xInc;
		this.yInc = yInc;
		this.name = name;
		this.width=width;
		this.height=height;
	}
	
	/**
	 * This method is to set boundaries in x direction for Movers.
	 * And change x location
	 */
	public void updateXDirection() {
		if (xloc > 1300 || xloc < 100) {
			xInc *= -1;
			
		}
		xloc += xInc;
	}

	/**
	 * This method is to set boundaries in y direction for Movers.
	 * And change y location
	 */
	public void updateYDirection() {

		if (yloc < 200 || yloc > 700) {
			yInc *= -1;
		}
		yloc += yInc;
	}
	

	/**
	 * This method is to call updateXDirection and updateYDirection to set both x,y boundaries for Movers.
	 * And change both x, y locations.
	 */
	public void move() {
		updateXDirection();
		updateYDirection();
	}
}
