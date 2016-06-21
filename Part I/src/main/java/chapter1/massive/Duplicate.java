/**
*
*@author Sergey Zhernovoy
*@since 20/06/2016
*/

package chapter1.massive;

public class Duplicate {
	
	public String [] strFull;
	
	public Duplicate(String [] unsort){
		strFull = unsort;
	}
	
	public String[] getUniqueArray(){
		
		//delete copy
		int count = deleteCopy();
		//copy in new array
		String []tmp = new String[count];
		//System.arraycopy(strFull,0,tmp,0,count);
		return tmp;
	
		
	}
	
	private int deleteCopy(){
	        
		   int count = 0;
		   for(int i = 0; i < strFull.length; i++){
		   	  /* if(strFull[i] == null){
		   	   	   break;
		   	   }
		   	   else {
		   	   	   count++;
		   	   }
		   	   for(int j = strFull.length - 1 - i; j > i;j--){
		   	   	   if(strFull[i].equals(strFull[j]){
		   	   	   	 strFull[j] = strFull[strFull.length - 1 - i];
		   	   	   	 strFull[strFull.length - 1 - i] = null;
		   	   	   
		   	   }*/
		   	   
		   	   
	
		
	}
	return count;

}


	
	
	public static void main(String []args){
		/*String [] unsort = {"as","sa","as","as","as","ki","as","as","as","as","ds","we","az","vf","vf","as","as","ki","as","as","vf","as","as","vf","as","as"};
		for(String str : unsort){
		 System.out.print(str + " ");		
		}*/
		//Duplicate myArr = new myArr(unsort);
	}
	
}