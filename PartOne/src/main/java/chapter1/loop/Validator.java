/**
*@author Sergey Zhernovoy
*@since 17-16-2016
*
*/

package chapter1.loop;

class Validator{

public static double a =1;

public static double b =1;

public static double c=1;

public static double x1 =1;

public static double x2 = 3;

public static double step = 1;

public static int index = 0;


public static void setValue(String strValue){

	index++;
	switch(index){

	case 1: 
		a = Integer.valueOf(strValue);
		break;
	case 2:
		b = Integer.valueOf(strValue);
		
		break;
	case 3:
		c = Integer.valueOf(strValue);
		
		break;

	case 4:
		x1 = Integer.valueOf(strValue);
		
		break;

	case 5:
		x2 = Integer.valueOf(strValue);
		
		break;

	case 6:
		step = Integer.valueOf(strValue);
		
		break;

	default :
		break;	
	
	}


}
}
