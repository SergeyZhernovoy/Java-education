package ru.szhernovoy.io;


import ru.szhernovoy.model.Player;

/**
 * Created by szhernovoy on 20.08.2016.
 */
public class Board {
    /**array cells for game */
    private Cell[][] cells;


    /**
     * Setter board
     * @param cells
     */
    public void loadBoard(Cell[][] cells) {
        this.cells = cells;
    }

    /**
     * Draw enter for position.
     */
    public void drawCell() {
        System.out.println("*********** SELECT **************");
        this.redraw();
    }

    /**
     * Draw start screen.
     */
    public void drawScreenOnInit() {
        System.out.println("*********************************");
        System.out.println("***** NEW GAME TIC-TAC-TOE ******");
        System.out.println("*********************************");
        System.out.println("*********************************");
        System.out.println("*********************************");
        System.out.println("*                               *");
    }


    /**
     * Return max size board
     * @return
     */
    public int[] rangeBoard(){
        int[] range = new int[this.cells.length];
        for (int index = 0; index < this.cells.length;index++){
            range[index] = index+1;
        }
        return range;
    }


    /**
     * Draw screen when game over
     * @param player
     * @param resultGame
     */
    public void endGame(Player[] player, int resultGame) {

        if(resultGame == -1){
            System.out.println("**********************************");
            System.out.println("********** NO WINS **********");
        }
        else{
            System.out.println("**********************************");
            System.out.println("********** CONGRATULATE **********");
            System.out.println(String.format("********** WIN - %s************",player[resultGame].whoAreYou()));
        }
        this.redraw();
    }

    /**
     * Method draw game board
     */
    private void redraw() {
        int  y = 1;
        System.out.print("\t[\\]");

        for(int index = 0; index < this.cells.length; index++){
            System.out.print(String.format("\t[%s]",index+1));
        }
        System.out.println("");
        for (Cell[] row : this.cells) {
            System.out.print("\t["+ y++ +"]");
            for (Cell cell : row) {
                System.out.print("\t"+cell.image());
            }
            System.out.println();
        }
        System.out.println();
    }
}
