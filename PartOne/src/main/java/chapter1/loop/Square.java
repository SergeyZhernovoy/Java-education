/**
*вычисляет значение квадратной функции
*@author Sergey Zhernovoy
*@since 14-06-2016
*/
package chapter1.loop;

public class Square {

 private double [] initial; // a,b,c,x1,x2,step

 public Square(String [] args){
 
	initial = new double[args.length];

	for(int index = 0; index < args.length; index++){
	    initial[index] = Double.valueOf(args[index]);	
	}	


}

public double calcFunction(double x){

	double result = 0;
	if(initial.length  == 6){
	   result = initial[0] * x * x + initial[1]*x + initial[2];  
  	}

	return result;

} 

public void print(){

	if(initial.length  == 6){
	double x1 = initial[3];  
	double x2 = initial[4];     
	while(x1 < x2){
	 System.out.println(calcFunction(x1));
	 x1 += initial[5];
	}
	}
	else System.out.println("Nothing to print...");

}

public static void main (String[] args){
		
	Square fSquare = new Square(args);
	fSquare.print();

	}

}