/**
*@author Sergey Zhernovoy
*@version 1.0.0
*@since 13-06-2016
*/
package chapter1.condition;

class Point{

   private double x;
   private double y;

   public Point(double x, double y) {
      this.x = x;
      this.y = y;
   }
   
   public double distanceTo(Point point) {
      
	return Math.sqrt((point.x - x) * (point.x - x) + (point.y - y) * (point.y - y));

   }

   public double getX(){

	return x;	
}

   public double getY(){

	return y;	
}


}