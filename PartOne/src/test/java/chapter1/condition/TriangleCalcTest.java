/**
*  
* тестируем вычисления максимальной стороны треугольника
*@author Sergey Zhernovoy
*@version 1.0.0
*@since 14-06-2016
*/
package chapter1.condition;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class TriangleCalcTest {
   
   	@Test
	public void whenIsTriangleItHaveMaxSide(){
		Point a = new Point(1,1);
		Point b = new Point(1,1);
		Point c = new Point(5,11);
		TriangleCalc triangle = new TriangleCalc(a,b,c);
		double result = new BigDecimal(triangle.maxSide()).setScale(2, RoundingMode.UP).doubleValue();;
		double testresult = 10.78;
		Assert.assertThat(result,is(testresult));
	}


}
