package ru.szhernovoy.io;

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
        int resultLineX = checkLine(0, 0, 0, 1);
        int resultColumnX = checkColumn(0, 0, 0, 1);
        int resultLeftDiagX = checkDiagLR(0, 0, 0, 1);
        int resultRightDiagX = checkDiagRL(this.values.length-1, this.values.length-1, 0, 1);

        int resultLineO = checkLine(0, 0, 0, 2);
        int resultColumnO = checkColumn(0, 0, 0, 2);
        int resultLeftDiagO = checkDiagLR(0, 0, 0, 2);
        int resultRightDiagO = checkDiagRL(this.values.length-1, this.values.length-1, 0, 2);


        if (resultLineX!=0 && resultLineX %this.values.length == 0 || resultColumnX!=0 && resultColumnX %this.values.length == 0 || resultLeftDiagX!=0 &&resultLeftDiagX %this.values.length == 0 || resultRightDiagX!=0 &&resultRightDiagX %this.values.length == 0){
            result = true;
        }

        if (resultLineO!=0 && resultLineO %this.values.length == 0 || resultColumnO!=0 && resultColumnO %this.values.length == 0 || resultLeftDiagO!=0 &&resultLeftDiagO %this.values.length == 0 || resultRightDiagO!=0 &&resultRightDiagO %this.values.length == 0){
            result = true;
        }

        return result;
    }


    public int checkLine(int x, int y, int result, int typeSymbol){

        int xNext = x, yNext = y;

        if (result!=0 && result % this.values.length == 0) {
            return result;
        }

        if (this.values[x][y] == typeSymbol) {
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
                result = checkLine(xNext, yNext, result, typeSymbol);
            }
            return result;
    }


    public int checkColumn(int x, int y, int result, int typeSymbol){

        int xNext = x, yNext = y;

        if (result!=0 && result % this.values.length == 0) {
            return result;
        }

        if (this.values[x][y] == typeSymbol) {
            if (yNext == this.values.length) {
                return result;
            }
            result = result + this.values[x][y];
            xNext++;
            if (xNext == this.values.length) {
                yNext++;
                xNext = 0;
                if (result != 0 && result % this.values.length == 0) {
                    return result;
                }
                result = 0;
            }
            result = checkColumn(xNext, yNext, result, typeSymbol);
        }
        return result;
    }

    public int checkDiagLR(int x, int y, int result, int typeSymbol){

        int xNext = x, yNext = y;

        if (result!=0 && result % this.values.length == 0) {
            return result;
        }

        if (this.values[x][y] == typeSymbol) {

            if (yNext == this.values.length) {
                return result;
            }
            result = result + this.values[x][y];
            xNext++;
            yNext++;
            result = checkDiagLR(xNext, yNext, result, typeSymbol);
        }
        return result;
    }

    public int checkDiagRL(int x, int y, int result, int typeSymbol){

        int xNext = x, yNext = y;

        if (result!=0 && result % this.values.length == 0) {
            return result;
        }

        if (this.values[x][y] == typeSymbol) {
            if (yNext == -1) {
                return result;
            }
            result = result + this.values[x][y];
            xNext--;
            yNext--;
            result = checkDiagRL(xNext, yNext, result, typeSymbol);
        }
        return result;
    }


}
