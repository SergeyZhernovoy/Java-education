/**
*
*@since 24-06-2016
*@author Sergey Zhernovoy
*
*/

package chapter1.finaltest;

public class SubString {

public char[] original;


public boolean contains(String original, String subStr){
	
	char [] sub = subStr.toCharArray();
	this.original = original.toCharArray();
	int count = 0;
	int j = 0;
	for(int i = 0; i < sub.length; i ++){
	   for(; j < original.length; j++){
			if(original[j] == sub[i]){
		           count++;
			   break;
			}
			else{
			count = 0;
			}
		
		}	
	}
	
	return count == sub.length?true:false;	
	 
}


public static void main(Sting[] args){

	boolean compare = false;
	SubString subCompare = new SubString();
	String str = "asdffghjklytyujvbfghsewr";
	String sub = "dsdfew";
	compare = subCompare.contains(str,sub);
	if(compare){
		System.out.printf("This string %s contains %s",str,sub);
	}
	else { 
		System.out.printf("This string %s not contains %s",str,sub);
	     }

	}

}