package View;
/**
 * @author Wei Zhang
 * @author Yifu Li
 * @author Jiaru Wu
 */
import java.awt.image.BufferedImage;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;
/**
 * Class for an ImageLoader
 */
public class ImageLoader {
	BufferedImage robot_alpha;
	BufferedImage[] robot_west=new BufferedImage[8];
	BufferedImage[] robot_east=new BufferedImage[8];
	BufferedImage[] robot_fever_west=new BufferedImage[8];
	BufferedImage[] robot_fever_east=new BufferedImage[8];
	BufferedImage[] robot_fever_correct_west=new BufferedImage[8];
	BufferedImage[] robot_fever_correct_east=new BufferedImage[8];
	BufferedImage[] robot_correct_west=new BufferedImage[8];
	BufferedImage[] robot_correct_east=new BufferedImage[8];
	BufferedImage[] robot_wrong_west=new BufferedImage[8];
	BufferedImage[] robot_wrong_east=new BufferedImage[8];
	BufferedImage[] picslist_fish_forward;
	BufferedImage[] crab;
	BufferedImage[] picslist_battery;
	BufferedImage[] picslist_boot ;
	BufferedImage[] picslist_normal_trash1;
	BufferedImage[] picslist_bottles;
	BufferedImage title;
	BufferedImage[] picslist_turtle ;
	BufferedImage sbtn;
	BufferedImage qbtn;
	BufferedImage hpbtn;
	BufferedImage bkbtn;
	BufferedImage[] new_trash;
	BufferedImage keys;
	BufferedImage tuition;
	BufferedImage background3;
	BufferedImage bar;
	BufferedImage Intro;
	BufferedImage[] gameover=new BufferedImage[4];
	BufferedImage[] success=new BufferedImage[4];
	BufferedImage pause;
	
	/**
	 * Contructor for ImageLoader class.
	 */
	public ImageLoader(){
		loadUI();
		loadRobot_West();
		loadRobot_East();
		loadTrash();
	}

