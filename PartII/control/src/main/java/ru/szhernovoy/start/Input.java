/**
*@author Sergey Zernovoy
/*@since 12/07/2016
*
*/

package ru.szhernovoy.start;

public interface Input {
	
	String ask(String question);
	
	int ask(String question, int[] range);
	
	String[] ask(String question, String[] rangeAbc,String[] rangeNum);
	
}