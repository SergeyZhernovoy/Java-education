/**
*@author Sergey Zernovoy
/*@since 12/07/2016
*
*/

package ru.szhernovoy.io;
import ru.szhernovoy.models.MenuOfException;

import java.util.Scanner;

public class ConsoleInput implements Input {

	private Scanner scanner = new Scanner(System.in);

	public String ask(String question){
		System.out.print(question);
		return scanner.nextLine();
	}
	
	public int ask(String question, int[] range){
		
		int key = Integer.valueOf(this.ask(question));
		boolean exist = false;
		
		for(int value : range){
			if(value == key){
				exist = true;
				break;
			}
		}
		if(exist){
		   return key;
		}
		else{
			throw new MenuOfException("out of menu range");
		}
		
	}
}