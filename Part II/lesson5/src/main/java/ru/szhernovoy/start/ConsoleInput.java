/**
*@author Sergey Zernovoy
/*@since 05/07/2016
*
*/

package ru.szhernovoy.start;
import java.util.Scanner;

public class ConsoleInput implements Input {

	private Scanner scanner = new Scanner(System.in);

	public String ask(String question){
		System.out.print(question);
		return scanner.nextLine();
	}

}