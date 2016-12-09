/**
*@author Sergey Zhernovoy
*@since 09/07/2016
*/

package ru.szhernovoy.start;
import ru.szhernovoy.model.*;


class MenuTracker {
	
	private Tracker tracker;
	private Input input;	
	UserAction[] actions = new UserAction[7]; 
	
	public MenuTracker(Input input, Tracker tracker){
		this.tracker = tracker;
		this.input = input;
	}
	
	public void fillActions(){
		this.actions[0] = this.new AddTask();
		this.actions[1] = new MenuTracker.ShowTask();
		this.actions[2] = new EditTask();
		this.actions[3] = this.new DeleteTask();
		this.actions[4] = this.new PrintByFilter();
		this.actions[5] = this.new AddComment();
		this.actions[6] = this.new PrintCommentary();
	}
	
	public void select(int key){
		this.actions[key].execute(input,tracker);
	}
	
	public void show(){
		for(UserAction action : this.actions){
			if(action != null){
			System.out.println(action.info());
			}
		}
	}
	
	private class AddTask implements UserAction {
		
		public int key(){
			return 0;
		}
		
		public void execute(Input input, Tracker tracker){
			String name = input.ask("Please enter the task name: ");
			String descr = input.ask("Please enter decription task: ");
			if(name != null && !name.equals("")){
			   tracker.addItem(new Task(name,descr));
			}
		}
		
		public String info(){
			return String.format("%s.) %s", this.key(),"Add the new task.");
		}
		
	}
	
	private static class ShowTask implements UserAction {
		
		public int key(){
			return 1;
		}
		
		public void execute(Input input, Tracker tracker){
			for(Task task : tracker.getAll()){
				System.out.println(String.format("id %s. %s", task.getId(), task.getName()));
			}
		}
		
		public String info(){
			return String.format("%s.) %s", this.key(),"Show all task.");
		}
		
	}
		
	private class DeleteTask implements UserAction {
		
		public int key(){
			return 3;
		}
		
		public void execute(Input input, Tracker tracker){
				
			String id = input.ask("Please enter id task for delete: ");
			if(id != null && !id.equals("")){
				tracker.deleteItem(tracker.findById(id));
			}
		}
		
		public String info(){
			return String.format("%s.) %s", this.key(),"Delete the task.");
		}
	}
	
	private class PrintByFilter implements UserAction {
		
		public int key(){
			return 4;
		}
		
		public void execute(Input input, Tracker tracker){
				
			String filter = input.ask("Please enter name a task for print: ");
			for(Task task : tracker.findByFilter(filter)){
				System.out.println(String.format("id %s. %s", task.getId(), task.getName()));
			}
		}
		
		public String info(){
			return String.format("%s.) %s", this.key(),"Print a task by filter.");
		}
	}
	
	private class AddComment implements UserAction {
		
		public int key(){
			return 5;
		}
		
		public void execute(Input input, Tracker tracker){
			String id = input.ask("Please enter id task for add comment: ");
			String comment  = input.ask("Please enter comment: ");
			if(id != null && !id.equals("")){
				tracker.addCommentary(tracker.findById(id),comment);
			}
		}
		
		public String info(){
			return String.format("%s.) %s", this.key(),"Add the new commentary.");
		}
	}
	
	private class PrintCommentary implements UserAction {
		
		public int key(){
			return 6;
		}
		
		public void execute(Input input, Tracker tracker){
			String id = input.ask("Please enter id task for print comment: ");
			if(id != null && !id.equals("")){
			   System.out.println(String.format("task %s. comment %s",tracker.findById(id).getId(), tracker.getCommentary(tracker.findById(id))));
			}
		}
		
		public String info(){
			return String.format("%s.) %s", this.key(),"Print the commentary of task.");
		}
	}
	
}