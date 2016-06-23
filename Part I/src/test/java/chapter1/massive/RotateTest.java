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
		{1,2,3,4},
		{3,4,5,6},
		{4,4,4,1},
		{1,2,3,5}};
		Rotate rt =  new Rotate(massive);
		rt.rotateArray();
		int [][]result = rt.getMassive();
		int [][]control = {
		{4,6,1,5},
		{3,5,4,3},
		{2,4,4,2},
		{1,3,4,1}};
		Assert.assertThat(result,is(control));

	}

}
