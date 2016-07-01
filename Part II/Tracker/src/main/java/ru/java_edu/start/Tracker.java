/**
*@author Sergey Zhernovoy
*@since 01-07-2016
*это класс хранения заявок 
*/

package ru.java_edu.start
import ru.java_edu.models.*;
import java.util.Random;

public class Tracker{
	
	private Item[] items;
	private int position = 0;
	private int last_pos = 0;
	private static final Random RN = Random();
	
	public void addItem(Item item){
		item.setId(this.generateId());
		if(this.position == this.items.length-1) {
			this.last_pos = this.position;
			this.position = 0;
		}
		else {
			this.last_pos = this.position;
		}
		this.items[position++] = item;
		
	}
	
	protected findById(String id){
		Item result =null;
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
	
	public Item[] getAll(){
		
		Item[] result = new Item[this.last_pos == 0?1:this.last_pos];
		for(int index = 0; index!=last_pos; last_pos++){
			result[index] = this.items[index];
		}
		return result;
	}
	
}