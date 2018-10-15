package Test;
import Controller.*;
import View.*;
import Model.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class RobotTest {
	@Test
	public void constructorTest() {
	Robot robot = new Robot(500,500);
	Robot robot2 = Robot.createRobot();
	assertEquals(robot.isTouch_animal(),false);
	assertEquals(robot.isTouch_trash(),false);
	}
	@Test
	public void moveTest1() {
		Robot robot = new Robot(0,500);
		robot.setDirection(Direction.WEST);
		robot.move(Direction.WEST);
		robot.move(Direction.EAST);
		robot.move(Direction.NORTH);
		robot.move(Direction.SOUTH);
		robot.move(Direction.WEST);
	}
	@Test
	public void moveTest2() {
		Robot robot = new Robot(1300,500);
		robot.setDirection(Direction.EAST);
		robot.move(Direction.EAST);
		robot.move(Direction.WEST);
		robot.move(Direction.NORTHWEST);
		robot.move(Direction.NORTHEAST);
		robot.move(Direction.SOUTHEAST);
		robot.move(Direction.SOUTHWEST);
	}
	
	@Test
	public void moveTest3() {
		Robot robot = new Robot(500,170);
		robot.setDirection(Direction.NORTH);
		robot.move(Direction.NORTH);
		robot.move(Direction.SOUTH);
		robot.move(Direction.SOUTHWEST);
	}
	@Test
	public void moveTest4() {
		Robot robot = new Robot(500,800);
		robot.setDirection(Direction.SOUTH);
		robot.move(Direction.SOUTH);
		robot.move(Direction.NORTHWEST);
	}
	
	@Test 
	public void tutorialTest1() {
		Robot robot = new Robot(0,200);
		robot.setDirection(Direction.WEST);
		robot.tutorialMove(Direction.WEST);
		robot.tutorialMove(Direction.EAST);
		robot.tutorialMove(Direction.NORTH);
		robot.tutorialMove(Direction.SOUTH);
		robot.tutorialMove(Direction.WEST);
	}
	@Test 
	public void tutorialTest2() {
		Robot robot = new Robot(1300,200);
		robot.setDirection(Direction.EAST);
		robot.tutorialMove(Direction.EAST);
		robot.tutorialMove(Direction.WEST);
		robot.tutorialMove(Direction.NORTHWEST);
		robot.tutorialMove(Direction.NORTHEAST);
		robot.tutorialMove(Direction.SOUTHEAST);
		robot.tutorialMove(Direction.SOUTHWEST);
	}
	@Test 
	public void tutorialTest3() {
		Robot robot = new Robot(500,150);
		robot.setDirection(Direction.NORTH);
		robot.tutorialMove(Direction.NORTH);
		robot.tutorialMove(Direction.SOUTH);
		robot.tutorialMove(Direction.SOUTHWEST);
	}
	
	@Test
	public void tutorialTest4() {
		Robot robot = new Robot(500,800);
		robot.setDirection(Direction.SOUTH);
		robot.tutorialMove(Direction.SOUTH);
		robot.tutorialMove(Direction.NORTHWEST);
	}
	@Test
	public void isMovingTest(){
		Robot robot = new Robot(500,500);
		robot.setMoving(false);
		boolean moving = robot.isMoving();
		assertFalse(moving);
	}
	
	@Test
	public void getspeedTest(){
		Robot robot = new Robot(500,500);
		robot.setSpeed(30);
		assertEquals(robot.getSpeed(),30);
	}
	
	@Test
	public void GTest(){
		Robot robot = new Robot(500,500);
		robot.setDirection(Direction.EAST);
		assertEquals(robot.getDirection(),Direction.EAST);
		robot.setXloc(500);
		robot.setYloc(500);
		assertEquals(robot.getHeight(),110);
		assertEquals(robot.getWidth(),50);
		assertEquals(robot.getXloc(),500);
		assertEquals(robot.getYloc(),500);
		robot.setFever(false);
		assertFalse(robot.isFever());
	}

}
