package ru.szhernovoy.tracker.start;

/**
 * Own class exception
 */
public class MenuOfException extends RuntimeException {

	/**
	 * Main constructor.
	 * @param msg message on print
     */
	public MenuOfException(String msg){
		super(msg);
	}
}