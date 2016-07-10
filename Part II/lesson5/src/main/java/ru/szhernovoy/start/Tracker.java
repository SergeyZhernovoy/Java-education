/**
*@author Sergey Zhernovoy
*@since 01-07-2016
*это класс хранения заявок 
*/

package ru.szhernovoy.start;
import ru.szhernovoy.models.*;
import java.util.Random;

public class Tracker{
	
	private Task[] items = new Task[6];
	private int position = 0;
	private static final Random RN = new Random();
	
	public Task addItem(Task item){
		item.setId(this.generateId());
		if(this.position == this.items.length-1) {
		   this.position = 0;
		}
		this.items[position++] = item;
		return item;
	}
	
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
	
	String generateId(){
		return String.valueOf(System.currentTimeMillis() + RN.nextInt());
	}
	
	public Task[] getAll(){
		
		Task[] result = new Task[this.position];// позиция всегда указывает на пустой или возможно пустой элемент
		for(int index = 0; index<this.position; index++){
			result[index] = this.items[index];
		}
		return result;
	}
	
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
	
	public void deleteItem(Task item){
		String id = item.getId();
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
		
	public void addCommentary(Task item, String comm){
		
		Task inner_item = findById(item.getId());
		if(inner_item != null){
		   inner_item.setComment(comm);
		}
	
	}
	
	public String getCommentary(Task item){
	
		String result =null;
		Task inner_item = findById(item.getId());
			
		if(inner_item != null){
			result = inner_item.getComm();
		}
			
		return result;
	}
	
	public String getCommentary(Task item, int pos){
		
		String result = null;
		Task inner_item = findById(item.getId());
			
		if(inner_item != null){
			result = inner_item.getComm(pos);
		}
			
		return result;
	}
	
}