/**
*@author Sergey Zhernovoy
*@since 20.06.2016
*/

package chapter1.massive;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;



public class BubbleTest {

	@Test
	public void whenGiveMassiveShouldSortingIt(){

		int []massive = {1,2,3,4,6,5};
		BubbleSort bs =  new BubbleSort(massive);
		bs.sortMassive();
		int []result = bs.getMassive();
		int []control = {1,2,3,4,5,6};
		Assert.assertThat(result,is(control));

	}

}
