/**
*@author Sergey Zhernovoy
*@since 14/07/2016
* 
*/
package ru.szhernovoy.start;
import ru.szhernovoy.models.*;
import ru.szhernovoy.templates.*;

public class GameMenu{

	private ChessBoard board;
	private Input input;	
	UserAction[] actions = new UserAction[2]; 

	public GameMenu(Input input, ChessBoard board){
		this.board = board;
		this.input = input;
	}
	
	public void fillActions(){
		this.actions[0] = this.new NewGame("New game.");
		this.actions[1] = new GameMenu.MoveTo("Move figure.");
	}
	
	public void show(){
		for(UserAction action : this.actions){
			if(action != null){
			System.out.println(action.info());
			}
		}
	}
		
	public void select(int key){
		this.actions[key].execute(input,board);
	}
	
	public int[] getRangeKeys(){
		int[] range = new int[actions.length];
		int position = 0;
		for(UserAction action : actions){
			range[position++] = action.key();
		}
		
		return range;
	}
	
	private class NewGame extends BaseAction {
		
		public NewGame(String action){
			super(action);
		}
				
		public int key(){
			return 0;
		}
		
		public void execute(Input input, ChessBoard board){
			board.fillBoard();
		}
	}
	
	private static class MoveTo extends BaseAction {
		
		public MoveTo(String action){
			super(action);
		}
				
		public int key(){
			return 1;
		}
		
		public void execute(Input input, ChessBoard board){
			
			String[] abc = board.getRangeABC();
			String[] num = board.getRangeNum();
			String[] start = input.ask("Please enter start position (example a1): ",abc,num);
			String[] finish = input.ask("Please enter finish position (example a2): ",abc,num);
			int startX, startY, finishX, finishY;
			startX = startY = finishX = finishY = 0;
			startX  = findIndex(start[0], abc);
			startY  = findIndex(start[1], num);
			finishX = findIndex(finish[0], abc);
			finishY = findIndex(finish[1], num);
					
			Point A = new Point(startX,startY);
			Point B = new Point(finishX,finishY);
		
			if(board.getBox(A).getFigure().chekMove(A,B)){
				if(board.chekCourse(A,B)){
					board.setBox(A,B);
				}
			}
		}
		
		private int findIndex(String symbol, String[] range){
			int result = 0;
			for(int index = 0;index < range.length; index++){
				if(symbol.equals(range[index])){
				    result = index;
					break;	
				}
			}
			return result;
		}
	}
		
}