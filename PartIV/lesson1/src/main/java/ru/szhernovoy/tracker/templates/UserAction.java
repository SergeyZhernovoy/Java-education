/**
 * interface menu
*@author Sergey Zhernovoy
*@since 09/07/2016
*/

package ru.szhernovoy.tracker.templates;

import ru.szhernovoy.tracker.start.Tracker;

public interface UserAction{

	/**
	 * Method return item number menu.
	 * @return
     */
	int key();

	/**
	 * Method execute any action on tracker
	 * @param tracker any object class tracker.
     */
	void execute(Tracker tracker);

	/**
	 * Print infomation about method
	 * @return
     */
	String info();

	/**
	 * Refactor. Method input data
	 * @return
	 */
	void inputAction();

}