/**
*@author Sergey Zhernovoy
*@since 13/07/2016
* this class figure of chess 
* Movement max path - 1 pos
*/
package ru.szhernovoy.models;
import ru.szhernovoy.templates.*;

public class King extends Figure{
	
	public King(Color color){
		super(color);
	}
	
	public String nameFigure(){
		return "K";
	}
	
	public boolean chekMove(Point A, Point B){
		boolean chek = false;
		int izmY = A.getY() > B.getY()?A.getY() - B.getY():B.getY() - A.getY() ;
		int izmX = A.getX() > B.getX()?A.getX() - B.getX():B.getX() - A.getX() ;
		
		if(izmY <= 1 && izmX <= 1){
			chek = true;
		}
			
		if(!chek){
			System.out.println("Uncorrect move for this figure");
		}
		
		return chek;
	}
	
} 