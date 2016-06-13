/**
* строим треугольник 
* вычисляем его площадь по методу трёх сторон
*@author Sergey Zhernovoy
*@version 1.0.0
*@since 13-06-2016
*/
package chapter1.condition;

public class Triangle {
   
   private Point a;
   private Point b;
   private Point c;

   public Triangle(Point a, Point b, Point c) {
      this.a = a;
      this.b = b;
      this.c = c;
   }

   private double area() {
      //calculate the triangle area
    double ab = a.distanceTo(b);
    double ac = a.distanceTo(c);
    double bc = b.distanceTo(c); 
    double result = 0;	    	
	
    if(ab == 0 || ac == 0 || bc == 0 ){
      System.out.println("Error - not available create triangle");
    }	
    else {

	double perimetrS = (ab + bc + ac) /2;
	result = Math.sqrt(perimetrS * (perimetrS - ab) * (perimetrS - bc) * (perimetrS - ac)); 

	}
	
     return result;
   }

   public void sayArea(){
	System.out.println("Area triangle - " + area());
   }
	

  public static void main (String[] args){
	Point a = new Point(1,1);
	Point b = new Point(2,1);
	Point c = new Point(5,11);
	Triangle triangle = new Triangle(a,b,c);
	triangle.sayArea();


	
 }

}
