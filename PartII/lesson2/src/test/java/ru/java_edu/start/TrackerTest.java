package ru.java_edu.start; /**
*@author Sergey Zhernovoy
*@since 09.06.2016
*/


import ru.java_edu.models.*;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;


public class TrackerTest {

	@Test
	public void whenAddItemThatAddInMassive(){

		Tracker track = new Tracker();
		Task task1 = new Task("pervaja zajavka","eto pervaja zajavka");
		Assert.assertNotNull(track.addItem(task1));

	}

	@Test
	public void whenUpdateItemThatItemChangeInMassive(){

		Tracker track = new Tracker();
		Task task1 = new Task("pervaja zajavka","eto pervaja zajavka");
		Task task2 = new Task("vtoraja zajavka","eto vtoraja zajavka");
		
		track.addItem(task1);
		task2.setId(task1.getId());
		track.updateItem(task2);
		Task item = track.findById(task1.getId());
		Assert.assertEquals(task2.getName(),item.getName());
	}
	
	@Test
	public void deleteItemThatItemMassiveIsNull(){

		Tracker track = new Tracker();
		Task task1 = new Task("pervaja zajavka","eto pervaja zajavka");
		track.addItem(task1);
		
		Assert.assertNotNull(track.findById(task1.getId()));
		
		track.deleteItem(task1);
		Assert.assertNull(track.findById(task1.getId()));
	}
	
	@Test
	public void addItemCommy(){

		Tracker track = new Tracker();
		Task task1 = new Task("pervaja zajavka","eto pervaja zajavka");
		track.addItem(task1);
		track.addCommentary(task1,"eto message");
		String message = "eto message";
		String result  = track.getCommentary(task1);
		Assert.assertThat(result,is(message));
	}
}
