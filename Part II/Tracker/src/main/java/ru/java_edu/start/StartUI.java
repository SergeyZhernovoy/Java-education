/**
*@author Sergey Zhernovoy
*@since 01-07-2016
*это класс выполнения трекера 
*/

package ru.java_edu.start;
import ru.java_edu.models.*;

public class StartUI{
	
	public static void main(String[] args){
		
		Tracker myTrack = new Tracker();
		myTrack.add(new Task("first task", "this is first task"));
		for(Item item : myTrack.getAll()){
			System.out.println(item.getName());
		}
		
	}
	
	
}