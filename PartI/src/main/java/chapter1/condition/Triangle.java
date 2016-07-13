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

   public double area() {
      //calculate the triangle area
    double ab = a.distanceTo(b);
    double ac = a.distanceTo(c);
    double bc = b.distanceTo(c); 
    double result = 0;	    	
	
    if(!isTriangle(ab,ac,bc)){
      System.out.println("Error - not available create triangle");
    }	
    else {

	double perimetrS = (ab + bc + ac) /2;
	result = Math.sqrt(perimetrS * (perimetrS - ab) * (perimetrS - bc) * (perimetrS - ac)); 

	}
	
     return result;
   }

   public void sayArea(){
	System.out.printf("Area triangle - %f",area());
   }
	
   private boolean isTriangle(double distance1,double distance2, double distance3 ){

	boolean itTriangle = true;
	if(a.getX() == b.getX() && a.getX() == c.getX()){
	  itTriangle = false;}
	if(a.getY() == b.getY() && a.getY() == c.getY()){
	  itTriangle = false;	
          }
	if(distance1  == 0 || distance2 == 0 ||  distance3 == 0){
	  itTriangle = false;	
          }
	return itTriangle;


}



  public static void main (String[] args){
	Point a = new Point(0,1);
	Point b = new Point(4,3);
	Point c = new Point(5,8);
	Triangle triangle = new Triangle(a,b,c);
	triangle.sayArea();


	
 }

}
