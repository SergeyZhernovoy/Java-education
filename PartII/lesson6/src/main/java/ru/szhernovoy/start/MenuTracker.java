/**
*@author Sergey Zhernovoy
*@since 09/07/2016
*/

package ru.szhernovoy.start;
import ru.szhernovoy.model.*;
import ru.szhernovoy.templates.*;


class MenuTracker {
	
	private Tracker tracker;
	private Input input;	
	UserAction[] actions = new UserAction[7]; 
	
	public MenuTracker(Input input, Tracker tracker){
		this.tracker = tracker;
		this.input = input;
	}
	
	public int[] getRangeKeys(){
		int[] range = new int[actions.length];
		int position = 0;
		for(UserAction action : actions){
			range[position++] = action.key();
		}
		
		return range;
	}
	
	public void fillActions(){
		this.actions[0] = this.new AddTask("Add the new task.");
		this.actions[1] = new MenuTracker.ShowTask("Show all task.");
		this.actions[2] = new EditTask("Edit the task.");
		this.actions[3] = this.new DeleteTask("Delete the task.");
		this.actions[4] = this.new PrintByFilter("Print a task by filter.");
		this.actions[5] = this.new AddComment("Add the new commentary.");
		this.actions[6] = this.new PrintCommentary("Print the commentary of task.");
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
	
	private class AddTask extends BaseAction {
		
		public AddTask(String action){
			super(action);
		}
				
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
	}
	
	private static class ShowTask extends BaseAction {
		
		public ShowTask(String action){
			super(action);
		}
				
		public int key(){
			return 1;
		}
		
		public void execute(Input input, Tracker tracker){
			for(Task task : tracker.getAll()){
				System.out.println(String.format("id %s. %s", task.getId(), task.getName()));
			}
		}
		
	}
		
	private class DeleteTask extends BaseAction {
		
		public DeleteTask(String action){
			super(action);
		}
		
		public int key(){
			return 3;
		}
		
		public void execute(Input input, Tracker tracker){
				
			String id = input.ask("Please enter id task for delete: ");
			if(id != null && !id.equals("")){
				tracker.deleteItem(tracker.findById(id));
			}
		}
	}
	
	private class PrintByFilter extends BaseAction {
		
		public PrintByFilter(String action){
			super(action);
		}
		
		public int key(){
			return 4;
		}
		
		public void execute(Input input, Tracker tracker){
				
			String filter = input.ask("Please enter name a task for print: ");
			for(Task task : tracker.findByFilter(filter)){
				System.out.println(String.format("id %s. %s", task.getId(), task.getName()));
			}
		}
	}
	
	private class AddComment extends BaseAction {
		
		public AddComment(String action){
			super(action);
		}
				
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
	}
	
	private class PrintCommentary extends BaseAction {
		
		public PrintCommentary(String action){
			super(action);
		}
				
		public int key(){
			return 6;
		}
		
		public void execute(Input input, Tracker tracker){
			String id = input.ask("Please enter id task for print comment: ");
			if(id != null && !id.equals("")){
			   System.out.println(String.format("task %s. comment %s",tracker.findById(id).getId(), tracker.getCommentary(tracker.findById(id))));
			}
		}
	}
	
}