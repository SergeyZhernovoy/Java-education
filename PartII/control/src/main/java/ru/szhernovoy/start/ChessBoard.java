/**
*@author Sergey Zhernovoy
*@since 13/07/2016
* this main class game
*/

package ru.szhernovoy.start;
import ru.szhernovoy.model.*;
import ru.szhernovoy.templates.Color;

public class ChessBoard{
	
	private final int SIZE_BOARD = 8;
	private final ChessBox[][] board = new ChessBox[SIZE_BOARD][SIZE_BOARD];
	private final String[] gorizontalName = new String[]{"a","b","c","d","e","f","g","h"};
	private final String[] verticalName = new String[]{"1","2","3","4","5","6","7","8"};
	private final String[] orderChess = new String[]{"R","H","E","Q","K","E","H","R"};
	
	/**
	*initialize board
	*/
	public void fillBoard(){
		
		for(int indexX = 0; indexX < SIZE_BOARD;indexX++){
			for(int indexY = 0; indexY < SIZE_BOARD;indexY++){
				board[indexX][indexY] = new ChessBox(indexX,indexY);
				if(indexX == 0 || indexX == 7){
					Color color = Color.White;
					if(indexX == 0){
						color = Color.Black;
					}
										
					if(orderChess[indexY].equals("R")){
						board[indexX][indexY].setFigure(new Rook(color));
					}
					if(orderChess[indexY].equals("H")){
						board[indexX][indexY].setFigure(new Horse(color));
					}
					if(orderChess[indexY].equals("E")){
						board[indexX][indexY].setFigure(new Elephant(color));
					}
					if(orderChess[indexY].equals("Q")){
						board[indexX][indexY].setFigure(new Queen(color));
					}
					if(orderChess[indexY].equals("K")){
						board[indexX][indexY].setFigure(new King(color));
					}
				}
				
				if(indexX == 1 || indexX == 6){
					Color color = Color.White;
					if(indexX == 1){
						color = Color.Black;
					}
					board[indexX][indexY].setFigure(new Pawn(color));
				}
			}
		}
	}
	
	
	public void drawBoard(){
		//System.out.print("   ");
		for(String name : this.gorizontalName){
			System.out.printf("\t%s",name);
		}
		System.out.print("\n\n\n\n");
		for(int indexX = 0; indexX < SIZE_BOARD;indexX++){
				System.out.printf("%s\t",verticalName[indexX]);
			for(int indexY = 0; indexY < SIZE_BOARD;indexY++){
				System.out.print(String.format("%s\t",board[indexX][indexY].drawBox()));
			}
			System.out.print("\n\n");
		}
		
	}
	
}