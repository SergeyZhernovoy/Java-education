/**
* Edit task in tracker
*@author Sergey Zhernovoy
*@since 12/07/2016
*/

package ru.szhernovoy.tracker.start;
import  ru.szhernovoy.tracker.models.*;
import  ru.szhernovoy.tracker.templates.*;

class EditTask extends BaseAction{
	/**value contains name task for new task */
	private String name;
	/**value contains description task for new task */
	private String descr;
	/**value contains id for new task */
	private String id;
	/**value contains new task for update by id */
	private Task task;
	/** input method */
	private final Input input;

	/**
	 * main constructor
	 * @param action information about method
     */
	public EditTask(final String action, final Input input){
		super(action);
		this.input = input;
	}

	/**
	 * Method return item number menu.
	 * @return
	 */
	public int key(){
		return 2;
	}


	/**
	 * Refactor. Method execute base action class
	 * @param tracker
	 */
	public void execute(Tracker tracker){
		if(name != null && !name.equals("")){
		   tracker.updateItem(getTask());
		}
	}

	/**
	 * Refactor. Get new task from enter parameters
     */
	private Task getTask(){
		this.task = new Task(this.name, this.descr);
		this.task.setId(this.id);
		return this.task;
	}

	/**
	 * Refactor. Method set parametrs from input.
     */
	public void inputAction(){

		this.input.setQuestion("Please enter the task name: ");
		this.input.printQuestion();
		this.name = input.ask();

		this.input.setQuestion("Please enter decription task: ");
		this.input.printQuestion();
		this.descr = input.ask();

		this.input.setQuestion("Please enter  a task's id: ");
		this.input.printQuestion();
		this.id = input.ask();
	}

}