package ru.szhernovoy.calculator.view;

/**
 * Created by szhernovoy on 22.07.2016.
 */
public class MockIO implements IO {

    /**value storage answers for menu and calculator operand */
    private String[] answers;
    /**value save all object for print */
    private StringBuilder out = new StringBuilder();
    /**number position in array */
    private int position = 0;

    /** Constructor. Set array answer.
     *
     * @param answer
     */
    public MockIO(String[] answer){
        this.answers = answer;
    }

    /**
     * Method add value in StringBuilder
     * @param value
     */
    @Override
    public void println(Object value) {
        this.out.append(value).append("\n");
    }

    /**
     * * Method add value in StringBuilder with cange line
     * @param value
     */
    @Override
    public void print(Object value) {
        this.out.append(value).append("\n");
    }

    /**
     * base method.
     * @param question String parametr
     * @return
     */
    @Override
    public String ask(String question) {
        return answers[position++];
    }

    /**
     * method check input value in any range and get it if all right.
     * @param question
     * @param range range key's menu
     * @return
     */
    @Override
    public int ask(String question, int[] range) {
        return Integer.valueOf(answers[position++]);
    }

    /**
     * method check input value in any range and get it if all right.
     * @param question
     * @param range range calculator action
     * @return
     */
    @Override
    public String ask(String question, String[] range) {
        return answers[position++];
    }

    /**
     * method check input value in convert to double and get it if all right.
     * @param question
     * @param numeric
     * @return
     */
    @Override
    public String ask(String question, boolean numeric) {
        return answers[position++];
    }
}
