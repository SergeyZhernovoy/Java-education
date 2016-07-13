/**
*@author Sergey Zhernovoy
*@since 01-07-2016
*это класс выполнения трекера 
*/

package ru.szhernovoy.start;
import ru.szhernovoy.models.*;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;

public class StartUITest{
	
	@Test
	public void whenAddItemThatAddInMassive(){

		Tracker track = new Tracker();
		String  nameTask = "pervaja zajavka";
		String[] answerForAdd  = new String[]{"0","pervaja zajavka","eto pervaja zajavka","y"};
		new StartUI(new StubInput(answerForAdd)).init(track);
			
		for(Task task : track.getAll()){
			Assert.assertEquals(task.getName(),nameTask);
		}
	}
	
	@Test
	public void whenUpdateItemThatItemChangeInMassive(){

		Tracker track = new Tracker();
		String  nameTask1 = "pervaja zajavka";
		String[] answerForAdd  = new String[]{"0","pervaja zajavka","eto pervaja zajavka","y"};
		new StartUI(new StubInput(answerForAdd)).init(track);
		
		Task[] listTask = track.findByFilter(nameTask1);
		String  nameTask2 = "vtoraja zajavka";
		String[] answerForUpdate  = new String[]{"2",nameTask2,"eto vtoraja zajavka",listTask[0].getId(),"y"};
			
		new StartUI(new StubInput(answerForUpdate)).init(track);
		Task[] listTaskUpdate = track.findByFilter(nameTask2);
		
		Assert.assertEquals(listTaskUpdate[0].getName(),nameTask2);
	}
	
	@Test
	public void deleteItemThatItemMassiveIsNull(){

		Tracker track = new Tracker();
		String  nameTask1 = "pervaja zajavka";
		String[] answerForAdd  = new String[]{"0","pervaja zajavka","eto pervaja zajavka","y"};
		new StartUI(new StubInput(answerForAdd)).init(track);
		
		Task[] listTask = track.findByFilter(nameTask1);
		String id = listTask[0].getId();
		String[] answerForDelete  = new String[]{"3",id,"y"};
			
		new StartUI(new StubInput(answerForDelete)).init(track);
		Assert.assertNull(track.findById(id));
	}
	
	@Test
	public void addItemCommy(){

		Tracker track = new Tracker();
		String  nameTask1 = "pervaja zajavka";
		String[] answerForAdd  = new String[]{"0","pervaja zajavka","eto pervaja zajavka","y"};
		new StartUI(new StubInput(answerForAdd)).init(track);
		
		Task[] listTask = track.findByFilter(nameTask1);
		String[] answerForComment  = new String[]{"5",listTask[0].getId(),"eto commentary","y"};
			
		new StartUI(new StubInput(answerForComment)).init(track);
		Assert.assertNotNull(track.getCommentary(listTask[0]));
		
		
	}
	
	@Test
	public void ItsCorrectPrintAllTask(){

		Tracker track = new Tracker();
		String  nameTask = "pervaja zajavka";
		String[] answerForAdd  = new String[]{"0","pervaja zajavka","eto pervaja zajavka","y"};
		new StartUI(new StubInput(answerForAdd)).init(track);
			
		for(Task task : track.getAll()){
			Assert.assertNotNull(task.getName());
		}
	}
		
	@Test
	public void ItsCorrectPrintTaskFindByFilter(){

		Tracker track = new Tracker();
		String  nameTask1 = "pervaja zajavka";
		String[] answerForAdd  = new String[]{"0","pervaja zajavka","eto pervaja zajavka","y"};
		new StartUI(new StubInput(answerForAdd)).init(track);
		
		for(Task task : track.findByFilter(nameTask1)){
			Assert.assertNotNull(task.getName());
		}
	}
	
}