/**
*вычисляет значение квадратной функции
*@author Sergey Zhernovoy
*@since 14-06-2016
*/
package chapter1.loop;

public class Square {

 private double a; // a,b,c,x1,x2,step
 private double b;
 private double c;
 private double x1;
 private double x2;
 private double step;

 public Square(double a,double b,double c,double x1,double x2,double step){
 
	this.a = a;
this.b = b;
this.c = c;
this.x1 = x1;
this.x2 = x2;
this.step = step;


}

public double calcFunction(double x){

	return a*x*x+b*x+c;

} 

public void print(){

	double xInit = x1; 
	while(xInit < x2){
	 System.out.println(calcFunction(xInit));
	 xInit += step;
	}
	
	

}

public static void main (String[] args){

	for(int index = 0; index < args.length;index++){
	    Validator.setValue(args[index]);		
	}
	
		
	Square fSquare = new Square(Validator.a,Validator.b,Validator.c,Validator.x1,Validator.x2,Validator.step);
	fSquare.print();

	}

}