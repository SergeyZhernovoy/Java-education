/**
* строим треугольник 
* вычисляем его площадь по методу трёх сторон
*@author Sergey Zhernovoy
*@version 1.0.0
*@since 14-06-2016
*/
package chapter1.condition;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;

public class TriangleTest {
   
   	@Test
	public void whenIsTriangleIsItArea(){
		Point a = new Point(1,1);
		Point b = new Point(1,1);
		Point c = new Point(5,11);
		Triangle triangle = new Triangle(a,b,c);
		double result = triangle.area();
		double testresult = 0;
		Assert.assertThat(result,is(testresult));
	}

}
