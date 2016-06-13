/**
*  
* вычисляем максимальную сторону треугольника
*@author Sergey Zhernovoy
*@version 1.0.0
*@since 13-06-2016
*/
package chapter1.condition;

public class TriangleCalc {
   
   private double ab;
   private double ac; 
   private double bc;	


   public TriangleCalc(Point a, Point b, Point c) {
     
      ab = a.distanceTo(b);
      ac = a.distanceTo(c);
      bc = b.distanceTo(c); 

   }

   private double maxSide() {
      
    double result = 0;	    	
	
    if(ab == 0 || ac == 0 || bc == 0 ){
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
	

  public static void main (String[] args){
	
	Point a = new Point(1,1);
	Point b = new Point(2,1);
	Point c = new Point(5,11);
	TriangleCalc triangle = new TriangleCalc(a,b,c);
	triangle.sayMaxSide();


	
 }

}