	/**
	 * This method is to load single picture file
	 * @param filepath This is a string type object to represent file_path. 
	 * @return Returns a bufferedImage object.
	 */
	private BufferedImage createImage(String filepath) {

		BufferedImage bufferedImage;
		try {
			bufferedImage = ImageIO.read(new File(filepath));
			return bufferedImage;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}


	/**
	 * This method is to load walking pictures for robot.
	 */
	public void loadRobot_West() {
		BufferedImage[] pics = new BufferedImage[8];
		BufferedImage[] pics2 = new BufferedImage[8];
		BufferedImage[] pics3 = new BufferedImage[8];
		BufferedImage[] pics4 = new BufferedImage[8];
		BufferedImage[] pics5 = new BufferedImage[8];
		for (int i = 0; i < 8; i++) {
			BufferedImage img = createImage("Images/Robot_west.png");
			BufferedImage img2 = createImage("Images/Robot_fever_west.png");
			BufferedImage img3 = createImage("Images/Robot_fever_correct_west .png");
			BufferedImage img4 = createImage("Images/Robot_correct_west.png");
			BufferedImage img5 = createImage("Images/Robot_wrong_west.png");
			for (int j = 0; j < 8; j++) {
				pics[j] = img.getSubimage(107* j, 0, 107, 112);
				pics2[j] = img2.getSubimage(107* j, 0, 107, 112);
				pics3[j] = img3.getSubimage(107* j, 0, 107, 112);
				pics4[j] = img4.getSubimage(107* j, 0, 107, 112);
				pics5[j] = img5.getSubimage(107* j, 0, 107, 112);
			}
		}
		this.robot_west=pics;
		this.robot_fever_west=pics2;
		this.robot_fever_correct_west=pics3;
		this.robot_correct_west=pics4;
		this.robot_wrong_west=pics5;
	}
	
	
	/**
	 * This method is to load walking pictures for robot.
	 */
	public void loadRobot_East() {
		BufferedImage[] pics = new BufferedImage[8];
		BufferedImage[] pics2 = new BufferedImage[8];
		BufferedImage[] pics3 = new BufferedImage[8];
		BufferedImage[] pics4 = new BufferedImage[8];
		BufferedImage[] pics5 = new BufferedImage[8];
		for (int i = 0; i < 8; i++) {
			BufferedImage img = createImage("Images/Robot_east.png");
			BufferedImage img2 = createImage("Images/Robot_fever_east.png");
			BufferedImage img3 = createImage("Images/Robot_fever_correct_east.png");
			BufferedImage img4 = createImage("Images/Robot_correct_east .png");
			BufferedImage img5 = createImage("Images/Robot_wrong_east.png");
			for (int j = 0; j < 8; j++) {
				pics[j] = img.getSubimage(107* j, 0, 107, 112);
				pics2[j] = img2.getSubimage(107* j, 0, 107, 112);
				pics3[j] = img3.getSubimage(107* j, 0, 107, 112);
				pics4[j] = img4.getSubimage(107* j, 0, 107, 112);
				pics5[j] = img5.getSubimage(107* j, 0, 107, 112);
			}
		}
		this.robot_east=pics;
		this.robot_fever_east=pics2;
		this.robot_fever_correct_east=pics3;
		this.robot_correct_east=pics4;
		this.robot_wrong_east=pics5;
	}
	/**
	 * This is a method for loading trash pictures
	 */
	public void loadTrash() {
		BufferedImage[] pics1 = new BufferedImage[4];
		BufferedImage[] pics2 = new BufferedImage[4];
		BufferedImage[] pics3 = new BufferedImage[4];
		BufferedImage[] pics4 = new BufferedImage[4];
		BufferedImage[] pics5 = new BufferedImage[4];
		for (int i = 0; i < 4; i++) {
			pics1[i] = createImage("Images/" + Items.SUCCESS.getName() + Integer.toString(i + 1) + ".png");
			pics2[i] = createImage("Images/" + Items.GAMEOVER.getName() + Integer.toString(i + 1) + ".png");
			pics3[i] = createImage("Images/" + Items.TRASH3.getName() + "_" + Integer.toString(i + 1) + ".png");
			pics4[i] = createImage("Images/" + Items.TRASH.getName() + Integer.toString(i + 1) + ".png");
			pics5[i] = createImage("Images/Battery/" + Items.BATTERY.getName() + Integer.toString(i + 1) + ".png");
		}
		this.success = pics1;
		this.gameover = pics2;
		this.picslist_bottles = pics3;
		this.picslist_normal_trash1 = pics4;
		this.picslist_battery = pics5;
	}
	
	/**
	 * This is a method for loding pictures of UI items
	 */
	public void loadUI() {
		this.pause = createImage("Images/pause.png"); 
		this.bar = createImage("Images/bar.png");
		this.robot_alpha = createImage("Images/1111.png");
		this.keys = createImage("Images/keys.png");
		this.tuition = createImage("Images/tuition.png");
		this.Intro = createImage("Images/Intro.png");
		this.sbtn = createImage("Images/Play.png");
		this.hpbtn = createImage("Images/Help button.png");
		this.qbtn = createImage("Images/Exit.png");
		this.bkbtn = createImage("Images/Back.png");
		this.background3 = createImage("Images/background4.png");
		this.title = createImage("Images/title.png");
		BufferedImage[] pics1 = new BufferedImage[2];
		BufferedImage[] pics2 = new BufferedImage[2];
		BufferedImage[] pics3 = new BufferedImage[2];
		BufferedImage[] pics4 = new BufferedImage[2];
		for (int i = 0; i < 2; i++) {
			pics1[i] = createImage("Images/" + Items.BLUEFISH.getName() + Integer.toString(i + 1) + ".png");
			pics2[i] = createImage("Images/" + Items.TURTLE.getName() + Integer.toString(i + 1) + ".png");
			pics3[i] = createImage("Images/" + Items.NEW_TRASH.getName() + Integer.toString(i + 1) + ".png");
			pics4[i] = createImage("Images/" + Items.CRAB.getName() + ".png");
		}
		this.picslist_fish_forward=pics1;
		this.picslist_turtle=pics2;
		this.new_trash=pics3;
		this.crab=pics4;
	}

}
