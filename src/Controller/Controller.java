package Controller;

/**
 * @author Wei Zhang
 * @author Yifu Li
 * @author Jiaru Wu
 */

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Timer;

import Model.GameStatus;
import Model.Model;
import View.Direction;
import View.ImageLoader;
import View.View;

/**
 * Class for Controller.
 */
public class Controller {
	private Model model;
	private View view;
	private ImageLoader ImageLoader;
	Timer timer;
	final int drawDelay = 80; // msec
	Action drawAction;

	/**
	 * Constructor for Controller. Attribute --drawAction contains all actions such
	 * as update.....
	 * 
	 * @param v
	 *            View type objectb
	 * @param m
	 *            Model type object
	 * @param loader
	 *            ImageLoader type object
	 * @throws IOException
	 *             IOException
	 */
	public Controller(View v, Model m, ImageLoader loader) throws IOException {
		this.view = v;
		this.model = m;
		this.ImageLoader = loader;
		view.addKeyListener(new ArrowKey());
		view.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				model.clicked(x, y);
			}
		});
		drawAction = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				if (model.isClick_pause()) {
				} else { 
					model.update();
					if (model.getStatus() == GameStatus.HELP) {
						model.items_caught(model.getTutorial_items());
						model.tutorial();
						view.update(model.getRobot(), model.getTutorial_items(), model.getTutorial_items(), model.getStatus(),
								model.getTime(),model.getTotal_trash(), model.getBar_left(),model.getBar_left2(),model.getFeverTime());
					} else {
						view.update(model.getRobot(), model.getArrayOfAnimal(), model.getArrayOfTrash(), model.getStatus(),
								model.getTime(),model.getTotal_trash(), model.getBar_left(),model.getBar_left2(),model.getFeverTime());
					}

				}
			}
		};
		;

	}

	/**
	 * This method is to use timer to run the game.
	 */
	public void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				timer = new Timer(drawDelay, drawAction);
				timer.start();
			}
		});
	}

	/**
	 * Internal class for KeyListener.
	 * 
	 * @author Wei Zhang, Yifu Li, Jiaru Wu
	 *
	 */
	public class ArrowKey implements KeyListener {

		private final Set<Integer> pressed = new HashSet<Integer>();

		/**
		 * When pressing particular arrow keys, method is called.
		 */
		@Override
		public void keyPressed(KeyEvent e) {
			pressed.add(e.getKeyCode());
			int keycode = e.getKeyCode();
			if (model.isClick_pause() == false) {
				switch (pressed.size()) {
				case 1:
					switch (keycode) {
					case KeyEvent.VK_UP:
						model.getRobot().setMoving(true);
						model.getRobot().setDirection(Direction.NORTH);
						if (model.getStatus() == GameStatus.GAME) {
							model.getRobot().move(Direction.NORTH);
						}
						if (model.getStatus() == GameStatus.HELP) {
							model.getRobot().tutorialMove(Direction.NORTH);
						}
						break;
					case KeyEvent.VK_DOWN:
						model.getRobot().setMoving(true);
						model.getRobot().setDirection(Direction.SOUTH);
						// DOWN
						if (model.getStatus() == GameStatus.GAME) {
							model.getRobot().move(Direction.SOUTH);
						}
						if (model.getStatus() == GameStatus.HELP) {
							model.getRobot().tutorialMove(Direction.SOUTH);
						}
						break;
					case KeyEvent.VK_LEFT:
						model.getRobot().setMoving(true);
						model.getRobot().setDirection(Direction.WEST);
						if (model.getStatus() == GameStatus.GAME) {
							model.getRobot().move(Direction.WEST);
						}
						if (model.getStatus() == GameStatus.HELP) {
							model.getRobot().tutorialMove(Direction.WEST);
						}
						break;
					case KeyEvent.VK_RIGHT:
						model.getRobot().setMoving(true);
						model.getRobot().setDirection(Direction.EAST);
						if (model.getStatus() == GameStatus.GAME) {
							model.getRobot().move(Direction.EAST);
						}
						if (model.getStatus() == GameStatus.HELP) {
							model.getRobot().tutorialMove(Direction.EAST);
						}
						break;
					case KeyEvent.VK_S:
						try {
							ResourceManager.savemodel(model);
						}
						catch (Exception e1) {
							e1.printStackTrace();
							System.out.println("Couldn't save.");
						}
						break;
					case KeyEvent.VK_L:
						try {
						model=ResourceManager.loadmodel();
					} catch (Exception e1) {
						e1.printStackTrace(); 
						System.out.println("Couldn't load");
					}
						break;
					case KeyEvent.VK_ENTER:
						if(model.getStatus()==GameStatus.INTRO) {
							model.setStatus(GameStatus.HELP);
							model.getRobot().setXloc(30);
							model.getRobot().setYloc(203);
						}
						break;
					}

				case 2:
					if (pressed.contains(KeyEvent.VK_UP) && pressed.contains(KeyEvent.VK_RIGHT)) {
						model.getRobot().setMoving(true);
						model.getRobot().setDirection(Direction.NORTHEAST);
						if (model.getStatus() == GameStatus.GAME) {
							model.getRobot().move(Direction.NORTHEAST);
						}
						if (model.getStatus() == GameStatus.HELP) {
							model.getRobot().tutorialMove(Direction.NORTHEAST);
						}
					}
					if (pressed.contains(KeyEvent.VK_UP) && pressed.contains(KeyEvent.VK_LEFT)) {
						model.getRobot().setMoving(true);
						model.getRobot().setDirection(Direction.NORTHWEST);
						if (model.getStatus() == GameStatus.GAME) {
							model.getRobot().move(Direction.NORTHWEST);
						}
						if (model.getStatus() == GameStatus.HELP) {
							model.getRobot().tutorialMove(Direction.NORTHWEST);
						}
					}
					if (pressed.contains(KeyEvent.VK_DOWN) && pressed.contains(KeyEvent.VK_RIGHT)) {
						model.getRobot().setMoving(true);
						model.getRobot().setDirection(Direction.SOUTHEAST);
						if (model.getStatus() == GameStatus.GAME) {
							model.getRobot().move(Direction.SOUTHEAST);
						}
						if (model.getStatus() == GameStatus.HELP) {
							model.getRobot().tutorialMove(Direction.SOUTHEAST);
						}
					}
					if (pressed.contains(KeyEvent.VK_DOWN) && pressed.contains(KeyEvent.VK_LEFT)) {
						model.getRobot().setMoving(true);
						model.getRobot().setDirection(Direction.SOUTHWEST);
						if (model.getStatus() == GameStatus.GAME) {
							model.getRobot().move(Direction.SOUTHWEST);
						}
						if (model.getStatus() == GameStatus.HELP) {
							model.getRobot().tutorialMove(Direction.SOUTHWEST);
						}
					}
				}
			}
		}

		/**
		 * When player stop pressing arrow keys, the robot stop moving.
		 */
		@Override
		public void keyReleased(KeyEvent e) {
			// If the key is released, the ismoving flag will change to false.
			pressed.clear();
			model.getRobot().setMoving(false);

		}

		/**
		 * Nothing happen
		 */
		@Override
		public void keyTyped(KeyEvent e) {

		}
	}
}