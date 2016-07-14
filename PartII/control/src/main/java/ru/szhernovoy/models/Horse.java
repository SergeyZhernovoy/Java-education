/**
*@author Sergey Zhernovoy
*@since 13/07/2016
* this class figure of chess
* Movement along the diagonal, max path - figure or end chess board
*/
package ru.szhernovoy.models;
import ru.szhernovoy.templates.*;

public class Horse extends Figure{
	
	public Horse(Color color){
		super(color);
	}
	
	public String nameFigure(){
		return "H";
	}
	
	public boolean chekMove(Point A, Point B){
		boolean chek = false;
		
		int subX = B.getX() - A.getX() >0?B.getX() - A.getX():A.getX() - B.getX();
		int subY = B.getY() - A.getY()>0?B.getY() - A.getY():B.getY() - A.getY();
	
		if((subX== 2 && subY == 1) || (subY == 2 && subX == 1)){
			chek = true;
		}
			
		if(!chek){
			System.out.println("Uncorrect move for this figure");
		}
		
		return chek;
	}
	
} 