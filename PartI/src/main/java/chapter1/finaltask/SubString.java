/**
*
*@since 24-06-2016
*@author Sergey Zhernovoy
*
*/

package chapter1.finaltask;

public class SubString {

public char[] original;


public boolean contains(String source, String subStr){
	
	char [] sub = subStr.toCharArray();
	original = source.toCharArray();
	int count = 0;
	int j = 0;
	for(int i = 0; i < original.length; i ++){
	   if(count == sub.length){
	   	   break;
	   }
	   if(j < sub.length )
	   {
			if(original[i] == sub[j]){
		       count++;
			   j++;
		  		   
			}
			else{
			count = 0;
			j = 0;
			}
			
		}	
	}
	
	return count == sub.length?true:false;	
	 
}


public static void main(String[] args){

	boolean compare = false;
	SubString subCompare = new SubString();
	String str = "asdsdfds";
	String sub = "ds";
	compare = subCompare.contains(str,sub);
	if(compare){
		System.out.printf("This string %s contains %s",str,sub);
	}
	else { 
		System.out.printf("This string %s not contains %s",str,sub);
	     }

	}

}