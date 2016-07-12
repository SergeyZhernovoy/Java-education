/**
*@author Sergey Zhernovoy
*@since 12-07-2016
*This abstract class determined any action by class 
*/

package ru.szhernovoy.templates;
import ru.szhernovoy.start.*;


public abstract class BaseAction implements UserAction{

	private String name;
	
	public BaseAction(String name){
		this.name = name;
	}

	public String info(){
		return String.format("%s.) %s", this.key(),this.name);
	}
	

}