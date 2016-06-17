/**
*@author Sergey Zhernovoy
*@since 16.06.2016
*/

package chapter1.loop;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;



public class SquareTest {

	@Test
	public void calcFuncOneValue(){

		Square sq = new Square(1,2,3,1,10,1);
		double control = 11; //3;
		double result = sq.calcFunction(2);		
		Assert.assertThat(result,is(control));

	}

}
