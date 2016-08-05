package ru.szhernovoy.calculator.view;

/**Class print value
 * Created by szhernovoy on 04.08.2016.
 */
public interface Output {
    /**
     * print value with change line.
     * @param value
     */
    void println(Object value);

    /**
     * print method.
     * @param value
     */
    void print(Object value);
}
