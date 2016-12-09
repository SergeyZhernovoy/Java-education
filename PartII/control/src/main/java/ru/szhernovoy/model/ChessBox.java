/**
*@author Sergey Zhernovoy
*@since 13/07/2016
* this class position figure in field
*/

package ru.szhernovoy.model;
import ru.szhernovoy.templates.*;

public class ChessBox extends Point{
	
	private Figure chessFigure;
	
	
	public  ChessBox(int x, int y){
	        super(x,y);
	}
	
	public Figure getFigure(){
		return this.chessFigure;
	}
	
	public void setFigure(Figure figure){
		this.chessFigure = figure;
	}
	
	public String drawBox(){
		String result;
		if(chessFigure != null){
			result = chessFigure.info();
		}
		else {
			result = "|#|";
		}
		
		return result;
		
	}
	
}