package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import View.*;
import Controller.*;
import Model.*;

import org.junit.Rule;
import org.junit.Test;

public class ModelTest {
	Model model = new Model();

	@Test
	public void getterTest() {
		assertEquals(model.isClick_pause(),false);
		assertEquals(model.getTotal_trash(),25);
		assertEquals(model.getBar_left2(),0);
		assertEquals(model.getBar_left(),376);
		assertEquals(model.getTrashTime(),0);
		assertEquals(model.getFeverTime(),0);
	}
	@Test
	public void getStatusTest() {
		GameStatus status = model.getStatus();
		assertEquals("status is MENU",status, GameStatus.MENU);
	}
	
	@Test
	public void getTimeTest(){
		int time = model.getTime();
		assertEquals("time is 90000",time , 90000);
	}
	
	@Test
	public void setTimeTest(){
		model.setTime(20000);
		assertEquals("time is 20000", 20000, model.getTime());
	}
	
	@Test
	public void setStatusTest(){
		model.setStatus(GameStatus.GAME);
		assertEquals("status should be GAME", GameStatus.GAME, model.getStatus());
	}
	
	@Test
	public void updateTest(){
		model.setStatus(GameStatus.GAME);
		model.setTrashTime(1600);
		model.setAnimalTime(1600);
		model.setFeverTime(12000);
		model.update();
		model.setFeverTime(9000);
		model.update();
		model.setStatus(GameStatus.HELP);
		model.setFeverTime(12000);
		model.update();
		model.setFeverTime(9000);
		model.update();
		model.setTime(-1);
		model.update();
	}
	
	@Test
	public void items_caughtTest1(){
		model.getRobot().setXloc(model.getArrayOfAnimal().get(0).getXloc());
		model.getRobot().setYloc(model.getArrayOfAnimal().get(0).getYloc());
		model.items_caught(model.getArrayOfAnimal());
		System.out.println(model.getArrayOfAnimal().get(0).getXloc());
		System.out.println(model.getRobot().getXloc());
		ArrayList<Mover> testlist= new ArrayList<Mover>();
		model.getRobot().setXloc(500);
		model.getRobot().setYloc(500);
		testlist.add(new Fish(502,502));
		testlist.add(new Crab(502,502));
		testlist.add(new Turtle(502,502));
		testlist.add(new Battery(502,502));
		testlist.add(new Plastic_Bags(502,502));
		testlist.add(new Boots(502,502));
		testlist.add(new Normal_Trash(502,502));
		model.setStatus(GameStatus.GAME);
		model.items_caught(testlist);
	}
	@Test
	public void items_caughtTest2(){
		System.out.println(model.getArrayOfAnimal().size());
		model.getRobot().setXloc(model.getArrayOfAnimal().get(0).getXloc());
		model.getRobot().setYloc(model.getArrayOfAnimal().get(0).getYloc());
		model.items_caught(model.getArrayOfAnimal());
		assertEquals("robot's location should be same as first object in arrayOfAnimal", model.getRobot().getXloc(), model.getArrayOfAnimal().get(0).getXloc());
		System.out.println(model.getArrayOfAnimal().get(0).getXloc());
		System.out.println(model.getRobot().getXloc());
		ArrayList<Mover> testlist= new ArrayList<Mover>();
		model.getRobot().setXloc(500);
		model.getRobot().setYloc(500);
		testlist.add(new Fish(502,502));
		testlist.add(new Crab(502,502));
		testlist.add(new Turtle(502,502));
		testlist.add(new Battery(502,502));
		testlist.add(new Plastic_Bags(502,502));
		testlist.add(new Boots(502,502));
		testlist.add(new Normal_Trash(502,502));
		model.setStatus(GameStatus.HELP);
		model.items_caught(testlist);
	}


	
	@Test
	public void makeTrashTest(){
		Mover trash = model.makeTrash();
		assertTrue(trash instanceof Mover);
	}
	
	@Test
	public void makeAnimalTest(){
		Mover animal = model.makeAnimal();
		assertTrue(animal instanceof Mover);
	}
	
	@Test
	public void makeTrashesTest(){
		model.makeTrashes();
		assertEquals("this size should be 2", 2, model.getArrayOfTrash().size());
	}
	
	@Test
	public void makeAnimalsTest(){
		model.makeAnimals();
		assertEquals("this size should be 2", 1, model.getArrayOfTrash().size());
	}
	@Test
	public void TutotialTest() {
		Model model=new Model();
		model.setStatus(GameStatus.HELP);
		ArrayList<Mover>m=new ArrayList<Mover>();
		for (int i=0;i<8;i++) {
			model.setTutorial_items(m);
			model.tutorial();
			model.getTutorial_items().clear();
		}
		
	}
	@Test
	public void timeUpdateTest(){
		System.out.println(model.getTime());
		model.timeUpdate();

		
	}
	
	@Test
	public void switchToEndTest(){
		model.setTotal_trash(0);
		model.switchToEnd();
		assertEquals("game status should be SUCCESS", GameStatus.SUCCESS, model.getStatus());
		model.setTotal_trash(-1);
		model.switchToEnd();
		model.setTotal_trash(3);
		model.switchToEnd();
	}
	
	@Test
	public void statusUpdateTest(){
		model.setTotal_trash(0);
		model.switchToEnd();
		assertEquals("game status should be SUCCESS", GameStatus.SUCCESS, model.getStatus());
	}
	
	@Test
	public void resetTest(){
		model.setTime(0);
		model.reset();
		assertEquals("tims should be 90000", 90000, model.getTime());
	}
	
	@Test
	public void clickedTest1(){
		Model model=new Model();
		model.setStatus(GameStatus.MENU);
		int x=601;
		int y=401;
		model.clicked(x, y);
		model.setTime(0);
		model.update();
		}
	
	@Test
	public void clickedTest2(){
		Model model=new Model();
		model.setStatus(GameStatus.HELP);
		int x=1200;
		int y=700;
		model.clicked(x, y);
		model.setStatus(GameStatus.HELP);
		x=0;
		y=0;
		model.setTime(0);
		model.clicked(x, y);
		}
	
	@Test
	public void clickedTest3(){
		Model model=new Model();
		model.setStatus(GameStatus.MENU);
		int x=600;
		int y=600;
		model.clicked(x, y);
		model.setStatus(GameStatus.GAME);
		x=460;
		y=100;
		model.clicked(x, y);
		}
	@Test
	public void clickedTest4(){
		Model model=new Model();
		model.setStatus(GameStatus.SUCCESS);
		int x=640;
		int y=500;
		model.clicked(x, y);
		model.setStatus(GameStatus.END);
		x=640;
		y=500;
		model.clicked(x, y);
		}
	@Test
	public void clickedTest5(){
		Model model=new Model();
		model.setStatus(GameStatus.END);
		int x=700;
		int y=700;
		model.setStatus(GameStatus.SUCCESS);
		x=700;
		y=700;
		model.setStatus(GameStatus.GAME);
		model.setTime(0);
		model.clicked(0, 0);
		model.setStatus(GameStatus.MENU);
		x=700;
		y=500;
		model.clicked(x, y);
		}
	
	
}
