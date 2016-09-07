package ru.szhernovoy.view;

/**
 * Created by Sergey on 07.09.2016.
 */
public class TestStep {
    private int [][] Board;
    private final int X = 1;
    private final int Y = 2;
    private final int Z = 0;

    private int [] xy;

    public TestStep(int[][] board) {
        Board = board;
        xy = new int[]{0, 0};

    }

    public int[] getLuckyStep(int symbol){

        if(symbol == X || symbol == Y){






        }
        else{
            xy[0] = 0;
            xy[1] = 0;
        }

        return xy;
    }



}
