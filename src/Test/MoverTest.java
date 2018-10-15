package Test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import Model.Mover;

public class MoverTest {

	@Test
	public void testMover() {
		Mover m = new Mover("tester", 1, 2, 3, 4, 5, 6);
		assertEquals(m.getName(), "tester");
		assertEquals(m.getXloc(),1);
		assertEquals(m.getYloc(), 2);
		assertEquals(m.getxInc(), 3);
		assertEquals(m.getyInc(), 4);
		assertEquals(m.getWidth(), 5);
		assertEquals(m.getHeight(), 6);
	}
	
	@Test
	public void testMover2() {
		Mover m = new Mover("tester", 1, 2, 3, 4, 5, 6);
		m.setName("z");
		m.setXloc(4);
		m.setYloc(5);
		m.setxInc(5);
		m.setyInc(0);
		m.setWidth(19);
		m.setHeight(48);
	}
	@Test
	public void testMover3() {
		Mover m = new Mover("tester", 1300, 1300,10 , 10,3, 3);	
		m.updateXDirection();
		m.updateYDirection();
		Mover m2 = new Mover("tester", 0, 100,10 , 10,3, 3);	
		m2.updateXDirection();
		m2.updateYDirection();
		Mover m3 = new Mover("tester", 400, 500,10 , 10,3, 3);	
		m2.updateXDirection();
		m2.updateYDirection();
		m.move();
		m2.move();
		m3.move();
	}
}
