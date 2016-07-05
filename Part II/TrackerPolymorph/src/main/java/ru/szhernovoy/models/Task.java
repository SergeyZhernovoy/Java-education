/**
*@author Sergey Zhernovoy
*@since 01-07-2016
*это класс документ заявка 
*/

package ru.szhernovoy.models;

public class Task extends Item {
	
	private String[] comment = new String[5];
	private int current = 0;
	
	public Task(String name, String descr){
		super(name,descr,System.currentTimeMillis());
	}
	
	public void setComment(String comm){
		if(this.current == this.comment.length-1){
			this.current = 0;
		}
		this.comment[this.current++] = comm;
	}
	
	public String getComm(){
		int pos = this.current == 0 ?this.current : this.current  - 1;
		return this.comment[pos];
	}
	
	public String getComm(int position){
		return this.comment[position < this.comment.length?position:this.current];
	}
	
	
}