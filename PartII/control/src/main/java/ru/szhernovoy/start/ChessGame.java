/**
*@author Sergey Zhernovoy
*@since 13/07/2016
* this main class game
*/

package ru.szhernovoy.start;
import ru.szhernovoy.models.*;
import ru.szhernovoy.templates.*;

public class ChessGame{
	
	private Input input;
		  
	public ChessGame(Input input){
		this.input = input;
	}
	
	public void init(){
		ChessBoard board = new ChessBoard();
		GameMenu menu = new GameMenu(this.input,board);
		menu.fillActions();
		board.fillBoard();
		
		int[] range = menu.getRangeKeys();
	
		do{
		   menu.show();	
		   menu.select(input.ask("select: ",range));
		   board.drawBoard();
		}
		while(!"y".equals(this.input.ask("Exit? (y)")));
	}	
		
	public static void main(String[] args){
	
		new ChessGame(new ValidateInput()).init();
	}
	
	
}