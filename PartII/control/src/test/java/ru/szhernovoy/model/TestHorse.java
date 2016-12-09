/**
*@author Sergey Zhernovoy
*@since 13/07/2016
* this class figure of chess
* Movement along the diagonal, max path - figure or end chess board
*/
package ru.szhernovoy.model;
import ru.szhernovoy.templates.*;


import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;

public class TestHorse {
	
	@Test
	public void WhenHorseDoStepItCanJumpInNewBox(){
		
		Horse horse = new Horse(Color.Black);
		Point a = new Point(0,0);
		Point b = new Point(2,1);
		boolean message = true;
		boolean result  = horse.cheсkMove(a,b);
		Assert.assertThat(result,is(message));
		
	}
		
} 