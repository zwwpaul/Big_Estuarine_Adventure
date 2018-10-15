package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.GameStatus;

public class GameStatusTest {

	@Test
	public void test() {
		GameStatus menu=GameStatus.MENU;
		GameStatus end=GameStatus.END;
		GameStatus game=GameStatus.GAME;
		GameStatus success=GameStatus.SUCCESS;
		GameStatus END=GameStatus.END;
	}

}
