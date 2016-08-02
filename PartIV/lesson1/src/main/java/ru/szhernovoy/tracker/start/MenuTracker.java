/**
*@author Sergey Zhernovoy
*@since 09/07/2016
*/

package ru.szhernovoy.tracker.start;
import ru.szhernovoy.tracker.models.*;
import ru.szhernovoy.tracker.templates.*;

/**
 * Menu main program
 */
class MenuTracker {

	/**object storage task */
	private Tracker tracker;
	/** object input*/
	private Input input;
	/** array actions*/
	UserAction[] actions = new UserAction[7];

	/**
	 * main constructor
	 * @param input
	 * @param tracker
     */
	public MenuTracker(Input input, Tracker tracker){
		this.tracker = tracker;
		this.input = input;
	}

	/**
	 * Get range action key.
	 * @return
     */
	public int[] getRangeKeys(){
		int[] range = new int[actions.length];
		int position = 0;
		for(UserAction action : actions){
			range[position++] = action.key();
		}
		return range;
	}

	/**
	 * Refactor. fill array all actions.
     */
	public void fillActions(){

		this.actions[0] = this.new AddTask("Add the new task.",this.input);
		this.actions[1] = new MenuTracker.ShowTask("Show all task.",this.input);
		this.actions[2] = new EditTask("Edit the task.",this.input);
		this.actions[3] = this.new DeleteTask("Delete the task.",this.input);
		this.actions[4] = this.new PrintByFilter("Print a task by filter.",this.input);
		this.actions[5] = this.new AddComment("Add the new commentary.",this.input);
		this.actions[6] = this.new PrintCommentary("Print the commentary of task.",this.input);
	}

	/**
	 * Refactor. Execute method menu.
	 * @param key
     */
	public void select(int key){
		this.actions[key].inputAction();
		this.actions[key].execute(tracker);
	}

	/**
	 * Show all information from action.
     */
	public void show(){
		for(UserAction action : this.actions){
			if(action != null){
			System.out.println(action.info());
			}
		}
	}

	/**
	 * add new task.
     */
	private class AddTask extends BaseAction {

		/**value contains name task for new task */
		private String name;
		/**value contains description task for new task */
		private String descr;
		/**value contains input  */
		private Input input;

		/**
		 * Main constructor
		 * @param action string info about action
		 */
		public AddTask(String action, Input input){
			super(action);
			this.input = input;
		}

		/**
		 * Method return item number menu.
		 * @return
		 */
		public int key(){
			return 0;
		}

		/**
		 * Refactor. Method set parametrs from input.
		 */
		@Override
		public void inputAction() {
			this.input.setQuestion("Please enter the task name: ");
			this.input.printQuestion();
			this.name = input.ask();
			this.input.setQuestion("Please enter description task: ");
			this.input.printQuestion();
			this.descr = input.ask();
		}
		/**
		 * Refactor. Method execute base action class. Add new task in array.
		 * @param tracker
		 */
		public void execute(Tracker tracker){

			if(name != null && !name.equals("")){
			   tracker.addItem(new Task(name,descr));
			}
		}
	}

	/**
	 * print all task.
     */
	private static class ShowTask extends BaseAction {

		/**
		 * Main constructor
		 * @param action string info about action
		 */
		public ShowTask(String action,Input input){
			super(action);
		}

		/**
		 * Method return item number menu.
		 * @return
		 */
		public int key(){
			return 1;
		}

		/**
		 * Refactor. Method set parametrs from input.

		 */
		@Override
		public void inputAction() {

		}
		/**
		 * Refactor. Method execute base action class. Show all task.
		 * @param tracker
		 */
		public void execute(Tracker tracker){
			for(Task task : tracker.getAll()){
				System.out.println(String.format("id %s. %s", task.getId(), task.getName()));
			}
		}
		
	}

	/**
	 * Delete task.
     */
	private class DeleteTask extends BaseAction {

