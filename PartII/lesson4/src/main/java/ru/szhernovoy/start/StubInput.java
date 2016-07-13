/**
*@author Sergey Zernovoy
/*@since 05/07/2016
*
*/

package ru.szhernovoy.start;

public class StubInput implements Input {
	
	private String[] answers;
    private int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    public String ask(String question) {
        return answers[position++];
	}
}