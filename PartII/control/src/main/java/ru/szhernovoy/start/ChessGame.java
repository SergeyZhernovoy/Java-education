/**
*@author Sergey Zhernovoy
*@since 13/07/2016
* this main class game
*/

package ru.szhernovoy.start;

public class ChessGame{
	
	private ChessBoard board = new ChessBoard();
	
	public void init(){
		this.board.fillBoard();
		this.board.drawBoard();
	}
	
	public static void  main(String[] args){
		ChessGame game = new ChessGame();
		game.init();
		/*do{
			this.board.drawBoard();
		}
		while(!"y".equals(Input.ask("Exit? (y) ")));*/
	}
	
}