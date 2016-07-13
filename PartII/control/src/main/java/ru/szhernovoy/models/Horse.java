/**
*@author Sergey Zhernovoy
*@since 13/07/2016
* this class figure of chess
* Movement along the diagonal, max path - figure or end chess board
*/
package ru.szhernovoy.model;
import ru.szhernovoy.templates.*;

public class Horse extends Figure{
	
	public Horse(Color color){
		super(color);
	}
	
	public String nameFigure(){
		return "H";
	}
	
	public void move(){
		
	}
	
} 