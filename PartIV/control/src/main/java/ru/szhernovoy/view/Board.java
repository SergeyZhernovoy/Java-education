package ru.szhernovoy.view;


/**
 * Created by szhernovoy on 20.08.2016.
 */
public class Board {
    private Cell[][] cells;


    public void drawBoard(Cell[][] cells) {
        this.cells = cells;
        this.redraw();
    }

    public void drawCell(int x, int y) {
        System.out.println("***** SELECT ******");
        this.redraw();
    }


    public void congratulate() {
        System.out.println("***** CONGRATULATE ******");
    }

    private void redraw() {
        int  y = 1;
        System.out.print("[\\]");
        for(int index = 0; index < 3; index++){
            System.out.print(String.format("[%s]",index+1));
        }
        System.out.println("");
        for (Cell[] row : cells) {
            System.out.print("["+ y++ +"]");
            for (Cell cell : row) {
                cell.draw();
            }
            System.out.println();
        }
        System.out.println();
    }
}
