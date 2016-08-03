/**
*@author Sergey Zhernovoy
*@since 12-07-2016
*This abstract class determined any action by class 
*/

package ru.szhernovoy.calculator.template;


import ru.szhernovoy.calculator.model.Calculator;

public abstract class BaseAction implements UserAction{

	private String name;

	protected Calculator calc;
	
	public BaseAction(String name, Calculator calc){
		this.name = name;
		this.calc = calc;
	}

	public String info(){
		return String.format("%s.) %s", this.key(),this.name);
	}
	

}