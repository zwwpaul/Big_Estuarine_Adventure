package Model;

import java.io.Serializable;

/**
 * @author Wei Zhang
 * @author Yifu Li
 * @author Jiaru Wu
 */
import View.Direction;

/**
 * Class for Robot
 */
public class Robot implements Serializable{
	private int xloc;
	private int yloc;
	// temp location value is to set a boundary for
	private int temp_x;
	private int temp_y;
	private final int height = 110;
	private final int width = 50;
	// private boolean north;
	// private boolean south;
	// private boolean east;
	// private boolean west;
	private int speed;
	final int speed_initial = 10;
	final int speed_Fever = 15;
	final int speed_debuff = 5;
	private Direction direction;
	private boolean moving;
	private boolean fever;
	// If robot touches trash,green light will flash.
	// If robot touches animal,red light will flash.
	private boolean touch_trash;
	private boolean touch_animal;

	// boolean moving is to detect whether robot is moving.
	/**
	 * 
	 * @return returns a boolean value.
	 */
	public boolean isMoving() {
		return moving;
	}

	/**
	 * 
	 * @param touch_trash
	 *            A boolean value
	 */
	public void setTouch_trash(boolean touch_trash) {
		this.touch_trash = touch_trash;
	}

	/**
	 * 
	 * @param touch_animal
	 *            A boolean value
	 */
	public void setTouch_animal(boolean touch_animal) {
		this.touch_animal = touch_animal;
	}

	/**
	 * 
	 * @return returns a boolean value.
	 */
	public boolean isTouch_trash() {
		return touch_trash;
	}

	/**
	 * 
	 * @return returns a boolean value.
	 */
	public boolean isTouch_animal() {
		return touch_animal;
	}

	/**
	 * 
	 * @return returns an int value
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * 
	 * @param moving
	 *            a boolean value
	 */
	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	/**
	 * 
	 * @return returns an int value
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * 
	 * @return returns an int value
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * 
	 * @return returns a Direction type value
	 */
	public Direction getDirection() {
		return direction;
	}

	/**
	 * 
	 * @param direction
	 *            a Direction type value
	 */
	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	/**
	 * 
	 * @return returns an int value
	 */
	public int getXloc() {
		return xloc;
	}

	/**
	 * 
	 * @return returns an int value
	 */
	public int getYloc() {
		return yloc;
	}

	/**
	 * 
	 * @return returns a boolean value
	 */
	public boolean isFever() {
		return fever;
	}

	/**
	 * 
	 * @param fever
	 *            A boolean value
	 */
	public void setFever(boolean fever) {
		this.fever = fever;
	}

	/**
	 * 
	 * @param speed
	 *            An int value
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * 
	 * @param xloc 
	 *            An int value for x location
	 */
	public void setXloc(int xloc) {
		this.xloc = xloc;
	}

	/**
	 * 
	 * @param yloc
	 *            An int value for y location
	 */
	public void setYloc(int yloc) {
		this.yloc = yloc;
	}

	/**
	 * Constructor for Plastic_Bags
	 * 
	 * @param xPos
	 *            robot's x position
	 * @param yPos
	 *            robot's y position
	 */
	public Robot(int xPos, int yPos) {
		this.xloc = xPos;
		this.yloc = yPos;
		this.moving = false;
		this.fever = false;
		this.speed = speed_initial;
		this.touch_animal = false;
		this.touch_trash = false;

	}

	/**
	 * This method is to set movement data for robot when the gamestatus is GAME.
	 * 
	 * @param d
	 *            Direction type parameter
	 */
	// This function is called when the game status is GAME.
	public void move(Direction d) {
		if (xloc < 0) {
			xloc = temp_x;
		} else if (xloc > 1300) {
			xloc = temp_x;
		} else if (yloc < 170) {
			yloc = temp_y;
		} else if (yloc > 800) {
			yloc = temp_y;
		} else {
			switch (d) {
			case NORTH:
				this.temp_y = yloc;
				this.yloc -= speed;
				break;
			case NORTHEAST:
				this.temp_x = xloc;
				this.temp_y = yloc;
				this.xloc += speed;
				this.yloc -= speed;
				break;
			case EAST:
				this.temp_x = xloc;
				this.xloc += speed;
				break;
			case SOUTHEAST:
				this.temp_x = xloc;
				this.temp_y = yloc;
				this.xloc += speed;
				this.yloc += speed;
				break;
			case SOUTH:
				this.temp_y = yloc;
				this.yloc += speed;
				break;
			case SOUTHWEST:
				this.temp_x = xloc;
				this.temp_y = yloc;
				this.xloc -= speed;
				this.yloc += speed;
				break;

			case WEST:
				this.temp_x = xloc;
				this.xloc -= speed;
				break;
			case NORTHWEST:
				this.temp_x = xloc;
				this.temp_y = yloc;
				this.xloc -= speed;
				this.yloc -= speed;
				break;
			}
		}
	}

	/**
	 * This method is to set movement data for robot when the gamestatus is HELP.
	 * 
	 * @param d
	 *            Direction type parameter
	 */
	// This function is called when the game status is HELP.
	public void tutorialMove(Direction d) {
		if (xloc < 0) {
			xloc = temp_x;
		} else if (xloc > 1300) {
			xloc = temp_x;
		} else if (yloc < 150) {
			yloc = temp_y;
		} else if (yloc > 480) {
			yloc = temp_y;
		} else {
			switch (d) {
			case NORTH:
				this.temp_y = yloc;
				this.yloc -= speed;
				break;
			case NORTHEAST:
				this.temp_x = xloc;
				this.temp_y = yloc;
				this.xloc += speed;
				this.yloc -= speed;
				break;
			case EAST:
				this.temp_x = xloc;
				this.xloc += speed;
				break;
			case SOUTHEAST:
				this.temp_x = xloc;
				this.temp_y = yloc;
				this.xloc += speed;
				this.yloc += speed;
				break;
			case SOUTH:
				this.temp_y = yloc;
				this.yloc += speed;
				break;
			case SOUTHWEST:
				this.temp_x = xloc;
				this.temp_y = yloc;
				this.xloc -= speed;
				this.yloc += speed;
				break;

			case WEST:
				this.temp_x = xloc;
				this.xloc -= speed;
				break;
			case NORTHWEST:
				this.temp_x = xloc;
				this.temp_y = yloc;
				this.xloc -= speed;
				this.yloc -= speed;
				break;
			}
		}
	}


	/**
	 * This method is to quickly initialize a robot with particular x,y locations.
	 * 
	 * @return returns an instance of Robot
	 */
	public static Robot createRobot() {
		return new Robot(0, 600);
	}

}
