package ru.szhernovoy.control;

import ru.szhernovoy.io.Cell;

/**
 * Created by szhernovoy on 16.08.2016.
 */
public class Logic {
    /**game board */
    private Cell[][] cells;


    /**
     * Setter game board
     * @param cells
     */
    public void loadBoard(Cell[][] cells) {
        this.cells = cells;
    }

    /**
     * If not empty cell - game over
     * @return
     */
      public boolean finish() {
        boolean finish = true;
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                finish =  !cell.isEmpty();
                if(!finish){
                   break;
                }
             }
            if(!finish){
                break;
            }
        }
        return finish;
    }

    /**
     * Check game on win. 0 - winner X ; 1 - winner O. Who game X or O set on start game.
     * @return
     */
    public int isWinner(){
        // X - 0 || O - 1
        int[] square = {0,0,0,0};
        int[] diagonal = {0,0,0,0};
        int winner = -1;
        int valueMinus = this.cells.length -1;
        for (int valueX = 0; valueX < this.cells.length;valueX++, valueMinus--) {
            square[0] = square[1] = square[2] = square[3] = 0;

            accumalateValue(this.cells[valueX][valueX], diagonal,1);
            accumalateValue(this.cells[valueMinus][valueMinus], diagonal,2);

            for (int valueY = 0; valueY < this.cells.length; valueY++) {
                accumalateValue(this.cells[valueX][valueY], square,1);
                accumalateValue(this.cells[valueY][valueX], square,2);
            }
            winner = checkOnWin(square[0],square[2],square[1],square[3]);
            if(winner  == -1){
               winner = checkOnWin(diagonal[0],diagonal[2],diagonal[1],diagonal[3]);
            }

            if(winner == 0 || winner == 1){
                break;
            }
        }
        return winner;
    }

    /**
     * Accumalate value.
     * @param cell
     * @param value
     * @param type type = 1 row/diagonal left -right  type = 2 column/diagonal right-left
     */
    public void accumalateValue(Cell cell, int[] value, int type){

         if(type == 1){
            if(currentValueField(cell) == 1){
                value[0] = value[0] + 1 ;
            }

            if(currentValueField(cell) == 2){
                value[1] = value[1] + 2 ;
            }
        }
        else{

            if(currentValueField(cell) == 1){
                value[2] = value[2] + 1 ;
            }

            if(currentValueField(cell) == 2){
                value[3] = value[3] + 2 ;
            }
        }
    }


    /**
     * Check  accumalate  value on win. acummalate X = 3, O = 6 in matrix 3 x 3
     * @param param1 string X
     * @param param2 string O
     * @param param3 column X
     * @param param4 column O
     * @return
     */
    public int checkOnWin(int param1, int param2,int param3, int param4 ){
        int winner = -1;

        if(param1%this.cells.length == 0 && param1 !=0 || param2%this.cells.length == 0 && param2 !=0){
            winner =  0;
        }

        if(param3%this.cells.length == 0 && param3 !=0 || param4%this.cells.length == 0 && param4 !=0){
            winner = 1;
        }
        return winner;
    }


    /**
     * Return value cell  1 = X; 2 = O; empty = 0.
     * @param cell
     * @return
     */
    private int currentValueField(Cell cell){

        return cell.isEmpty() ? 0 : cell.isIconX() ? 1 : 2;

    }

    /**
     * Control position on set value in array cell.
     * @param answer
     * @return
     */
    public boolean control(int[] answer){

        boolean result = false;
        if(this.cells[answer[0]][answer[1]].isEmpty()){
            result = true;
        }
        return result;
    }

    /**
     * Set value in cell.
     * @param answer
     * @param index
     */
    public void setValue(int[] answer, int index){
        if(index == 0){
            this.cells[answer[0]][answer[1]].setIconX(true);
        }
        else{
            this.cells[answer[0]][answer[1]].setIconO(true);
        }
    }

}

