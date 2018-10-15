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
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Crab;
import Model.Fish;
import Model.Mover;
import Model.Turtle;

/**
 * Class for StartPanel.
 */
@SuppressWarnings("serial")
public class StartPanel extends JPanel {
	ImageLoader ImageLoader;
	View view;
	int background_x=0;
	int background_Incx=-1;
	BufferedImage[] curr_img_trash = null;
	BufferedImage[] curr_img_animal = null;
	
	/**
	 * Constructor for StartPanel class.
	 * @param view is a View type parameter for instance of View class.
	 * @param loader is a ImageLoader type parameter for instance of ImageLoader class.
	 */
	public StartPanel(View view, ImageLoader loader) {
		this.ImageLoader=loader;
		this.view=view;
	}
	
	/**
	 * Method is to draw single animal picture
	 * Support method
	 * @param g the base graphic
	 * @param m Mover type object
	 * @param img BufferedImage type object
	 */
	public void paintAnimal(Graphics g, Mover m, BufferedImage img) {
		m.move();
		g.drawImage(img, m.getXloc(), m.getYloc(), this);
	}
	
	/**
	 * Method is to draw multiple animals
	 * Using paintAnimal support method
	 * @param g the base graphic
	 * @param animals the ArrayList for several Mover objects
	 */
	public void paintAnimals(Graphics g, ArrayList<Mover> animals) {
		for (Mover m : animals) {
			if (m instanceof Fish) {
				curr_img_animal = ImageLoader.picslist_fish_forward;
			} else if (m instanceof Crab) {
				curr_img_animal = ImageLoader.crab;
			} else if (m instanceof Turtle) {
				curr_img_animal = ImageLoader.picslist_turtle;
			}
			if (m.getxInc() > 0) {
				paintAnimal(g, m, curr_img_animal[0]);
			} else {
				paintAnimal(g, m, curr_img_animal[1]);
			}
		}
	}
	 /**
     * paint the panel
     * @param g the base graphic
     */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(background_x<-400 || background_x>0) {
			background_Incx*=-1;
		}
		background_x+=background_Incx;
		g.drawImage(ImageLoader.background3, background_x, 0, this);
		g.drawImage(ImageLoader.title, 250, 100, this);
		g.drawImage(ImageLoader.robot_alpha, 200, 600, this);
		paintAnimals(g, view.animalArray);
		g.drawImage(ImageLoader.sbtn, 600, 440, this);
		g.drawImage(ImageLoader.qbtn, 600, 670, this);
		
	}


}
