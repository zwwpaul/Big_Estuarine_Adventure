 package Controller;

/**
 * @author Wei Zhang
 * @author Yifu Li
 * @author Jiaru Wu
 */
import java.io.IOException;
import java.io.Serializable;

import Model.Model;
import View.ImageLoader;
import View.View;

/**
 * Class for Main.
 */
public class Animation_Main{
	/**
	 * Game will be run here.
	 * @param args  A parameter for main function.
	 * @throws IOException A type of Exception
	 */
	public static void main(String[] args) throws IOException {
		View view = new View();
		Model model=new Model();
		ImageLoader loader=new ImageLoader();
		Controller c =new Controller(view,model,loader);
		c.start();
	}
}
