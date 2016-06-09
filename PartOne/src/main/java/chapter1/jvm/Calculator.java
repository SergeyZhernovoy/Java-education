/**
*@author Sergey Zhernovoy
*@since 09.06.2016
*/

package chapter1.jvm;
public class Calculator {

	private String result;

	public static void main(String[] args){
		Calculator calc = new Calculator("Hello world !!!");
		System.out.println(calc.sayResult());
	}

	public Calculator (String str) {
		this.result = str;
		
	}


	public String sayResult() {
		return result;	
	}


}