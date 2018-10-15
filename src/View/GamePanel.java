package View;

/**
 * @author Wei Zhang
 * @author Yifu Li
 * @author Jiaru Wu
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

import Model.Battery;
import Model.Boots;
import Model.Crab;
import Model.Fish;
import Model.Mover;
import Model.Normal_Trash;
import Model.Plastic_Bags;
import Model.Turtle;

/**
 * class for Game Panel.
 */
@SuppressWarnings("serial")
public class GamePanel extends JPanel {
	final int left = 0;
	final int right = 1;
	int picNum = 0;
	View view;
	int background_x = 0;
	int background_Incx = -1;
	BufferedImage[] curr_img_trash = null;
	BufferedImage[] curr_img_animal = null;
	ImageLoader ImageLoader;
	Random random = new Random();

	/**
	 * Constructor for Game Panel.
	 * 
	 * @param view
	 *            is a View type parameter for instance of View class.
	 * @param loader
	 *            is a ImageLoader type parameter for instance of ImageLoader class.
	 */
	public GamePanel(View view, ImageLoader loader) {
		this.view = view;
		this.ImageLoader = loader;
	}

	/**
	 * Method is to draw single animal picture Support method
	 * 
	 * @param g
	 *            the base graphic
	 * @param m
	 *            Mover type object
	 * @param img
	 *            BufferedImage type object
	 */
	public void paintAnimal(Graphics g, Mover m, BufferedImage img) {
		m.move();
		g.drawImage(img, m.getXloc(), m.getYloc(), this);
	}

	/**
	 * Method is to draw multiple animals Using paintAnimal support method
	 * 
	 * @param g
	 *            the base graphic
	 * @param animals
	 *            the ArrayList for several Mover objects
	 */
	public void paintAnimals(Graphics g, ArrayList<Mover> animals) {
		if (!animals.isEmpty()) {
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
	}

	/**
	 * Method is to draw single trash Support method
	 * 
	 * @param g
	 *            the base graphic
	 * @param m
	 *            Mover type object
	 * @param imgs
	 *            An ArrayList with BufferedImage type which contains many
	 *            BufferedImage type objects.
	 */
	public void paintTrash(Graphics g, Mover m, BufferedImage[] imgs) {
		m.move();
		g.drawImage(imgs[random.nextInt(curr_img_trash.length)], m.getXloc(), m.getYloc(), this);
	}

	/**
	 * Method is to draw multiple trash Using paintTrash support method
	 * 
	 * @param g
	 *            the base graphic
	 * @param trash
	 *            Mover type object
	 */
	public void paintTrashes(Graphics g, ArrayList<Mover> trash) {
		if (!trash.isEmpty()) { 
			for (Mover m : trash) {
				if (m instanceof Normal_Trash) {
					curr_img_trash = ImageLoader.picslist_normal_trash1;
				} else if (m instanceof Battery) {
					curr_img_trash = ImageLoader.picslist_battery;
				} else if (m instanceof Boots) {
					curr_img_trash = ImageLoader.new_trash;
				} else if (m instanceof Plastic_Bags) {
					curr_img_trash = ImageLoader.picslist_bottles;
				}
				paintTrash(g, m, curr_img_trash);
			}
		}
	}

	/**
	 * paint the panel
	 * 
	 * @param g
	 *            the base graphic
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (background_x < -400 || background_x > 0) {
			background_Incx *= -1;
		}
		background_x += background_Incx;
		g.drawImage(ImageLoader.background3, background_x, 0, this);
		Font fnt1 = new Font("Comic Sans MS", Font.BOLD, 35);
		g.setFont(fnt1);
		g.drawString("Left Time: " + (view.time) / 1000, 100, 100);
		g.drawString("Left Trash: " + (view.total_trash), 600, 100);
		g.drawString("Fever Energy: " + (view.fever_time), 937, 100);
		g.drawImage(ImageLoader.bar, 550, 150, this);
		g.setColor(Color.RED);
		g.drawRect(550, 150, 378, 38);
		g.fillRect(551, 154, view.bar_change, 31);
		g.drawImage(ImageLoader.bar, 937, 150, this);
		g.setColor(Color.YELLOW);
		g.drawRect(937, 150, 378, 38);
		g.fillRect(937, 154, view.bar_fever, 31);
		g.drawImage(ImageLoader.pause, 450, 55, this);
		paintAnimals(g, view.animalArray);
		paintTrashes(g, view.trashArray);
		g.drawImage(view.curr_pic[view.getPicNum()], view.getRxloc(), view.getRyloc(), this);

	}

}
