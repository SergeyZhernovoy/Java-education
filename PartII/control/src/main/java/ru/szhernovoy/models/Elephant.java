/**
*@author Sergey Zhernovoy
*@since 13/07/2016
* this class figure of chess
*Movement G 
*/
package ru.szhernovoy.models;
import ru.szhernovoy.templates.*;

public class Elephant extends Figure{
	
	public Elephant(Color color){
		super(color);
	}
	
	public String nameFigure(){
		return "E";
	}
	
	public boolean cheсkMove(Point A, Point B){
		boolean cheсk = false;
		
		int subX = B.getX() - A.getX() >0?B.getX() - A.getX():A.getX() - B.getX();
		int subY = B.getY() - A.getY()>0?B.getY() - A.getY():A.getY() - B.getY();
	
		//diagonal
		if(subX == subY){
			cheсk = true;
		}
		
		if(!cheсk){
			System.out.println("Uncorrect move for this figure");
		}
			
		return cheсk;
	}
	
} 