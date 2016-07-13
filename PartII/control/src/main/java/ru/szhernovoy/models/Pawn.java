/**
*@author Sergey Zhernovoy
*@since 13/07/2016
* this class figure of chess
* Movement straight max path 1 point
*/
package ru.szhernovoy.model;
import ru.szhernovoy.templates.*;

public class Pawn extends Figure{
	
	public Pawn(Color color){
		super(color);
	}
	
	public String nameFigure(){
		return "P";
	}
	
	public boolean chekMove(Point A, Point B){
		boolean chek = false;
		
		if(A.getY() == B.getY() && ((B.getX() - A.getX()) == 1){
			chek = true;
		}
				
		return chek;
	}
	
} 