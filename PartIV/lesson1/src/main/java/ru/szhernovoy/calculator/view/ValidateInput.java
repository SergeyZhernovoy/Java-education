/**
*@author Sergey Zhernovoy
*@since 09/07/2016
*/
package ru.szhernovoy.calculator.view;
import ru.szhernovoy.calculator.model.MenuOfException;

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
			super.println("Please select key from menu.");
			}
		catch(NumberFormatException nfe){
			super.println("Please enter validate data again.");
			}
		}
		while(invalid);
		return value;	
	}

	public String ask(String question, String[] range){

		boolean invalid = true;
		String value = "";
		do{
			try{
				value = super.ask(question,range);
				invalid = false;
			}
			catch(MenuOfException moe){
				super.println("Please select value from range: [+,-,/,*,=]");
			}
			catch(NumberFormatException nfe){
				super.println("Please enter validate data again.");
			}
		}
		while(invalid);
		return value;
	}

	public String ask(String question, boolean numeric){

		boolean invalid = true;
		String value = "";

		do{
			try{
				value = super.ask(question);
				if(!value.toLowerCase().equals("m")){
					Double.valueOf(value);
				}

				invalid = false;
			}   catch(NumberFormatException nfe){
				super.println("Please enter validate data again.");
			}
		}
		while(invalid);
		return value;
	}
	
}