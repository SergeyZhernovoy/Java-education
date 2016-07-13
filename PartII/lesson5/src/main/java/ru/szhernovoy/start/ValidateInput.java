/**
*@author Sergey Zhernovoy
*@since 09/07/2016
*/
package ru.szhernovoy.start;

public class ValidateInput extends ConsoleInput {
	
	public int ask(String question, int[] range){
		
		boolean invalid = true;
		int value = -1;
		do{
				try{
				value = super.ask(question,range);	
				invalid = false;
			}
		catch(MenuOfException moe){
			//moe.printStackTrace();
			System.out.println("Please select key from menu.");
			}
		catch(NumberFormatException nfe){
			System.out.println("Please enter validate data again.");
			}
		}
		while(invalid);
		return value;	
	}
	
	
}