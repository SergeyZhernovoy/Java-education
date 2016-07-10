/**
*@author Sergey Zernovoy
/*@since 05/07/2016
*
*/

package ru.szhernovoy.start;

public class StubInput implements Input {
	
	private final String[] menu = {"0","1"}; 
	private int   positionMenu = 0;
	private int   position = 0;
	private String[] answer;
	
	public StubInput(String[] answer){
		this.answer = answer;
	}
	
	
	public String ask(String question){
		
		String[] action = new String[]{"n"};
		int currentPosition = 0;
	
		
		if(question.contains("select")&& positionMenu < 2){
				System.out.println("\nlog 1");
				currentPosition = this.positionMenu;
				this.positionMenu++;
				action = this.menu;
			}
		if(question.contains("Please")&& positionMenu < 2){
			currentPosition = this.position;
			this.position++;
			action = this.answer;
			System.out.println("\nlog 2");
		}	
		if(question.contains("Exit")&& positionMenu == 2){
			action = new String[]{"y"};
		}	
		
		return action[currentPosition];
	}

}