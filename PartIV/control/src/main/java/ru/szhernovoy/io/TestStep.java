package ru.szhernovoy.io;

/**
 * Created by Sergey on 07.09.2016.
 */
public class TestStep {
    private int [][] Board;
    private final int X = 1;
    private final int Y = 2;
    private final int Z = 0;

    public TestStep(final int[][] board) {
        Board = board;
    }

    public int[] getLuckyStep(int symbol){
        int [] xyLine = new int[]{-1, -1};
        int [] xyColumne = new int[]{-1, -1};
        int [] xyDiagonal = new int[]{-1, -1};
        int [] xyDiagonalL = new int[]{-1, -1};
        int [] xy = new int[]{-1, -1};


        int accumaleteLine = 0;
        int accumaleteColumne = 0;
        int accumaleteDiagonal = 0;
        int accumaleteDiagonalL = 0;

        //up - down ; left - rigth
        for(int i = 0, k =0, v = this.Board.length -1 ; i < this.Board.length;i++, k++,v--){

            /**
             * Calculate diagonal left to right
             */

            if(this.Board[i][k] == symbol){
                accumaleteDiagonal++;
            }
            else{
                xyDiagonal[0] = i;
                xyDiagonal[1] = k;
            }

            /**
             * Calculate diagonal right to left
             */
            if(this.Board[i][v] == symbol){
                accumaleteDiagonalL++;
            }
            else{
                xyDiagonalL[0] = i;
                xyDiagonalL[1] = v;
            }


            for(int j = 0; j < this.Board.length;j++){
                /**
                 * Calculate line
                  */
                if(this.Board[i][j] == symbol){
                    accumaleteLine++;
                }
                else{
                    xyLine[0] = i;
                    xyLine[1] = j;
                }

                /**
                 * Calculate column
                 */
                if(this.Board[j][i] == symbol){
                    accumaleteColumne++;
                }
                else{
                    xyColumne[0] = j;
                    xyColumne[1] = i;
                }
            }

            if(accumaleteLine == 2  ){
               xy = xyLine;
               break;
            }
            else{
                xyLine[0] = -1;
                xyLine[1] = -1;
                accumaleteLine = 0;
            }

            if(accumaleteColumne == 2  ){
                xy = xyColumne;
                break;
            }
            else{
                xyColumne[0] = -1;
                xyColumne[1] = -1;
                accumaleteColumne = 0;
            }
        }

        if(xy[0] == -1 && xy[1] ==-1 ){
            if(accumaleteDiagonal == 2  ){
                xy = xyDiagonal;
            }

            if(accumaleteDiagonalL == 2  ){
                xy = xyDiagonalL;
            }
        }

        return xy;
    }



}
