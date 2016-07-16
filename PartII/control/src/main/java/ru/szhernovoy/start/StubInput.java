/**
*@author Sergey Zernovoy
/*@since 05/07/2016
*
*/

package ru.szhernovoy.start;

public class StubInput implements Input {
	
	private String[] answers;
    private int position = 0;
	private int menuposition = 0;
	private int coord = 0;
	private String[] abc;
	private String [] num;
	private int[] menu = new int[]{0,1};

    public StubInput(String[] answers, String[] abc, String [] num) {
        this.answers = answers;
		this.abc = abc;
		this.num = num;
    }

    public String ask(String question) {
		System.out.println("1");
		System.out.println(answers[position]);
        return answers[position++];
	}
	
	  public String[] ask(String question,String[] q, String[] w) {
		System.out.println("3");
		String[] pos = new String[2];
		pos[0] = this.abc[coord];
		pos[1] = this.num[coord++];
		System.out.print(pos[0] + pos[1] + "\n");
		return pos;
	}
	
	public int ask(String question, int[] range){
		System.out.println("2");
		System.out.println(this.menu[menuposition]);
		return this.menu[menuposition++];
	}
	
}