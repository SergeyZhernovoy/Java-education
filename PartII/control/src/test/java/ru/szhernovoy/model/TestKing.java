/**
*@author Sergey Zhernovoy
*@since 13/07/2016
* this class figure of chess 
* Movement max path - 1 pos
*/
package ru.szhernovoy.model;
import ru.szhernovoy.templates.*;


import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;

public class TestKing {
	
	@Test
	public void WhenKingDoStepItCanMovInNewBox(){
		
		King king = new King(Color.Black);
		Point a = new Point(0,0);
		Point b = new Point(0,1);
		Point c = new Point(1,0);
		boolean message = true;
		boolean result  = king.cheсkMove(a,b);
		Assert.assertThat(result,is(message));
		boolean result2  = king.cheсkMove(b,c);
		Assert.assertThat(result2,is(message));
	}
	
} 