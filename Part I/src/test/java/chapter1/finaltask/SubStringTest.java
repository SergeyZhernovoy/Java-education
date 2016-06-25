/**
*@author Sergey Zhernovoy
*@since 25.06.2016
*/

package chapter1.finaltask;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;



public class SubStringTest {

	@Test
	public void setWrongSubstringShouldFalseSearch(){

		SubString testContains = new SubString();
		String origin = "fdfdfg";
		String sub    = "fdg";

		boolean result = testContains.contains(origin,sub); 
		boolean testResult = false;		
		Assert.assertThat(result,is(testResult));
	}

	@Test
	public void setRigthSubstringShouldTrueSearch(){

		SubString testContains = new SubString();
		String origin = "asasdfgh";
		String sub    = "dfg";

		boolean result = testContains.contains(origin,sub); 
		boolean testResult = true;		
		Assert.assertThat(result,is(testResult));
	}


}
