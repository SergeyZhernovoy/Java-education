/**
*программа вычисления факториала 
*@author Sergey Zhernovoy
*@since 16/06/2016
*/
package chapter1.loop;

public class Factorial{

private int num;

public Factorial(String num){

	this.num = Integer.valueOf(num);

}

public double calcFactorial(){

	double result = 1;
	for(int index = 1; index <= num; index++){
	    result *=index;	
	}
	return result;

}

public void print() {

	System.out.printf("Factorial %d = %f",num,calcFactorial());

}

public static void main(String[] args){

	Factorial fc;
	if(args.length > 0) {
	  fc = new Factorial(args[0]);	
	}
	else fc = new Factorial("5");
	fc.print();

}

}