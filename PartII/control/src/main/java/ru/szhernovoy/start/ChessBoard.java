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
	private ChessBox[][] board = new ChessBox[SIZE_BOARD][SIZE_BOARD];
	private final String[] gorizontalName = new String[]{"a","b","c","d","e","f","g","h"};
	private final String[] verticalName = new String[]{"1","2","3","4","5","6","7","8"};
	private final String[] orderChess = new String[]{"R","H","E","Q","K","E","H","R"};
	
	
	public String[]	getRangeABC(){
		return this.gorizontalName;
	}
	
	public String[] getRangeNum(){
		return this.verticalName;
	}

	public ChessBox getBox(Point A){
		return this.board[A.getX()][A.getY()];
	}
	
	public void setBox(Point A, Point B){
		this.board[B.getX()][B.getY()].setFigure(this.board[A.getX()][A.getY()].getFigure());
		this.board[A.getX()][A.getY()].setFigure(null);
	}
	
	//int[] rangeNum = board.getRangeNum();
	
	
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
	
	private ChessBox[] getChessBoxes(int startX,int startY, int finishX, int finishY){
		
		int subX = finishX - startX >0?finishX - startX:startX - finishX;
		int subY = finishY - startY>0?finishY - startY:startY - finishY;
		ChessBox[] result = new ChessBox[1];
		int delta,deltaX,deltaY;
		//diagonal
		if(subX == subY){
			result = new ChessBox[subX];
			deltaX = (finishX - startX) > 0?1:-1;
			deltaY = (finishY - startY) > 0?1:-1;
			System.out.println(4+" dleta y " + deltaY+" delta x "+ deltaX );
			for(int index =0 ; index < subX;index++){
				startX +=deltaX;
				startY +=deltaY;
				System.out.println(5+" "+startX +" "+startY);
				result[index] = this.board[startX][startY];	
			}
		}
		//rigth
		if(subX == 0 || subY == 0){
		   if(subX == 0){
			  result = new ChessBox[subY]; 
			  delta = (finishY - startY) > 0?1:-1;
			  for(int index =0 ; index < result.length;index++){
				startY +=delta;
				result[index] = this.board[startX][startY];	
			}
		   }
		   
		   if(subY == 0){
			   result = new ChessBox[subX]; 
			   delta = (finishX - startX) > 0?1:-1;
			   for(int index =0 ; index < result.length;index++){
				startX +=delta;
				result[index] = this.board[startX][startY];	
			}
		   }
		}
		//horse
		if((subX== 2 && subY == 1) || (subY == 2 && subX == 1)){
			result[0] = this.board[finishX][finishY];
		}
		
		return result;		
	}
	
	public boolean cheсkCourse(Point A, Point B){
		boolean result = true;
		for(ChessBox box : this.getChessBoxes(A.getX(),A.getY(),B.getX(),B.getY())){
			if(box.getFigure() != null){
			   result = false;
			   break;
			}
		}
		return result;
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
				//System.out.print(indexX +""+indexY+"\t");
			}
			System.out.print("\n\n");
		}
	}
	
}