/**
*@author Sergey Zhernovoy
*@since 14/07/2016
* 
*/
package ru.szhernovoy.start;
import ru.szhernovoy.templates.*;
import ru.szhernovoy.models.*;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;

public class TestGameMenu{

	
	@Test
	public void WhenMoveFigureItDoStep(){
	
		ChessBoard board = new ChessBoard();
		String[] answer  = new String[]{"n","y"};
		String[] abc  = new String[]{"a","a"};
		String[] num  = new String[]{"2","3"};
		StubInput input = new StubInput(answer,abc,num);
		new ChessGame(input).init(board);
		Point A = new Point(2,0);
		ChessBox box = board.getBox(A);
		String message  = box.getFigure().nameFigure();
		String result = "P";
		Assert.assertThat(result,is(message));
		//Assert.assertNotNull(box);
	}
	
}
