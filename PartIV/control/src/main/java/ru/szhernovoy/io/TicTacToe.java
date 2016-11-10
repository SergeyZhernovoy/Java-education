package ru.szhernovoy.io;

/**
 * Created by Sergey on 17.09.2016.
 */

public class TicTacToe {


    private final int[][] values; // массив содержит 1 и 2 или 0 ... 1 = X, 2 = O

    public TicTacToe(final int[][] values) {
        this.values = values;
    }

    public boolean hasWinner() {

        int[] agrregateLineAndColumn = {0, 0, 0, 0}; // значения цифр- 1 (1 по столбцу) 2 (0 по столбцу) 3 (1 по строке) 4 (0 по строке)
        int[] aggregateDiagonal = {0, 0, 0, 0}; // значения цифр 1 (1 значение  диагональ слева направо) 2 (0 диагональ слева направо )
        //3 (1 диагональ справа налево) 4 (0 диагональ справа налево)
        int valueMinus = this.values.length - 1;
        boolean winner = false;
        for (int valueX = 0; valueX < this.values.length; valueX++, valueMinus--) { // двигаемся сверху вниз слева направо

            agrregateLineAndColumn[0] = agrregateLineAndColumn[1] = agrregateLineAndColumn[2] = agrregateLineAndColumn[3] = 0; //обнуляем для каждой шага смещения

            accumalateValue(this.values[valueX][valueX], aggregateDiagonal, 0); // складываем значения по диагонали слева направо (0 - слева направо)
            accumalateValue(this.values[valueMinus][valueMinus], aggregateDiagonal, 1); // складываем значения по диагонали справа налево

            for (int valueY = 0; valueY < this.values.length; valueY++) {
                accumalateValue(this.values[valueX][valueY], agrregateLineAndColumn, 1); //складываем по строке
                accumalateValue(this.values[valueY][valueX], agrregateLineAndColumn, 2); // складываем по колонке
            }
            winner = checkOnWin(agrregateLineAndColumn[0], agrregateLineAndColumn[2], agrregateLineAndColumn[1], agrregateLineAndColumn[3]); // проверяем суммы по столбцам или строкам
            if (!winner) {
                winner = checkOnWin(aggregateDiagonal[0], aggregateDiagonal[2], aggregateDiagonal[1], aggregateDiagonal[3]); // проверяем по диагоналям
            }

            if (winner) {
                break;
            }
        }

        return winner;

    }


    public void accumalateValue(int valueCell, int[] value, int type) { // type означает какую часть массив agrregateLineAndColumn / aggregateDiagonal
        // будем брать

        if (type == 0) {
            if (currentValueField(valueCell) == 1) {
                value[0] = value[0] + 1;
            }

            if (currentValueField(valueCell) == 2) {
                value[1] = value[1] + 2;
            }
        } else {

            if (currentValueField(valueCell) == 1) {
                value[2] = value[2] + 1;
            }

            if (currentValueField(valueCell) == 2) {
                value[3] = value[3] + 2;
            }
        }
    }


    /**
     * Смысл проверки следующий : сумма в ячейки по модулю длины будет равна нулю , к примеру  игровое поле равно 3 на 3
     * значит что бы выиграть должны по строке быть 1 1 1 или 2 2 2   суммы в агрегирующем массиве 3 и 6 длина массива 3
     * остаток от деления 3 /3  = 0 6 / 3 = 0 значит в любом случае это выигрыш.
     * это работает для любого квадратного массива
     * @param param1
     * @param param2
     * @param param3
     * @param param4
     * @return
     */
    public boolean checkOnWin(int param1, int param2, int param3, int param4) {
        boolean winner = false;

        if (param1 % this.values.length == 0 && param1 != 0 || param2 % this.values.length == 0 && param2 != 0) {
            winner = true;
        }

        if (param3 % this.values.length == 0 && param3 != 0 || param4 % this.values.length == 0 && param4 != 0) {
            winner = true;
        }
        return winner;
    }

    private int currentValueField(int valueCell) {

        return valueCell == 0 ? 0 : valueCell == 1 ? 1 : 2;

    }
}
