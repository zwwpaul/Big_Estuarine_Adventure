package Model;

import java.io.Serializable;
/**
 * @author Wei Zhang
 * @author Yifu Li
 * @author Jiaru Wu
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Class for Model.
 */
public class Model implements Serializable{

	private int time = 90000;
	private int trashTime = 0;
	private int animalTime = 0;
	private final int maxHight = 1024;
	private final int maxWidth = 1024;
	private final int trash_maxCapacity = 15;
	private final int animal_maxCapacity = 10;
	private int fishPenalty = 7;
	private int crabPenalty = 4;
	private int turtlePenalty = 3;
	private int batteryPenalty = 5;

	private int betteryPenalty = 5;
	private ArrayList<Mover> arrayOfTrash;
	private ArrayList<Mover> arrayOfAnimal;
	private ArrayList<Mover> fishlist;
	private ArrayList<Mover> trashlist;
	private ArrayList<Mover> tutorial_items;
	private Robot robot;
	private static GameStatus status;
	// These attributs for tutorial panel.
	private boolean fish = false;
	private boolean crab = false;
	private boolean turtle = false;
	private boolean trash1 = false;
	private boolean trash2 = false;
	private boolean trash3 = false;
	private boolean trash4 = false;
	// This attribute is for fever time.
	private int be_fever = 0;
	private int feverTime = 0;
	private boolean clean = false;
	// Trash left bar
	private int total_trash = 25;
	private int bar_left = 376;
	private int bar_change = 376 / 25;
	//Fever time bar
	private int bar_change2= 376/10;
	private int bar_left2 = 0;

	private boolean click_pause=false;
	private Random random = new Random();

	/**
	 * Getter of GameStatus
	 * 
	 * @return returns gamestatus
	 */
	public GameStatus getStatus() {
		return status;
	}
	/**
	 * 
	 * @return Returns the elapse of creating trash
	 */
	public int getTrashTime() {
		return trashTime;
	}
	/**
	 * 
	 * @return Returns the arraylist of tutorial items
	 */
	public ArrayList<Mover> getTutorial_items() {
		return tutorial_items;
	}
	/**
	 * 
	 * @return Returns fever time
	 */
	public int getFeverTime() {
		return feverTime;
	}
	/**
	 * 
	 * @return Returns an arraylist of trash
	 */
	public ArrayList<Mover> getArrayOfTrash() {
		return arrayOfTrash;
	}
	
	/**
	 * 
	 * @return Returns an arraylist of animals
	 */
	public ArrayList<Mover> getArrayOfAnimal() {
		return arrayOfAnimal;
	}
	/**
	 * 
	 * @return Return a boolean value which indicates whether player press pause button or not.
	 */
	public boolean isClick_pause() {
		return click_pause;
	}
	
	/**
	 * 
	 * @param animalTime The elapse of creating animals
	 */
	public void setAnimalTime(int animalTime) {
		this.animalTime = animalTime;
	}
	/**
	 * 
	 * @param trashTime The elapse of creating trash
	 */
	public void setTrashTime(int trashTime) {
		this.trashTime = trashTime;
	}

	/**
	 * 
	 * @param tutorial_items An arraylist of tutorial items that include both trash and animals
	 */
	public void setTutorial_items(ArrayList<Mover> tutorial_items) {
		this.tutorial_items = tutorial_items;
	}

	/**
	 * 
	 * @param feverTime The fever time.
	 */
	public void setFeverTime(int feverTime) {
		this.feverTime = feverTime;
	}
	
	/**
	 * 
	 * @param total_trash The total amount of trash.
	 */
	public void setTotal_trash(int total_trash) {
		this.total_trash = total_trash;
	}

	/**
	 * 
	 * @return Returns an instance of robot.
	 */
	public Robot getRobot() {
		return robot;
	}
	/**
	 * 
	 * @return Returns the total amount of trash
	 */
	public int getTotal_trash() {
		return total_trash;
	}
	
	/**
	 * 
	 * @return Returns the process bar in value
	 */
	public int getBar_left() {
		return bar_left;
	}

	/**
	 * 
	 * @return Returns the energy bar in value
	 */
	public int getBar_left2() {
		return bar_left2;
	}

	/**
	 * Getter of time
	 * 
	 * @return time of game
	 */
	public int getTime() {
		return time;
	}

	/**
	 * Setter of time
	 * 
	 * @param time
	 *            of game
	 */
	public void setTime(int time) {
		this.time = time;
	}

	/**
	 * 
	 * @param status
	 *            GameStatus type parameter.
	 */
	public void setStatus(GameStatus status) {
		Model.status = status;
	}

	/**
	 * Constructor for Model.
	 */
	// Constructor
	public Model() {
		this.arrayOfAnimal = new ArrayList<Mover>();
		this.arrayOfTrash = new ArrayList<Mover>();
		this.robot = Robot.createRobot();
		Model.status = GameStatus.MENU;
		this.trashlist = makeTrashes();
		this.fishlist = makeAnimals();
		this.tutorial_items = new ArrayList<Mover>();
	}

