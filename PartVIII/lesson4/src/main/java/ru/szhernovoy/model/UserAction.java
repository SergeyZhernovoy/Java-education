/**
*@author Sergey Zhernovoy
*@since 09/07/2016
*/

package ru.szhernovoy.model;

import ru.szhernovoy.io.Input;

public interface UserAction{

	int key();
	
	void execute(Input input, Tracker tracker);
	
	String info();

}