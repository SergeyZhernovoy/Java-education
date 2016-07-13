/**
*@author Sergey Zhernovoy
*@since 16.06.2016
*/

package chapter1.loop;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;



public class FactorialTest {

	@Test
	public void whenlittleNumFactorial(){

		Factorial fc =  new Factorial("5");;
		double result = fc.calcFactorial();
		double control = 120;
		Assert.assertThat(result,is(control));

	}

}
