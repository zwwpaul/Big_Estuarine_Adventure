package View;

/**
 * @author Wei Zhang
 * @author Yifu Li
 * @author Jiaru Wu
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import Model.GameStatus;
import Model.Mover;
import Model.Robot;

/**
 * Class for View.
 */
@SuppressWarnings("serial")
public class View extends JFrame{
//	private JLayeredPane lpane = new JLayeredPane();
	private GameStatus gameStatus;
	public ArrayList<Mover> animalArray;
	public ArrayList<Mover> trashArray;
	private int rxloc = 0;
	private int ryloc = 0;
	static int txloc = 120;
	static int tyloc = 350;
	ImageLoader ImageLoader = new ImageLoader();
	HelpPanel helpPanel = new HelpPanel(this, ImageLoader);
	SuccessPanel successPanel = new SuccessPanel(this, ImageLoader);
	StartPanel startPanel = new StartPanel(this, ImageLoader);
	GamePanel gamePanel = new GamePanel(this, ImageLoader);
	EndPanel endPanel = new EndPanel(this, ImageLoader);
	IntroPanel introPanel= new IntroPanel(this,ImageLoader);
	private int picNum = 0;
	BufferedImage[] curr_pic;
	int time;
	public int total_trash;
	public int bar_change;
	public int bar_fever;
	public int fever_time;

	/**
	 * 
	 * @param picNum An integer number for creating animations
	 */
	public void setPicNum(int picNum) {
		this.picNum = picNum;
	}

	/**
	 * 
	 * @return Returns robot's x location.
	 */
	public int getRxloc() {
		return rxloc;
	}
	
	/**
	 * 
	 * @param rxloc Robot's x location.
	 */
	public void setRxloc(int rxloc) {
		this.rxloc = rxloc;
	}

	/**
	 * 
	 * @return Returns robot's y location.
	 */
	public int getRyloc() {
		return ryloc;
	}

	/**
	 * 
	 * @return Returns an integer number for creating animations
	 */
	public int getPicNum() {
		return picNum;
	}

	/**
	 * 
	 * @param ryloc Robot's y location.
	 */
	public void setRyloc(int ryloc) {
		this.ryloc = ryloc;
	}

	/**
	 * 
	 * @return Returns a temporary x location
	 */
	public static int getTxloc() {
		return txloc;
	}

	/**
	 * 
	 * @param txloc A temporary x location
	 */
	public static void setTxloc(int txloc) {
		View.txloc = txloc;
	}
	/**
	 * 
	 * @return Returns a temporary y location
	 */
	public static int getTyloc() {
		return tyloc;
	}
	/**
	 * 
	 * @param tyloc A temporary y location
	 */
	public static void setTyloc(int tyloc) {
		View.tyloc = tyloc; 
	}

	/**
	 * 
	 * @return Returns the current picture list we will use.
	 */
	public BufferedImage[] getCurr_pic() {
		return curr_pic;
	}

	/**
	 * 
	 * @param curr_pic The current picture list we will use.
	 */
	public void setCurr_pic(BufferedImage[] curr_pic) {
		this.curr_pic = curr_pic;
	}

