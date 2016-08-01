/**
*@author Sergey Zernovoy
/*@since 05/07/2016
*
*/

package ru.szhernovoy.tracker.start;

import ru.szhernovoy.tracker.templates.Input;

public class StubInput implements Input {
	
	private String[] answers;
    private int position = 0;

    public StubInput() {
        this.answers = answers;
    }

    public String ask(String question) {
        return answers[position++];
	}

    @Override
    public int ask(int[] range) {
        return 0;
    }

    /**
     * Refactor. Method set question
     *
     * @param question
     */
    @Override
    public void setQuestion(String question) {

    }

    /**
     * Refactor. Method get question on the screen
     */
    @Override
    public void printQuestion() {

    }
}