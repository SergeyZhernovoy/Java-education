/**
*@author Sergey Zhernovoy
*@since 05-07-2016
*это класс выполнения трекера заглушка
*/

package ru.szhernovoy.start;
import ru.szhernovoy.models.*;

public class StartUITest{
	
		
	public static void main(String[] args){
	
		Input input = new StubInput();
		new StartUI(input).init();
	}
	
	
}