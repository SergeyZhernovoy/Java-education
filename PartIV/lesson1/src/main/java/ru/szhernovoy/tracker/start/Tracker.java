/**
* This class storage all item (task)
* @author Sergey Zhernovoy
*@since 01-07-2016
*
*/

package ru.szhernovoy.tracker.start;
import ru.szhernovoy.tracker.models.Task;

import java.util.Random;

public class Tracker {

	/**main array tasks */
	private Task[] items = new Task[6];
	/** current position array tasks*/
	private int position = 0;
	/** value contains random generator numbers*/
	private static final Random RN = new Random();

	/**
	 * Refactor. Method add object class Task in array
	 * @param item
	 * @return
     */
	public Task addItem(Task item){

		if(this.position == this.items.length-1) {
		   this.position = 0;
		}
		this.items[position++] = item;
		return item;
	}

	/**
	 * Method get object class Task from array by id
	 * @param id id for search
	 * @return
     */
	public Task findById(String id){
		Task result =null;
		for(Task item : this.items){
				if(item != null && item.getId().equals(id)){
					result = item;
					break;
				}
		}
		return result;		
	}

	/**
	 * Method generate unique id task
	 * @return
     */
	String generateId(){
		return String.valueOf(System.currentTimeMillis() + RN.nextInt());
	}

	/**
	 * Method get all exist task
	 * @return
     */
	public Task[] getAll(){
		
		Task[] result = new Task[this.position];// позиция всегда указывает на пустой или возможно пустой элемент
		for(int index = 0; index<this.position; index++){
			result[index] = this.items[index];
		}
		return result;
	}

	/**
	 * Method get array item Task filte by name and description
	 * @param name Name task
	 * @return
	 */
	public Task[] findByFilter(String name){
		int length = this.items.length;
		Task[] copy = new Task[length];
		int filterIndex = 0;
		for(int fullIndex = 0;fullIndex < length;fullIndex++){
				if(this.items[fullIndex] != null && this.items[fullIndex].getName().contains(name)){
					copy[filterIndex++] = this.items[fullIndex];
				}
		}
		
		Task[] result = new Task[filterIndex];
		System.arraycopy(copy,0,result,0,filterIndex);
		
		return result;		
	}

	/**
	 * Method get array item Task filte by name and description
	 * @param name Name task
	 * @param decr desciption Task
     * @return
     */
	public Task[] findByFilter(String name, String decr){
	
		int length = this.items.length;
		Task[] copy = new Task[length];
		int filterIndex = 0;
		for(int fullIndex = 0;fullIndex < length;fullIndex++){
				if(this.items[fullIndex] != null && this.items[fullIndex].getName().contains(name)&&this.items[fullIndex].getDescr().contains(decr)){
					copy[filterIndex++] = this.items[fullIndex];
				}
		}
		Task[] result = new Task[filterIndex];
		System.arraycopy(copy,0,result,0,filterIndex);
		return result;		
	}

	/**
	 * Refactor. Method delete item by ID
	 * @param id   String id get from object Class Task
     */
	public void deleteItem(String id){
		if(id != null){
			for(int index = 0; index < this.items.length; index++){
				if(this.items[index] != null && this.items[index].getId().equals(id)){
				   this.items[index] = null;
				}
				if(this.items[index] == null && (index+1) != this.items.length){
				   this.items[index] = this.items[index+1];
				   this.items[index+1] = null;
				   if(this.items[index] != null){
					  this.position = (index+1)<this.items.length?(index+1):index;  
				   }
				}
			}
		}
	}

	/**
	 * Method update object in array by id
	 * @param item Object class Task
     */
	public void updateItem(Task item){
		String id = item.getId();
		if(id != null){
			for(int index = 0; index < this.items.length; index++){
				if(this.items[index] != null && this.items[index].getId().equals(id)){
				   this.items[index] = item;
				   break;
				}
			}
		}
	}

	/**
	 * Refactor. Method add commentary in task.
	 * @param item Object class task
	 * @param comm commentary
     */
	public void addCommentary(Task item, String comm){
		
		//Task inner_item = findById(item.getId());
		if(item != null){
			item.setComment(comm);
		}
	}

	/**
	 * Refactor. Method get current commentary from task.
	 * @param task Class Task
	 * @return
     */
	public String getCommentary(Task task){
	
		String result =null;

		if(task != null){
			result = task.getComm();
		}
		return result;
	}

	/**
	 * Refactor. Method get commentaries from any position.
	 * @param task
	 * @param pos
     * @return
     */
	public String getCommentary(Task task ,int pos){
		
		String result = null;

		if(task != null){
			result = task.getComm(pos);
		}
		return result;
	}
	
}