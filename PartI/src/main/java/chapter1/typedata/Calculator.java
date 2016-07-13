/**
*@author Sergey Zhernovoy
*@since 13.06.2016
*/

package chapter1.typedata;

public class Calculator {

	private double result;

	/**
	* Этот метод возвращает результат сложения двух чисел
	*@param addNumber1
	*@param addNumber2
	*/
	public void add(double addNumber1,double addNumber2){
		result = addNumber1 + addNumber2;
	}	
	/**
	* Этот метод возвращает результат вычитания двух чисел
	*@param subNumber1
	*@param subNumber2
	*/
	public void sub(double subNumber1,double subNumber2){
		result = subNumber1 - subNumber2;
	}	
	/**
	* Этот метод возвращает результат умножения двух чисел
	*@param mulNumber1
	*@param mulNumber2
	*/
	public void mult(double mulNumber1,double mulNumber2){
		result = mulNumber1 * mulNumber2;
	}	
	/**
	* Этот метод возвращает результат деления двух чисел
	*@param divNumber1
	*@param divNumber2
	*/
	public void div(double divNumber1,double divNumber2){

		if(divNumber2 != 0){
		result = divNumber1 / divNumber2;}
		else result = 0;
	}	
	
	@Override
	public String toString() {
		return "Result calculation is - " + result;	
	}

	public double getResult(){
		return result;
	}


}