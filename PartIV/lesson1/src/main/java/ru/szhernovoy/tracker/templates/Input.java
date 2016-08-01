/**
 * This interface indentifier main manner input in programm
*@author Sergey Zernovoy
*@since 12/07/2016
*
*/

package ru.szhernovoy.tracker.templates;

public interface Input {
	/**
	 * Refactor. Method asked any question and return answer.
	 * @return
     */
	String ask();

	 /**
	 * Refactor.
	 * Method asked any question. Get answer and chek it in range
	 * @param range
     * @return
     */
	int ask(int[] range);

	/**
	 * Refactor. Method set question
	 * @param question
     */
	void setQuestion(String question);

	/**
	 * Refactor. Method get question on the screen
     */
	void printQuestion();

	
}