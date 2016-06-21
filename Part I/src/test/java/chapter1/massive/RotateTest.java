/**
*@author Sergey Zhernovoy
*@since 20.06.2016
*/

package chapter1.massive;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;



public class RotateTest {

	@Test
	public void setMassiveShouldRotateIt(){

		int [][]massive = {
		{1,2},
		{3,4}};
		Rotate rt =  new Rotate(massive);
		rt.rotateArray();
		int [][]result = rt.getMassive();
		int [][]control = {
		{2,4},
		{1,3}};
		Assert.assertThat(result,is(control));

	}

}
