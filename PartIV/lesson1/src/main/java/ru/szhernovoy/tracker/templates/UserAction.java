/**
*@author Sergey Zhernovoy
*@since 09/07/2016
*/

package ru.szhernovoy.tracker.templates;

import ru.szhernovoy.tracker.start.Tracker;

public interface UserAction{

	int key();
	
	void execute(Input input, Tracker tracker);
	
	String info();

}