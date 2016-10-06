package ru.szhernovoy.view;

/**
 * Created by Sergey on 17.09.2016.
 */

public class TicTacToeReccurcy {


    private final int[][] values; // массив содержит 1 и 2 или 0 ... 1 = X, 2 = O

    public TicTacToeReccurcy(final int[][] values) {
        this.values = values;
    }

    public boolean hasWinner() {

        boolean result = false;
        int resultLineX = check(0, 0, 0, 1, 1);
        int resultColumnX = check(0, 0, 0, 1, 2);
        int resultLeftDiagX = check(0, 0, 0, 1, 3);
        int resultRightDiagX = check(this.values.length-1, this.values.length-1, 0, 1, 4);

        int resultLineO = check(0, 0, 0, 2, 1);
        int resultColumnO = check(0, 0, 0, 2, 2);
        int resultLeftDiagO = check(0, 0, 0, 2, 3);
        int resultRightDiagO = check(this.values.length-1, this.values.length-1, 0, 2, 4);


        if (resultLineX!=0 && resultLineX %this.values.length == 0 || resultColumnX!=0 && resultColumnX %this.values.length == 0 || resultLeftDiagX!=0 &&resultLeftDiagX %this.values.length == 0 || resultRightDiagX!=0 &&resultRightDiagX %this.values.length == 0){
            result = true;
        }

        if (resultLineO!=0 && resultLineO %this.values.length == 0 || resultColumnO!=0 && resultColumnO %this.values.length == 0 || resultLeftDiagO!=0 &&resultLeftDiagO %this.values.length == 0 || resultRightDiagO!=0 &&resultRightDiagO %this.values.length == 0){
            result = true;
        }

        return result;
    }

    /**
     * @param x          position in array by x
     * @param y          position in array by y
     * @param result     aggregate result
     * @param typeSymbol 1 - X 2 - O
     * @param side       1 - line 2 -column 3 - left toi right diagonal 4 - right to left
     * @return
     */
    public int check(int x, int y, int result, int typeSymbol, int side) {

        int xNext = x, yNext = y;

        if (result!=0 && result % this.values.length == 0) {
            return result;
        }

        if (this.values[x][y] == typeSymbol) {
            if (side == 1) {
                if (xNext == this.values.length) {
                    return result;
                }
                result = result + this.values[x][y];
                yNext++;
                if (yNext == this.values.length) {
                    xNext++;
                    yNext = 0;
                    if (result!=0 && result % this.values.length == 0) {
                        return result;
                    }
                    result = 0;
                }
                result = check(xNext, yNext, result, typeSymbol, side);
            }

            if (side == 2) {

                if (yNext == this.values.length) {
                    return result;
                }
                result = result + this.values[x][y];
                xNext++;
                if (xNext == this.values.length) {
                    yNext++;
                    xNext = 0;
                    if (result!=0 && result % this.values.length == 0) {
                        return result;
                    }
                    result = 0;
                }
                result = check(xNext, yNext, result, typeSymbol, side);
            }

            if (side == 3) {

                if (yNext == this.values.length) {
                    return result;
                }
                result = result + this.values[x][y];
                xNext++;
                yNext++;
                result = check(xNext, yNext, result, typeSymbol, side);
            }

            if (side == 4) {
                if (yNext == -1) {
                    return result;
                }
                result = result + this.values[x][y];
                xNext--;
                yNext--;
                result = check(xNext, yNext, result, typeSymbol, side);
            }
        }
        return result;
    }
}
