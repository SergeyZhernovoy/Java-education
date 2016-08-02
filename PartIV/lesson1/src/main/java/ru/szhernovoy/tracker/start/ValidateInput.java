/**
 * This class do validate enter value
*@author Sergey Zhernovoy
*@since 09/07/2016
*/
package ru.szhernovoy.tracker.start;

public class ValidateInput extends ConsoleInput {

	/**
	 * Method test enter value while it have not right value
	 * @param range
	 * range of keys
	 * @return
     */
	@Override
	public int ask(int[] range){
		
		boolean invalid = true;
		int value = -1;
		do{
				try{
				value = super.ask(range);
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