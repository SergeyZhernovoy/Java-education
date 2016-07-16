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
	
	public boolean cheсkMove(Point A, Point B){
		
		boolean cheсk = false;
		int subX = B.getX() - A.getX() >0?B.getX() - A.getX():A.getX() - B.getX();
		int subY = B.getY() - A.getY()>0?B.getY() - A.getY():A.getY() - B.getY();
		
		if((subX == 0 && subY != 0) || (subX != 0 && subY == 0) ){
			cheсk = true;
		}
		if(!cheсk){
			System.out.println("Uncorrect move for this figure");
		}
				
		return cheсk;
		
		
	}
	
} 