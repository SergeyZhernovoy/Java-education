package ru.szhernovoy;

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
    public String read() {
        return answers[position++];
    }

    public String getOut(){
        return this.out.toString();
    }
}
