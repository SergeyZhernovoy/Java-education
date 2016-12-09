/**
*@author Sergey Zhernovoy
*@since 13/07/2016
* this class figure of chess
*/
package ru.szhernovoy.model;
import ru.szhernovoy.templates.*;


import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;

public class TestQueen {
	
	@Test
	public void WhenQueenDoStepItCanMovInNewBox(){
		
		Queen queen = new Queen(Color.Black);
		Point a = new Point(0,0);
		Point b = new Point(0,1);
		Point c = new Point(1,0);
		boolean message = true;
		boolean result  = queen.cheсkMove(a,b);
		Assert.assertThat(result,is(message));
		boolean result2  = queen.cheсkMove(b,c);
		Assert.assertThat(result2,is(message));
	}
	
} 