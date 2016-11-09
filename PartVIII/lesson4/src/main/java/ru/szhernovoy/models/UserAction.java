/**
*@author Sergey Zhernovoy
*@since 09/07/2016
*/

package ru.szhernovoy.models;

import ru.szhernovoy.start.Input;
import ru.szhernovoy.start.Tracker;

public interface UserAction{

	int key();
	
	void execute(Input input, Tracker tracker);
	
	String info();

}