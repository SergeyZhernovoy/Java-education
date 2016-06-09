/**
*@author Sergey Zhernovoy
*@since 09.06.2016
*/

package chapter1.jvm;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;



public class CalculatorTest {

	@Test
	public void whenAnyActionDoTypeResult(){

		Calculator calc = new Calculator("Hello world");
		String message = "Hello world";
		String result = calc.sayResult();		
		Assert.assertThat(result,message);

	}

}
