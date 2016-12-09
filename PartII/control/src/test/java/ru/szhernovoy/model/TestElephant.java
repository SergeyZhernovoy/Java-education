/**
*@author Sergey Zhernovoy
*@since 13/07/2016
* this class figure of chess
*Movement G 
*/
package ru.szhernovoy.model;
import ru.szhernovoy.templates.*;


import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;

public class TestElephant {
	
	@Test
	public void WhenElephantDoStepItCanMovInNewBox(){
		
		Elephant eleph = new Elephant(Color.Black);
		Point a = new Point(0,0);
		Point b = new Point(1,1);
		boolean message = true;
		boolean result  = eleph.cheсkMove(a,b);
		Assert.assertThat(result,is(message));
	
	}
	
	
} 