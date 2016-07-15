/**
*@author Sergey Zhernovoy
*@since 13/07/2016
* this class figure of chess
*/
package ru.szhernovoy.models;
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
		int subX = B.getX() - A.getX() >0?B.getX() - A.getX():A.getX() - B.getX();
		int subY = B.getY() - A.getY()>0?B.getY() - A.getY():A.getY() - B.getY();
		
		if((subX == 0 && subY != 0) || (subX != 0 && subY == 0) ){
			chek = true;
		}
		if(!chek){
			System.out.println("Uncorrect move for this figure");
		}
				
		return chek;
		
		
	}
	
} 