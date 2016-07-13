/**
*@author Sergey Zhernovoy
*@since 09/07/2016
*/

package ru.szhernovoy.start;
import ru.szhernovoy.models.*;

class EditTask implements UserAction{
	
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
	
	public String info(){
		return String.format("%s.) %s", this.key(),"Edit the task.");
	}
	
}