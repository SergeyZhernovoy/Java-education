package ru.szhernovoy.calculator.view;

/**interface identifier  input methods
 * Created by admin on 02.08.2016.
 */
public interface Input {

    /**
     * base method.
     * @param question String parametr
     * @return
     */
    String ask(String question);

    /**
     * method check input value in any range and get it if all right.
     * @param question
     * @param range range key's menu
     * @return
     */
    int ask(String question, int[] range);

    /**
     * method check input value in any range and get it if all right.
     * @param question
     * @param range range calculator action
     * @return
     */
    String ask(String question, String[] range);

    /**
     * method check input value in convert to double and get it if all right.
     * @param question
     * @param numeric
     * @return
     */
    String ask(String question, boolean numeric);


}
