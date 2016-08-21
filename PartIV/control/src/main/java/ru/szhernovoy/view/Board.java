package ru.szhernovoy.view;


import ru.szhernovoy.model.IO;

/**
 * Created by szhernovoy on 20.08.2016.
 */
public class Board {
    private Cell[][] cells;


    public void drawBoard(Cell[][] cells) {
        this.cells = cells;
        this.redraw();
    }

    public void drawCell() {
        System.out.println("***** SELECT ******");
        this.redraw();
    }

    public void drawScreenOnInit() {
        System.out.println("***** NEW GAME TIC-TAC-TOE ******");
    }


    public int[] rangeBoard(){
        int[] range = new int[this.cells.length];
        for (int index = 0; index < this.cells.length;index++){
            range[index] = index+1;
        }
        return range;
    }


    public void congratulate() {
        System.out.println("***** CONGRATULATE ******");
    }

    private void redraw() {
        int  y = 1;
        System.out.print("[\\]");

        for(int index = 0; index < this.cells.length; index++){
            System.out.print(String.format("[%s]",index+1));
        }
        System.out.println("");
        for (Cell[] row : this.cells) {
            System.out.print("["+ y++ +"]");
            for (Cell cell : row) {
                System.out.print(cell.image());
            }
            System.out.println();
        }
        System.out.println();
    }
}
