package ru.szhernovoy.control;

import ru.szhernovoy.view.Cell;

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
        int rowFieldO,columnFieldO,rowFieldX,columnFieldX;
        rowFieldO = columnFieldO = rowFieldX = columnFieldX = 0;

        int winner = -1;


        for (int valueX = 0; valueX < this.cells.length;valueX++) {
            rowFieldO = 0;
            columnFieldO = 0;
            rowFieldX = 0;
            columnFieldX = 0;
            for (int valueY = 0; valueY < this.cells.length; valueY++) {

                if(currentValueField(this.cells[valueX][valueY]) == 1){
                    rowFieldX++;
                }

                if(currentValueField(this.cells[valueX][valueY]) == 2){
                    rowFieldO +=2;
                }

                if(currentValueField(this.cells[valueY][valueX]) == 1){
                    columnFieldX++;
                }

                if(currentValueField(this.cells[valueY][valueX]) == 2){
                    columnFieldO +=2;
                }
            }
            if(rowFieldX%this.cells.length == 0 && rowFieldX !=0 || columnFieldX%this.cells.length == 0 && columnFieldX !=0){
               winner =  0;
               break;
            }

            if(rowFieldO%this.cells.length == 0 && rowFieldO !=0 || columnFieldO%this.cells.length == 0 && columnFieldO !=0){
                winner = 1;
                break;
            }

        }

        if(winner == -1){
            rowFieldO = columnFieldO = rowFieldX = columnFieldX = 0;
            int valuePlus  = 0;
            int valueMinus = this.cells.length -1;
            for (; valuePlus < this.cells.length;valuePlus++,valueMinus--) {

                if(currentValueField(this.cells[valuePlus][valuePlus]) == 1){
                    rowFieldX ++;
                }

                if(currentValueField(this.cells[valuePlus][valuePlus]) == 2){
                    rowFieldO +=  2;
                }

                if(currentValueField(this.cells[valueMinus][valueMinus]) == 1){
                    columnFieldX ++;
                }

                if(currentValueField(this.cells[valueMinus][valueMinus]) == 2){
                    columnFieldO += 2;
                }
            }

            if(rowFieldX%this.cells.length == 0 && rowFieldX !=0 || columnFieldX%this.cells.length == 0 && columnFieldX !=0){
                winner =  0;
            }

            if(rowFieldO%this.cells.length == 0 && rowFieldO !=0 || columnFieldO%this.cells.length == 0 && columnFieldO !=0){
                winner = 1;
            }
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