	// This method is to create several creatures and trash.
	// Example: if fish has been created, boolean fish= true.
	/**
	 * give game sample
	 */
	public void tutorial() {
		if (getStatus() == GameStatus.HELP) {
			if (tutorial_items.isEmpty()) {
				if (trash1 == false) {
					tutorial_items.add(new Normal_Trash(200, 230));
					trash1 = true;
				} else if (trash2 == false) {
					tutorial_items.add(new Battery(400, 260));
					trash2 = true;
				} else if (trash3 == false) {
					tutorial_items.add(new Boots(600, 340));
					trash3 = true;
				} else if (trash4 == false) {
					tutorial_items.add(new Plastic_Bags(800, 450));
					trash4 = true;
				} else if (fish == false) {
					tutorial_items.add(new Fish(1000, 500));
					fish = true;
				}else if (turtle == false) {
					tutorial_items.add(new Turtle(400, 200));
					turtle = true;
				} else if (crab == false) {
					tutorial_items.add(new Crab(500, 430));
					crab = true;
				}
			}
		}
	}

	// If the robot touches an item, item will be removed.
	/**
	 * test the items are caught or not
	 * 
	 * @param items
	 *            on the game as an arrayList
	 */
	public void items_caught(ArrayList<Mover> items) {
		for (Iterator<Mover> iter = items.iterator(); iter.hasNext();) {
			Mover m = iter.next();
			if (m.getXloc() > robot.getXloc() && m.getXloc() < robot.getXloc() + robot.getWidth()
					&& m.getYloc() > robot.getYloc() && m.getYloc() < robot.getYloc() + robot.getHeight()) {
				if (m instanceof Fish) {
					time -= fishPenalty * 1000;
					feverTime = 0;
					bar_left2=0;
					robot.setTouch_animal(true);
					robot.setFever(false);
					robot.setTouch_trash(false);
				} else if (m instanceof Turtle) {
					time -= turtlePenalty * 1000;
					feverTime = 0;
					bar_left2=0;
					robot.setTouch_animal(true);
					robot.setFever(false);
					robot.setTouch_trash(false);
				} else if (m instanceof Crab) {
					time -= crabPenalty * 1000;
					feverTime = 0;
					bar_left2=0;
					robot.setTouch_animal(true);
					robot.setFever(false);
					robot.setTouch_trash(false);
				} else if (m instanceof Battery) {
					feverTime = 0;
					bar_left2=0;
					robot.setFever(false);
					robot.setTouch_animal(false);
					robot.setTouch_trash(true);
				} else if (m instanceof Boots) {

					robot.setTouch_animal(false);
					robot.setTouch_trash(true);
				} else if (m instanceof Normal_Trash) {

					robot.setTouch_animal(false);
					robot.setTouch_trash(true);
				} else if (m instanceof Plastic_Bags) {

					robot.setTouch_animal(false);
					robot.setTouch_trash(true);
				}
				if (status == GameStatus.GAME ||status == GameStatus.HELP) {
					if (m instanceof Boots || m instanceof Normal_Trash || m instanceof Plastic_Bags
							|| m instanceof Battery) {
						total_trash -= 1;
						bar_left -= bar_change;
					}
				}
				iter.remove();
			}
		}
	}

	// This method is to randomly make single trash, and it is a support method for
	// makeTrashes.
	/**
	 * randomly make new trash
	 * 
	 * @return Makes single trash
	 */
	public Mover makeTrash() {
		Mover result = null;
		int random2 = random.nextInt(4);

		if (random2 == 0) {
			result = new Battery((int) random.nextInt(1200) + 100, (int) random.nextInt(650) + 200);

		} else if (random2 == 1) {
			result = new Boots((int) random.nextInt(1200) + 100, (int) random.nextInt(650) + 200);

		} else if (random2 == 2) {
			result = new Plastic_Bags((int) random.nextInt(1200) + 100, (int) random.nextInt(650) + 200);

		} else {
			result = new Normal_Trash((int) random.nextInt(1200) + 100, (int) random.nextInt(650) + 200);
		}
		return result;
	}

	/**
	 * This method is to randomly make single animal, and it is a support method for
	 * makeAnimals.
	 * 
	 * @return Makes single animal
	 */
	// This method is to randomly make single animal, and it is a support method for
	// makeAnimals.
	public Mover makeAnimal() {
		Mover result;
		int index = random.nextInt(4);
		if (index == 1) {
			result = new Fish((int) random.nextInt(1200) + 100, (int) random.nextInt(650) + 200);
		} else if (index == 2) {
			result = new Turtle((int) random.nextInt(1200) + 100, (int) random.nextInt(650) + 200);
		} else {
			result = new Crab((int) random.nextInt(1200) + 100, (int) random.nextInt(650) + 200);
		}
		return result;
	}

