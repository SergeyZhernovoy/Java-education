/**
*вычисляет значение квадратной функции
*@author Sergey Zhernovoy
*@since 14-06-2016
*/
package chapter1.loop;

public class Square {

 private double a; // a,b,c
 private double b;
 private double c;
 

 public Square(double a,double b,double c){
 
	this.a = a;
	this.b = b;
	this.c = c;
	
}

public double calcFunction(double x){

	return a*x*x+b*x+c;

} 

public static void main (String[] args){

			
	Square fSquare = new Square(Double.valueOf(args[0]),Double.valueOf(args[1]),Double.valueOf(args[2]));
	
	double x1,x2,step;
	x1 = Double.valueOf(args[3]);
	x2 = Double.valueOf(args[4]);
	step = Double.valueOf(args[5]);
		
	while(x1 < x2){
	 System.out.println(fSquare.calcFunction(x1));
	 x1 += step;
	}

	}

}


