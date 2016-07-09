/**
*@author Sergey Zhernovoy
*@since 06-07-2016
*это класс выполнения трекера заглушка
*/

package ru.szhernovoy.start;

public class StartUITest{
	
		
	public static void main(String[] args){
	
		Input input = new StubInput(new String[]{"eto pervaja zajavka","eto test stub input zajavka"});
		new StartUI(input).init();
	}
	
	
}