package View;
/**
 * @author Wei Zhang
 * @author Yifu Li
 * @author Jiaru Wu
 */
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.Serializable;

import javax.swing.JPanel;
/**
 * Class for SuccessPanel.
 */
@SuppressWarnings("serial")
public class SuccessPanel extends JPanel{
	private View view;
	private ImageLoader ImageLoader;
	int picNum = 0;
	int background_x=0;
	int background_Incx=-1;
	
	
	/**
	 * Constructor for SuccessPanel.
	 * @param view is a View type parameter for instance of View class.
	 * @param loader is a ImageLoader type parameter for instance of ImageLoader class.
	 */
	public SuccessPanel(View view, ImageLoader loader) {
		this.view = view;
		this.ImageLoader = loader;
	}
	   /**
     * paint the panel
     * @param g the base graphic
     */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		picNum=(picNum+1)%4;
		if(background_x<-400 || background_x>0) {
			background_Incx*=-1;
		}
		background_x+=background_Incx;
		g.drawImage(ImageLoader.background3, background_x, 0, this);
		g.drawImage(ImageLoader.sbtn, 600, 440, this);
		g.drawImage(ImageLoader.qbtn, 600, 640, this);
		g.drawImage(ImageLoader.success[picNum], 400, 50, this);

	}
	
}
