/**
*@author Sergey Zhernovoy
*@since 13/07/2016
* this class figure of chess
* Movement straight max path 1 point
*/
package ru.szhernovoy.models;
import ru.szhernovoy.templates.*;


import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;

public class TestPawn {
	
	@Test
	public void WhenPawnDoStepItCanMovInNewBox(){
		
		Pawn pawn = new Pawn(Color.Black);
		Point a = new Point(0,0);
		Point b = new Point(1,0);
		boolean message = true;
		boolean result  = pawn.cheсkMove(a,b);
		Assert.assertThat(result,is(message));
	
	}
	
	
} 