/**
*@author Sergey Zhernovoy
*@since 12/07/2016
*/

package ru.szhernovoy.start;
import ru.szhernovoy.model.*;
import ru.szhernovoy.templates.*;

class EditTask extends BaseAction{
	
	public EditTask(String action){
		super(action);
	}
	
	
	public int key(){
		return 2;
	}
	
	public void execute(Input input, Tracker tracker){
			String name = input.ask("Please enter the task name: ");
			String descr = input.ask("Please enter decription task: ");
			String id = input.ask("Please enter  a task's id: ");
			
			if(name != null && !name.equals("")){
			Task task = new Task(name,descr);
			task.setId(id);
			tracker.updateItem(task);
		}
	}
}