	/**
	 * Constructor for View class.
	 * @throws IOException IOException
	 */
	public View() throws IOException {
		this.curr_pic = ImageLoader.robot_east;
		this.setTitle("Big Estuarine Adventure");
		this.setSize(1920,1080);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);
		setResizable(true);
		pack();
		setVisible(true);
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = env.getDefaultScreenDevice();
		if(gd.isFullScreenSupported()){
			gd.setFullScreenWindow(this);
		}
 
	}

	/**
	 * paint the panel
	 * 
	 * @param g the base graphic
	 */
	public void paint(Graphics g) {
		super.paintComponents(g);
		if (gameStatus == GameStatus.MENU) {
			this.getContentPane().removeAll();
			this.add(startPanel);
		}
		if (gameStatus == GameStatus.GAME) {
			this.getContentPane().removeAll();
			this.add(gamePanel);
		}
		if (gameStatus == GameStatus.INTRO) {
			this.getContentPane().removeAll();
			this.add(introPanel);
		}
		if (gameStatus == GameStatus.HELP) {
			this.getContentPane().removeAll();
			this.add(helpPanel);
		}
		if (gameStatus == GameStatus.END) {
			this.getContentPane().removeAll();
			this.add(endPanel);
		}
		if (gameStatus == GameStatus.SUCCESS) {
			this.getContentPane().removeAll();
			this.add(successPanel);
		}
		
	}

	/**
	 * This method is to load data from model through controller, and call repaint
	 * method to draw pictures.
	 * If the robot touches trash, the light will be green.
	 * If the robot touches animals, the light will be red.
	 * If the robot is in fever time and catches trash at the same time,
	 * the robot will still be in the fever time and color of light will change to green.
	 * If the robot is in fever time and catches animals at the same time,
	 * the robot will not be in the fever time and color of light will change to red.
	 * 
	 * @param robot Robot type object
	 * @param animal Mover type object
	 * @param trash Mover type object 
	 * @param gs	 Enum type object
	 * @param time Integer type object
	 * @param bar_energy energy bar
	 * @param bar_progress trash bar
	 * @param total_trash number of left trash 
	 * @param feverTime fever time count
	 */
	 /* If the robot touches trash, the light will be green.
	 * If the robot touches animals, the light will be red.
	 * If the robot is in fever time and catches trash at the same time,
	 * the robot will still be in the fever time and color of light will change to green.
	 * If the robot is in fever time and catches animals at the same time,
	 * the robot will not be in the fever time and color of light will change to red.
	 */ 
	
	public void update(Robot robot, ArrayList<Mover> animal, ArrayList<Mover> trash, GameStatus gs, int time, int total_trash, int bar_progress, int bar_energy,int feverTime) {
		// If robot is moving, robot will do actions during walk.
		if (robot.isMoving()) {
			setPicNum((picNum + 1) % curr_pic.length);
			if (robot.getDirection() == (Direction.WEST)) {
				if (robot.isFever()) {
					this.curr_pic=ImageLoader.robot_fever_west;
					if(robot.isTouch_animal()) {
						this.curr_pic=ImageLoader.robot_wrong_west;
					}else if(robot.isTouch_trash()) {
						this.curr_pic = ImageLoader.robot_fever_correct_west;
					}
				} else {
					this.curr_pic=ImageLoader.robot_west;
					if(robot.isTouch_animal()) {
						this.curr_pic = ImageLoader.robot_wrong_west;
					}else if (robot.isTouch_trash()) {
						this.curr_pic =ImageLoader.robot_correct_west;
					}
				}
			}
			if (robot.getDirection() == (Direction.EAST)) {
				if (robot.isFever()) {
					this.curr_pic=ImageLoader.robot_fever_east;
					if (robot.isTouch_trash()) {
						this.curr_pic =ImageLoader.robot_fever_correct_east;
					}
				} else {
					this.curr_pic=ImageLoader.robot_east;
					if(robot.isTouch_animal()) {
						this.curr_pic = ImageLoader.robot_wrong_east;
					}else if (robot.isTouch_trash()) {
						this.curr_pic =ImageLoader.robot_correct_east;
					}
				}
			} 
		} else {
			setPicNum((picNum) % curr_pic.length);
			if (robot.isFever()) {
				if (robot.getDirection() == (Direction.EAST)) {
					this.curr_pic = ImageLoader.robot_fever_east;
					if (robot.isTouch_trash()) {
						this.curr_pic = ImageLoader.robot_fever_correct_east;
					}
					if(robot.isTouch_animal()) {
						this.curr_pic = ImageLoader.robot_wrong_east;
					}
				}
				if (robot.getDirection() == (Direction.WEST)) {
					this.curr_pic = ImageLoader.robot_fever_west;
					if (robot.isTouch_trash()) {
						this.curr_pic = ImageLoader.robot_fever_correct_west;
					}
					if(robot.isTouch_animal()) {
						this.curr_pic = ImageLoader.robot_wrong_east;
					}
				}
			}
		}
		
		this.rxloc = robot.getXloc();
		this.ryloc = robot.getYloc();
		this.gameStatus = gs;
		this.animalArray = animal;
		this.trashArray = trash;
		this.time = time;
		this.repaint();
		this.total_trash=total_trash;
		this.bar_change=bar_progress;
		this.bar_fever=bar_energy;
		if(feverTime / 1000 <= 10) {
			this.fever_time=feverTime/1000;
		}
		
	}

}
