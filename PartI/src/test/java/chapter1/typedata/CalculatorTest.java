/**
*@author Sergey Zhernovoy
*@since 09.06.2016
*/

package chapter1.typedata;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;



public class CalculatorTest {

	@Test
	public void whenAddTwoNumberShouldBeResultCalculation(){

		Calculator calc = new Calculator();
		calc.add(1,1);
		double result = calc.getResult(); 
		double testResult = 2;		
		Assert.assertThat(result,is(testResult));
	}

	@Test
	public void whenSubTwoNumberShouldBeResultCalculation(){

		Calculator calc = new Calculator();
 		calc.sub(3,1);
		double result = calc.getResult();
		double testResult = 2;		
		Assert.assertThat(result,is(testResult));
	}

	@Test
	public void whenMultiplexTwoNumberShouldBeResultCalculation(){

		Calculator calc = new Calculator();
		calc.mult(2,2);
		double result = calc.getResult();
		double testResult = 4;		
		Assert.assertThat(result,is(testResult));
	}
	@Test
	public void whenDivideTwoNumberShouldBeResultCalculation(){

		Calculator calc = new Calculator();
		calc.div(2,1);
		double result = calc.getResult();
		double testResult = 2;		
		Assert.assertThat(result,is(testResult));
	}


}
