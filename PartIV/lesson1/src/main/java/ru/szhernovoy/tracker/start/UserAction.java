/**
*@author Sergey Zhernovoy
*@since 09/07/2016
*/

package ru.szhernovoy.start;

public interface UserAction{

	int key();
	
	void execute(Input input, Tracker tracker);
	
	String info();

}