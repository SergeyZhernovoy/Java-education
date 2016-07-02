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
		
		Task task1 = new Task("ord 1", "Eto zajavka 1");
		Task task2 = new Task("ord 2", "Eto zajavka 2");
		Task task3 = new Task("ord 3", "Eto zajavka 3");
		Task task4 = new Task("ord 4", "Eto zajavka 4");
		Task task5 = new Task("ord 5", "Eto zajavka 5");
		Task task6 = new Task("ord 6", "Eto zajavka 6");
		Task task7 = new Task("ord 7", "Eto zajavka 7");
		Task task8 = new Task("ord 8", "Eto zajavka 8");
		Task task9 = new Task("ord 9", "Eto zajavka 9");
		
		myTrack.addItem(task1);
		myTrack.addItem(task2);
		myTrack.addItem(task3);
		myTrack.addItem(task4);
		myTrack.addItem(task5);
		myTrack.addItem(task6);
		myTrack.addItem(task7);
		myTrack.addItem(task8);
		myTrack.addItem(task9);
	
		
		for(Item item : myTrack.getAll()){
			System.out.println(item.getName());
		}
		
	}
	
	
}