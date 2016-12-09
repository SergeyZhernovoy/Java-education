/**
*@author Sergey Zhernovoy
*@since 01-07-2016
*это класс выполнения трекера 
*/

package ru.szhernovoy.start;

public class StartUI{
	
	private Input input;
		  
	public StartUI(Input input){
		this.input = input;
	}
	
	public void init(){
		Tracker myTrack = new Tracker();
		MenuTracker menu = new MenuTracker(input,myTrack);
		menu.fillActions();
		int[] range = menu.getRangeKeys();
		do{
		   menu.show();	
		   menu.select(input.ask("select: ",range));
			
		}
		while(!"y".equals(this.input.ask("Exit? (y)")));
	
	}	
		
	public static void main(String[] args){
	
		new StartUI(new ValidateInput()).init();
	}
}