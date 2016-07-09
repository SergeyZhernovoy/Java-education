/**
*@author Sergey Zernovoy
/*@since 05/07/2016
*
*/

package ru.szhernovoy.start;

public class StubInput implements Input {
	
	private final String[] menu = {"1","4","8"}; 
	private int   positionMenu = 0;
	private int   position = 0;
	private String[] answer;
	
	public StubInput(String[] answer){
		this.answer = answer;
	}
	
	
	public String ask(String question){
	
		System.out.print(question);
		String[] action;
		int currentPosition = 0;
		if(question.contains("Press num")){
			currentPosition = this.positionMenu;
			this.positionMenu++;
			action = this.menu;
		}
		else{
			currentPosition = this.position;
			this.position++;
			action = this.answer;
		}
		
		System.out.println("\nCurrent choice is " + action[currentPosition]);
		return action[currentPosition];
	}

}