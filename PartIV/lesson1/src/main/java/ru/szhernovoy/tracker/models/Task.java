/**
*@author Sergey Zhernovoy
*@since
*This class extended item.
*/

package ru.szhernovoy.tracker.models;

public class Task extends Item {

	/** This value identifier array commentaries*/
	private String[] comment = new String[5];
	/** It's position current commentary for loop  write*/
	private int current = 0;

	/**
	 * Main constructor
	 * @param name
	 * Set name field.
	 * @param descr
	 * Set description field
     */
	public Task(String name, String descr){
		super(name,descr,System.currentTimeMillis());
	}

	/**
	 * Add commentary in array by loop. When current position equals length array , then
	 * current position for write become high on the array.
	 * @param comm
	 * String parameter set commentary in array
     */
	public void setComment(String comm){
		if(this.current == this.comment.length-1){
			this.current = 0;
		}
		this.comment[this.current++] = comm;
	}

	/**
	 * Getter for recieve commentary in current position.
	 * @return comment.
     */
	public String getComm(){
		int pos = this.current == 0 ?this.current : this.current  - 1;
		return this.comment[pos];
	}

	/**
	 * Getter for recieve commentary in any position.
	 * @param position
	 * @return comment.
     */
	public String getComm(int position){
		return this.comment[position < this.comment.length?position:this.current];
	}
	
	
}