/**
*@author Sergey Zhernovoy
*@since 22.06.2016
*/

package chapter1.massive;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;



public class DuplicateTest {

	@Test
	public void whenGiveMassiveShouldSortingIt(){

		String []massive = {"as","sa","as","as","as"};
		Duplicate bs =  new Duplicate(massive);
		bs.DoUniqueArray();
		String []control = {"as","sa"};
		Assert.assertThat(bs.strFull,is(control));

	}

}
