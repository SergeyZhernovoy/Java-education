/**
*@author Sergey Zhernovoy
*@since 09/07/2016
*/
package ru.szhernovoy.calculator.view;
import ru.szhernovoy.calculator.model.MenuOfException;

public class ValidateInput extends ConsoleInput {

	/**
	 * method check input value in any range and get it if all right.
	 * @param question
	 * @param range range key's menu
	 * @return
	 */
	@Override
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

	/**
	 * Method get parametr and check it in range
	 * @param question question about choice method calculate
	 * @param range    array methods for calculate
	 * @return
	 */
	@Override
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

	/**
	 * method check input value in convert to double and get it if all right.
	 * @param question
	 * @param numeric
	 * @return
	 */
	@Override
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