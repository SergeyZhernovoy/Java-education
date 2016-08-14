package ru.szhernovoy.model;

/**
 * Created by admin on 14.08.2016.
 */
public class StubInput implements IO{
   /** array save answers for test*/
    private String[] action;
    /**current position in array action */
    private int position =0;

    private String result;

    /**
     * Constructor
     * @param action
     */
    public StubInput(String[] action) {
        this.action = action;
    }
    /**
     * Print question and get input data from user
     * @param question
     * @return
     */
    @Override
    public String ask(String question) {
        System.out.print(question);
        return action[position++];
    }


    @Override
    public void println(Object value) {
        this.result = value.toString();
    }

    @Override
    public String getResult(){
        return this.result;
    }
}
