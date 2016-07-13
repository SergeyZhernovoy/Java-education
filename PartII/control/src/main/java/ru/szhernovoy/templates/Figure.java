/**
*@author Sergey Zhernovoy
*@since 13/07/2016
* this class abstract figure
*/

package ru.szhernovoy.templates;
import ru.szhernovoy.model.*;

public abstract class Figure implements ChessAction{
	
	private final Color color; 
	
	public abstract String nameFigure();
	
	public Figure(Color color){
		this.color = color;
	}
	
	private String colorName(){
		String result;
		if(color == Color.Black){
			result = "B";
		}
		else {
			result = "W";
		}
		return result; 
	}
	
	public String info(){
		return String.format("%s%s", this.colorName(),this.nameFigure());
	}

}
