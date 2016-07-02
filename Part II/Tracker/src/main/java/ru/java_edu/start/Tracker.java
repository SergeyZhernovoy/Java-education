/**
*@author Sergey Zhernovoy
*@since 01-07-2016
*это класс хранения заявок 
*/

package ru.java_edu.start
import ru.java_edu.models.*;
import java.util.Random;

public class Tracker{
	
	private Task[] items = new Task[8];
	private int position = 0;
	private static final Random RN = Random();
	
	public void addItem(Item item){
		item.setId(this.generateId());
		if(this.position == this.items.length-1) {
		   this.position = 0;
		}
		this.items[position++] = item;
	}
	
	protected Task findById(String id){
		Task result =null;
		for(Item item : this.items){
				if(item != null && item.getId().equals(id)){
					result = item;
					break;
				}
		}
		return result;		
	}
	
	String generateId(){
		return String.valueOf(System.CurrentTimeMillis() + RN.nextInt());
	}
	
	public Task[] getAll(){
		
		Task[] result = new Task[this.position == 0?1:this.position];
		for(int index = 0; index!=position; index++){
			result[index] = this.items[index];
		}
		return result;
	}
	
	public Task[] findByFilter(String name){
		int length = this.items.length;
		Task[] copy = new Task[length];
		int filterIndex = 0;
		for(int fullIndex = 0;index < length;index++){
				if(this.items[index] != null && this.items[index].getName().contains(name)){
					copy[filterIndex++] = this.items[index];
				}
		}
		
		Task[] result = new Task[++filterIndex];
		System.arraycopy(copy,0,result,0,filterIndex);
		return result;		
	}
	
	public Task[] findByFilter(String name, String decr){
	
		int length = this.items.length;
		Task[] copy = new Task[length];
		int filterIndex = 0;
		for(int fullIndex = 0;index < length;index++){
				if(this.items[index] != null && this.items[index].getName().contains(name)&&this.items[index].getDescr().contains(decr)){
					copy[filterIndex++] = this.items[index];
				}
		}
		
		Task[] result = new Task[++filterIndex];
		System.arraycopy(copy,0,result,0,filterIndex);
		return result;		
	
	}
	
	public void deleteItem(Item item){
		String id = item.getId();
		if(id != null){
			for(int index = 0; index < this.items.length; index++){
				if(this.items[index] != null && this.items[index].getId().equals(id)){
				   this.items[index] = null;
				}
			
				if(this.items[index] == null && (index+1) != this.items.length){
				   this.items[index] = this.items[index+1];
				   this.items[index+1] = null;
				   position = index+1;	
				}
			}
		}
	}
	
	public void updateItem(Item item){
		String id = item.getId();
		if(id != null){
			for(int index = 0; index < this.items.length; index++){
				if(this.items[index] == null && this.items[index].getId().equals(id)){
				   this.items[index] = item;
				   break;
				}
			}
		}
	}
		
	public void addCommentary(Item item, String comm){
		
		Item inner_item = findById(item.getId());
		if(inner_item != null){
		   inner_item.setComment(comm);
		}
	
	}
	
	public String getCommentary(Item item){
	
		String result;
		Item inner_item = findById(item.getId());
			
		if(inner_item != null){
			result = inner_item.getComm();
		}
			
		return result;
	}
	
	public String getCommentary(Item item, index pos){
		
		String result;
		Item inner_item = findById(item.getId());
			
		if(inner_item != null){
			result = inner_item.getComm(pos));
		}
			
		return result;
	}
	
}