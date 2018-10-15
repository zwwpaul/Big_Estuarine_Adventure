package View;
/**
 * @author Wei Zhang
 * @author Yifu Li
 * @author Jiaru Wu
 */
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.Serializable;

import javax.swing.JPanel;

/**
 * class for ask GameOver Panel.    
 */
@SuppressWarnings("serial")
public class EndPanel extends JPanel {
	View view;
	ImageLoader ImageLoader;
	int picNum = 0;
	int background_x=0;
	int background_Incx=-1;
	
	/**
	 * Constructor for EndPanel
	 * @param view is a View type parameter for instance of View class.
	 * @param loader is a ImageLoader type parameter for instance of ImageLoader class.
	 */
    EndPanel(View view, ImageLoader loader){
        this.view =view;
        this.ImageLoader=loader;
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
		g.drawImage(ImageLoader.gameover[picNum], 400, 0, this);
		g.drawImage(ImageLoader.sbtn, 600, 440, this);
		g.drawImage(ImageLoader.qbtn, 600, 640, this);
	}
}
