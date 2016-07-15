/**
*@author Sergey Zernovoy
/*@since 12/07/2016
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
			throw new MenuOfException("out of range");
		}
		
	}
	
	public String[] ask(String question, String[] rangeAbc, String[] rangeNum){
		
		String toCheck = this.ask(question);
		String[] array = new String[toCheck.length()];
		for(int index = 0; index < toCheck.length(); index++){
			array[index] = String.valueOf(toCheck.charAt(index));
		}
		
		boolean exist = false;
		int right = 0;
		if(array.length ==2){
			for(String value : rangeAbc){
				if(value.equals(array[0])){
				right++;
				break;
				}
			}
				
			for(String value : rangeNum){
				if(value.equals(array[1])){
				right++;
				break;
				}
			}
			exist = right == 2?true:false;
		}
						
		if(exist){
		   return array;
		}
		else{
			throw new MenuOfException("out of range");
		}
		
	}
		
}