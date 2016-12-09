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

public class TestRook {
	
	@Test
	public void WhenRookDoStepItCanMovInNewBox(){
		
		Rook rook = new Rook(Color.Black);
		Point a = new Point(0,0);
		Point b = new Point(0,1);
		
		boolean message = true;
		boolean result  = rook.cheсkMove(a,b);
		Assert.assertThat(result,is(message));
	}
} 