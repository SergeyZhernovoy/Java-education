/**
*@author Sergey Zhernovoy
*@since 13.06.2016
*/

package chapter1.typedata;

public class CalcInit {

	public static void main(String[] args){

	Calculator calc = new Calculator();
	calc.add(1,2);
	System.out.println("add 1 + 2");
	System.out.println(calc);
	calc.sub(3,1);
	System.out.println("sub 3 - 1");
	System.out.println(calc);
	calc.mult(3,2);
	System.out.println("multiplex 3 * 2");
	System.out.println(calc);
	calc.div(9,2);
	System.out.println("div 9 / 2 ");
	System.out.println(calc);

	}


}