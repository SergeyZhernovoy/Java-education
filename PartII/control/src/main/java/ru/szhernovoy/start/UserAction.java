/**
*@author Sergey Zhernovoy
*@since 14/07/2016
* this main class game
*/
package ru.szhernovoy.start;


public interface UserAction{
	
	int key();
	
	void execute(Input input, ChessBoard board);
	
	String info();
	
}