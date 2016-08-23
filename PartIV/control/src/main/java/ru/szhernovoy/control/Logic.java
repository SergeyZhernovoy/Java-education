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

/*
    @Override
    public boolean shouldBang(int x, int y) {
        final Cell selected = this.cells[x][y];
        return selected.isBomb() && !selected.isSuggestBomb();
    }*/

      public boolean finish() {
        boolean finish = false;
       /* for (Cell[] row : cells) {
            for (Cell cell : row) {
                finish = ((cell.isSuggestBomb() && cell.isBomb()) ||
                        (cell.isEmpty() && !cell.isBomb()));
            }
        }*/
        return finish;
    }

    public boolean control(int[] answer, int orderPlayer){
        return true;
    }

   /* @Override
    public void suggest(int x, int y, boolean bomb) {
        if (bomb) {
            this.cells[x][y].suggectBomb();
        } else {
            this.cells[x][y].suggectEmpty();
        }
    }*/
}
