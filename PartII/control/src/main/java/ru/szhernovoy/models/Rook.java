/**
*@author Sergey Zhernovoy
*@since 13/07/2016
* this class figure of chess
*/
package ru.szhernovoy.model;
import ru.szhernovoy.templates.*;

public class Rook extends Figure{
	
	public Rook(Color color){
		super(color);
	}
	
	public String nameFigure(){
		return "R";
	}
	
	public boolean chekMove(Point A, Point B){
		
		boolean chek = false;
		
		if((A.getY() == B.getY() && B.getX() != A.getX()) || (A.getY() != B.getY() && B.getX() == A.getX()) ){
			chek = true;
		}
				
		return chek;
		
		
	}
	
} 