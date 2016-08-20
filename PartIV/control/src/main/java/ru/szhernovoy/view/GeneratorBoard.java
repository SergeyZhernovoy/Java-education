package ru.szhernovoy.view;


/**
 * Created by szhernovoy on 20.08.2016.
 */
public class GeneratorBoard {

   private final int SIZE;

    public GeneratorBoard(int size){
        this.SIZE = size;
    }

    public GeneratorBoard(){
        this(3);
    }

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
