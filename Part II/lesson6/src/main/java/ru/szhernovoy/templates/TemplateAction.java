/**
*@author Sergey Zhernovoy
*@since 12-07-2016
*��� ����� ���������� ������� 
*/

package ru.szhernovoy.templates;


public abstract class TemplateAction {

	abstract void start();
	
	abstract void finish();

	public void work(){
		this.start();
		this.finish();
	}

}