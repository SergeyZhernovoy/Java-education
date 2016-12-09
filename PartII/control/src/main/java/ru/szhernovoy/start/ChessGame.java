/**
*@author Sergey Zhernovoy
*@since 13/07/2016
* this main class game
*/

package ru.szhernovoy.start;

public class ChessGame{
	
	private Input input;
	private ChessBoard board;
		  
	public ChessGame(Input input){
		this.input = input;
	}
	
	public void init(ChessBoard board){
		this.board = board;
		GameMenu menu = new GameMenu(this.input,this.board);
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
	
		new ChessGame(new ValidateInput()).init(new ChessBoard());
	}
	
	
}