	/**
	 * Makes trash based on max capacity
	 * 
	 * @return Makes multiple trash
	 */
	// Makes trash based on max capacity
	public ArrayList<Mover> makeTrashes() {
		if (arrayOfTrash.size() < trash_maxCapacity) {
			arrayOfTrash.add(makeTrash());
			trashTime = 0;
		}
		return arrayOfTrash;
	}

	/**
	 * Makes animals based on max capacity
	 * 
	 * @return Makes multiple animals
	 */
	// Makes animals based on max capacity
	public ArrayList<Mover> makeAnimals() {
		if (arrayOfAnimal.size() < animal_maxCapacity) {
			arrayOfAnimal.add(makeAnimal());
			animalTime = 0;
		}
		return arrayOfAnimal;

	}

	/**
	 * update the time of game
	 */

	public void timeUpdate() {
		time -= 80;
		feverTime += 80;
		trashTime += 80;
		animalTime += 80;
		if (bar_left2 <= 376) {
			bar_left2 = bar_change2 * feverTime / 1000;
		}
	}

	/**
	 * When the time runs to 0, change the status to END Panel;
	 */
	public void switchToEnd() {
		if (total_trash <= 0) {
			setStatus(GameStatus.SUCCESS);
		} else if (total_trash > 0 && time <= 0) {
			setStatus(GameStatus.END);
		}
	}

	/**
	 * Updates GameStatus
	 */
	public void statusUpdate() {
		switchToEnd();
	}

	/**
	 * update the data of game
	 */
	public void update() {
		if (getStatus() == GameStatus.GAME) {
			items_caught(arrayOfAnimal);
			items_caught(arrayOfTrash);
			if (trashTime > 1500) {
				makeTrashes();
			}
			if (animalTime > 1500) {
				makeAnimals();
			}
			if (feverTime >= 10000) {
				robot.setFever(true);
				robot.setTouch_animal(false);
				robot.setSpeed(2 * robot.speed_initial);
			} else {
				robot.setFever(false);
				robot.setSpeed(robot.speed_initial);
			}
			if (time >= 0) {
				timeUpdate();
			}
		}
		if(getStatus() == GameStatus.HELP) {
			if (feverTime > 10000) {
				robot.setFever(true);
				robot.setSpeed(2 * robot.speed_initial);
			} else {
				robot.setFever(false);
				robot.setSpeed(robot.speed_initial);
			}
			if (time >= 0) {
				timeUpdate();
			}
		}
		statusUpdate();
	}

	/**
	 * reset the game
	 */
	public void reset() {
		this.time = 90000;
		this.total_trash = 25;
		this.bar_left=376;
		this.bar_left2=0;
		this.feverTime=0;
		Model.status = GameStatus.GAME;
		this.robot = Robot.createRobot();
		arrayOfTrash.clear();
		arrayOfTrash = makeTrashes();
		arrayOfAnimal.clear();
		arrayOfAnimal = makeAnimals();
	}

	// This method is to set a valid range for mouse clicking.
	// And it is used in MouseListener in Controller class.
	/**
	 * the click listener
	 * 
	 * @param x
	 *            position of click
	 * @param y
	 *            position of click
	 */
	public void clicked(int x, int y) {
		if (getStatus() == GameStatus.GAME) {
			boolean pauseButton = (x <= 500 && x >= 450) && (y <= 105 && y >= 55);
			if (pauseButton) {
				if(click_pause==false) { 
					click_pause=true;
				}else {
					click_pause=false;
				}
			}
			if (getTime() == 0) {
				setStatus(GameStatus.END);
			}
		} 
		if (getStatus() == GameStatus.MENU) {
			boolean startButton = (x <= 850 && x >= 600) && (y <= 565 && y >= 440);
			boolean quitButton = (x <= 850 && x >= 600) && (y <= 795 && y >= 670);
			
			if (startButton) {
				setStatus(GameStatus.INTRO);
			}
			if (quitButton) {
				System.exit(0);
			}
		} 

		if (getStatus() == GameStatus.HELP) {
			boolean ofCourseButton = x < 1300 && x > 1150 && y < 800 && y > 600;
			if(time==0) {
				setStatus(GameStatus.GAME);
				reset();
			}
			if (ofCourseButton) {
				setStatus(GameStatus.GAME);
				reset();
			}
		} 
		if (getStatus() == GameStatus.END || getStatus() == GameStatus.SUCCESS) {
			boolean restartButton = (x <= 850 && x >= 600) && (y <= 565 && y >= 440);
			boolean exitButton = (x <= 850 && x >= 600) && (y <= 765 && y >= 637);

			if (restartButton) {
				setStatus(GameStatus.GAME);
				reset();
			}

			if (exitButton) {
				System.exit(0);
			}
		}

	}

}
