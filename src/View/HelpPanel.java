package View;

/**
 * @author Wei Zhang
 * @author Yifu Li
 * @author Jiaru Wu
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
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
 * class for ask Tutorial Panel.
 */
@SuppressWarnings("serial")
public class HelpPanel extends JPanel {
	Rectangle energy;
	View view;
	ImageLoader ImageLoader;
	BufferedImage curr_pic;

	/**
	 * Constructor for HelpPanel.
	 * 
	 * @param view
	 *            is a View type parameter for instance of View class.
	 * @param loader
	 *            is a ImageLoader type parameter for instance of ImageLoader class.
	 */
	public HelpPanel(View view, ImageLoader loader) {
		this.view = view;
		this.ImageLoader = loader;

	}

	/**
	 * method is to set particular picture for Tutorial(Help) Panel.
	 * 
	 * @param g
	 *            the base graphic
	 * @param m
	 *            Mover type object
	 * @param imgs
	 *            BufferedImage type object
	 */
	public void paintItem(Graphics g, ArrayList<Mover> m, BufferedImage imgs) {
		if (!m.isEmpty()) {
			Mover item = m.get(0);
			if (item instanceof Normal_Trash) {
				curr_pic = ImageLoader.picslist_normal_trash1[0];
			}
			if (item instanceof Battery) {
				curr_pic = ImageLoader.picslist_battery[0];
			}
			if (item instanceof Boots) {
				curr_pic = ImageLoader.new_trash[0];
			}
			if (item instanceof Plastic_Bags) {
				curr_pic = ImageLoader.picslist_bottles[0];
			}
			if (item instanceof Fish) {
				curr_pic = ImageLoader.picslist_fish_forward[0];
			}
			if (item instanceof Turtle) {
				curr_pic = ImageLoader.picslist_turtle[0];
			}
			if (item instanceof Crab) {
				curr_pic = ImageLoader.crab[0];
			}
			g.drawImage(curr_pic, item.getXloc(), item.getYloc(), this);

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
		g.drawImage(ImageLoader.background3, 0, 0, this);
		Font fnt1 = new Font("Comic Sans MS", Font.BOLD, 35);
		g.setFont(fnt1);
		g.drawString("Left Time: " + (view.time) / 1000, 70, 100);
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
		g.drawImage(ImageLoader.tuition, 0, 600, this);
		g.drawImage(ImageLoader.keys, 50, 600, this);
		g.drawImage(ImageLoader.crab[0], 1000, 600, this);
		g.drawImage(ImageLoader.picslist_fish_forward[0], 1000, 680, this);
		g.drawImage(ImageLoader.picslist_turtle[1], 1000, 730, this);
		paintItem(g, view.animalArray, curr_pic);
		g.drawImage(view.curr_pic[view.getPicNum()], view.getRxloc(), view.getRyloc(), this);
	}

}
