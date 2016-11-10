package ru.szhernovoy.io;


/**
 * Created by szhernovoy on 20.08.2016.
 */
public class GeneratorBoard {

    /**value storage size board */
   private final int SIZE;

    /**
     * Constructor. Let it set size board
     * @param size
     */
    public GeneratorBoard(int size){
        this.SIZE = size;
    }

    /**
     * Default constructor.
     */
    public GeneratorBoard(){
        this(3);
    }

    /**
     * Generate matrix and filling his cell
     * @return
     */
    public Cell[][] generate() {
        Cell[][] cells = new Cell[this.SIZE][this.SIZE];
        for (int x = 0; x < this.SIZE; x++){
            for(int y = 0; y < this.SIZE;y++){
                cells[x][y] = new Cell();
            }
        }
        return cells;
    }
}
