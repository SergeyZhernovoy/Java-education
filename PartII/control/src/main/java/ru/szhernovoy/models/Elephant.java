/**
*@author Sergey Zhernovoy
*@since 13/07/2016
* this class figure of chess
*Movement G 
*/
package ru.szhernovoy.model;
import ru.szhernovoy.templates.*;

public class Elephant extends Figure{
	
	public Elephant(Color color){
		super(color);
	}
	
	public String nameFigure(){
		return "E";
	}
	
	public boolean chekMove(Point A, Point B){
		boolean chek = false;
		
		if((A.getY() == B.getY() && B.getX() != A.getX()) || (A.getY() != B.getY() && B.getX() == A.getX()) ){
			chek = true;
		}
				
		return chek;
	}
	
} 