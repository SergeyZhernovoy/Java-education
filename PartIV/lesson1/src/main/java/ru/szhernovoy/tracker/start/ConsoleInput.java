/**
* Class ConsoleInput interactive class user input method
*  @author Sergey Zernovoy
*@since 12/07/2016
*
*/

package ru.szhernovoy.tracker.start;
import ru.szhernovoy.tracker.templates.Input;

import java.util.Scanner;

public class ConsoleInput implements Input {

	/** The value setting user input.*/
	private Scanner scanner = new Scanner(System.in);
	/** Refactor. This value contains last question*/
	private String asked;

	/**
	 * Refactor. This method
	 * @return reader line from scanner
     */
	public String ask(){
		return scanner.nextLine();
	}

	/**
	 * Method recieve input value , then
	 * @param range
	 * range of keys
	 * @return key.
     */
	public int ask(int[] range){
		
		int key = Integer.valueOf(this.ask());

		if(checkKeyInArray(key,range)){
		   return key;
		}
		else{
			throw new MenuOfException("out of menu range");
		}
	}

	/**
	 * Method checked key in array. And if it correct return true.
	 * @param key
	 * value for checking
	 * @param range
	 * range of keys
     * @return result
	 * checked range true / false
     */
	private boolean checkKeyInArray(int key, int[] range){
		boolean result = false;
		for(int value : range){
			if(value == key){
				result = true;
				break;
			}
		}
		return  result;
	}

	/**
	 * Refactor. Method set question
	 *
	 * @param question
	 */
	@Override
	public void setQuestion(String question) {
		this.asked = question;
	}

	/**
	 * Refactor. Method get question on the screen
	 */
	@Override
	public void printQuestion() {
		System.out.print(this.asked);
	}
}