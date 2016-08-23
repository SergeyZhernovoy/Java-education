package ru.szhernovoy.control;

import ru.szhernovoy.view.Cell;

/**
 * Created by szhernovoy on 16.08.2016.
 */
public class Logic {
    private Cell[][] cells;


    public void loadBoard(Cell[][] cells) {
        this.cells = cells;
    }

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

    public int isWinner(){
        // X - 0 || O - 1
        int rowField = 0;
        int columnField =0;
        int winner = -1;

        int rowFieldX = 0;
        int columnFieldX = 0;

        for (int valueX = 0; valueX < this.cells.length;valueX++) {
            rowField = 0;
            columnField = 0;
            for (int valueY = 0; valueY < this.cells.length; valueY++) {
                rowField +=  currentValueField(this.cells[valueX][valueY]);
                columnField += currentValueField(this.cells[valueY][valueX]);
            }
            if(rowField%this.cells.length == 0 && rowField !=0){
               winner =  rowField/this.cells.length - 1;
               break;
            }

            if(columnField%this.cells.length == 0 && columnField !=0 ){
                winner = columnField/this.cells.length - 1;
                break;
            }

        }

        /*if(winner == -1){
            int valueY = 0;
            int valueX = 0;
            int valueXM = this.cells.length -1;
            int valueYM = this.cells.length -1;
            rowField = columnField =0;
            for (; valueY < this.cells.length; valueY++,valueX++,valueXM--,valueYM--) {
                rowField +=  currentValueField(this.cells[valueX][valueY]);
                columnField += currentValueField(this.cells[valueXM][valueYM]);
            }

            if(rowField%this.cells.length == 0 && rowField !=0){
                winner =  rowField/this.cells.length - 1;
            }

            if(columnField%this.cells.length == 0 && columnField !=0 ){
                winner = columnField/this.cells.length - 1;
            }

        }*/

        return winner;

    }

    private int currentValueField(Cell cell){

        return cell.isEmpty() ? 0 : cell.isIconX() ? 1 : 2;

    }

    public boolean control(int[] answer){

        boolean result = false;
        if(this.cells[answer[0]][answer[1]].isEmpty()){
            result = true;
        }
        return result;
    }

    public void setValue(int[] answer, int index){
        if(index == 0){
            this.cells[answer[0]][answer[1]].setIconX(true);
        }
        else{
            this.cells[answer[0]][answer[1]].setIconO(true);
        }
    }

}

