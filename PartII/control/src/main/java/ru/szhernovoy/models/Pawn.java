/**
*@author Sergey Zhernovoy
*@since 13/07/2016
* this class figure of chess
* Movement straight max path 1 point
*/
package ru.szhernovoy.models;
import ru.szhernovoy.templates.*;

public class Pawn extends Figure{
	
	public Pawn(Color color){
		super(color);
	}
	
	public String nameFigure(){
		return "P";
	}
	
	public boolean cheсkMove(Point A, Point B){
		boolean cheсk = false;
		
		int subX = B.getX() - A.getX() >0?B.getX() - A.getX():A.getX() - B.getX();
		int subY = B.getY() - A.getY()>0?B.getY() - A.getY():B.getY() - A.getY();
		
		if(subY == 0 && subX == 1){
		   cheсk = true;
		}
		
		if(!cheсk){
			System.out.println("Uncorrect move for this figure");
		}
		return cheсk;
	}
	
} 