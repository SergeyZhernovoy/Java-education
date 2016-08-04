package ru.szhernovoy.calculator.view;

/**
 * Created by szhernovoy on 22.07.2016.
 */
public class MockIO implements IO {

    private String[] answers;
    private StringBuilder out = new StringBuilder();
    private int position = 0;


    public MockIO(String[] answer){
        this.answers = answer;
    }

    @Override
    public void println(Object value) {
        this.out.append(value).append("\n");
    }

    @Override
    public void print(Object value) {
        this.out.append(value).append("\n");
    }


    @Override
    public String ask(String question) {
        return answers[position++];
    }

    @Override
    public int ask(String question, int[] range) {
        return Integer.valueOf(answers[position++]);
    }

    @Override
    public String ask(String question, String[] range) {
        return answers[position++];
    }

    @Override
    public String ask(String question, boolean numeric) {
        return answers[position++];
    }
}
