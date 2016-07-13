/**
*@author Sergey Zhernovoy
*@since 01-07-2016
*это класс выполнения трекера 
*/

package ru.szhernovoy.start;
import ru.szhernovoy.models.*;

public class StartUI{
	
	private Input input;
		  
	public StartUI(Input input){
		this.input = input;
	}
	
	public void init(Tracker myTrack){
		MenuTracker menu = new MenuTracker(input,myTrack);
		menu.fillActions();
		do{
		   menu.show();	
		   int key = Integer.valueOf(input.ask("select: "));
		   menu.select(key);
			
		}
		while(!"y".equals(this.input.ask("Exit? (y)")));
	
	}	
		
	public static void main(String[] args){
	
		new StartUI(new ConsoleInput()).init(new Tracker());
	}
}