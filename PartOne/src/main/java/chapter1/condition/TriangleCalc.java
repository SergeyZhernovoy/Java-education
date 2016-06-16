/**
*  
* вычисляем максимальную сторону треугольника
*@author Sergey Zhernovoy
*@version 1.0.0
*@since 13-06-2016
*/
package chapter1.condition;

public class TriangleCalc {
   
   private Point a;
   private Point b; 
   private Point c;	


   public TriangleCalc(Point a, Point b, Point c) {
     	this.a = a;
 	this.b = b;
	this.c = c;
      

   }

   public double maxSide() {
      
    double result = 0;	    	
	
   double   ab = a.distanceTo(b);
   double   ac = a.distanceTo(c);
   double   bc = b.distanceTo(c); 

    if(!isTriangle(ab,ac,bc)){
      System.out.println("Error - not available create triangle");
    }	
    else {

		result  = max(ab, ac);
		result  = max(result,bc);

	}
	
     return result;
   }

   private double max(double first, double second){

	return first > second ? first : second;	

}	


   public void sayMaxSide(){
	System.out.println("Area max side - " + maxSide());
   }
	

 private boolean isTriangle(double distance1,double distance2, double distance3 ){

	boolean itTriangle = true;
	if(a.getX() == b.getX() && a.getX() == c.getX()){
	  itTriangle = false;}
	if(a.getY() == b.getY() && a.getY() == c.getY()){
	  itTriangle = false;}
	if(distance1  == 0 || distance2 == 0 ||  distance3 == 0){
	  itTriangle = false;}
	return itTriangle;

}

  public static void main (String[] args){
	
	Point a = new Point(1,1);
	Point b = new Point(2,1);
	Point c = new Point(5,11);
	TriangleCalc triangle = new TriangleCalc(a,b,c);
	triangle.sayMaxSide();


	
 }

}
