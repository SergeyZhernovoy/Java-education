/**
*@author Sergey Zhernovoy
*@since 01-07-2016
*это класс документ заявка 
*/

package ru.java_edu.models;

public class Task extends Item {
	
	public Task(String name, String descr){
		super(name,decr,System.CurrentTimeMillis());
	}
	
}