		/**
		 * Main constructor
		 * @param action string info about action
		 */
		public DeleteTask(String action,Input input){
			super(action);
			this.input = input;
		}
		/**value contains id for search task */
		private String id;
		/** input method */
		private final Input input;

		/**
		 * Method return item number menu.
		 * @return
		 */
		public int key(){
			return 3;
		}

		/**
		 * Refactor. Method set parameters from input.
		 */
		@Override
		public void inputAction() {
			this.input.setQuestion("Please enter id task for delete: ");
			this.input.printQuestion();
			this.id = input.ask();
		}
		/**
		 * Refactor. Method execute base action class. Delete item in tracker.
		 * @param tracker
		 */
		public void execute(Tracker tracker){

			if(this.id != null && !this.id.equals("")){
				tracker.deleteItem(this.id);
			}
		}
	}

	/**
	 * print task by filter.
     */
	private class PrintByFilter extends BaseAction {

		/** value need for search*/
		private String filter;
		/** input method */
		private final Input input;
		/**
		 * Main constructor
		 * @param action string info about action
		 */
		public PrintByFilter(String action,Input input){
			super(action);
			this.input = input;
		}

		/**
		 * Method return item number menu.
		 * @return
		 */
		public int key(){
			return 4;
		}

		/**
		 * Refactor. Method set parameters from input.
		 */
		@Override
		public void inputAction() {
			this.input.setQuestion("Please enter name a task for print: ");
			this.input.printQuestion();
			this.filter = input.ask();
		}
		/**
		 * Refactor. Method execute base action class. Print task from tracker by filter
		 * @param tracker
		 */
		public void execute(Tracker tracker){

			for(Task task : tracker.findByFilter(filter)){
				System.out.println(String.format("id %s. %s", task.getId(), task.getName()));
			}
		}
	}

	/**
	 * add new commentary.
     */
	private class AddComment extends BaseAction {

		/**value contains id for search task */
		private String id;
		/**add commentary in task*/
		private String comment;
		/** input method */
		private final Input input;

		/**
		 * Main constructor
		 * @param action string info about action
		 */
		public AddComment(String action, Input input){
			super(action);
			this.input = input;
		}

		/**
		 * Method return item number menu.
		 * @return
		 */
		public int key(){
			return 5;
		}

		/**
		 * Refactor. Method set parameters from input.
		 */
		@Override
		public void inputAction() {
			this.input.setQuestion("Please enter id task for add comment: ");
			this.input.printQuestion();
			this.id = input.ask();

			this.input.setQuestion("Please enter comment: ");
			this.input.printQuestion();
			this.comment  = input.ask();
		}
		/**
		 * Refactor. Method execute base action class. add commentary in task
		 * @param tracker
		 */
		public void execute(Tracker tracker){

			if(this.id != null && !this.id.equals("")){
				tracker.addCommentary(tracker.findById(this.id),this.comment);
			}
		}
	}

	/**
	 * print commentary.
     */
	private class PrintCommentary extends BaseAction {

		/**value contains id for search task */
		private String id;
		/** input method */
		private final Input input;
		/**
		 * Main constructor
		 * @param action string info about action
         */
		public PrintCommentary(String action,Input input){
			super(action);
			this.input = input;
		}

		/**
		 * Method return item number menu.
		 * @return
		 */
		public int key(){
			return 6;
		}

		/**
		 * Refactor. Method set parameters from input.
		 */
		@Override
		public void inputAction() {
			this.input.setQuestion("Please enter id task for print comment: ");
			this.input.printQuestion();
			this.id = input.ask();
		}

		/**
		 * Refactor. Method execute base action class. Print commentary
		 * @param tracker
		 */
		public void execute(Tracker tracker){

			if(this.id != null && !this.id.equals("")){
			   System.out.println(String.format("task %s. comment %s",tracker.findById(this.id).getId(), tracker.getCommentary(tracker.findById(this.id))));
			}
		}
	}
	
}