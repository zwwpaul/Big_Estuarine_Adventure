package View;

import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
/**
 * 
 * @author Wei Zhang 
 * @author Yifu Li
 * @author Jiaru Wu
 *
 */
public class IntroPanel extends JPanel {
	private View view;
	private ImageLoader ImageLoader;
	
	/**
	 * 
	 * @param view Instance of View.
	 * @param loader instance of ImageLoader.
	 */
	public IntroPanel(View view, ImageLoader loader) {
		this.view = view;
		this.ImageLoader = loader;
	}
	
	/**
	 * paint the panel
	 * 
	 * @param g
	 *            the base graphic
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(ImageLoader.Intro, 0, 0, this);

	}
}
