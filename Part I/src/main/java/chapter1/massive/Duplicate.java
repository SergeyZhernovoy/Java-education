/**
*
*@author Sergey Zhernovoy
*@since 20/06/2016
*/

package chapter1.massive;

public class Duplicate {
	
	public String [] strFull;
	
	public Duplicate(String [] unsort){
		strFull = new String[unsort.length];
		System.arraycopy(unsort,0,strFull,0,unsort.length);
	}
	
	public void DoUniqueArray(){
		
		//delete copy
		int count = deleteCopy();
		//copy in new array
		String []tmp = new String[strFull.length];
		System.arraycopy(strFull,0,tmp,0,strFull.length);
		strFull =  tmp;
	
		
	}
	
	private int deleteCopy(){
	        
		   int count = 0;
		  /* for(int i = 0; i < strFull.length; i++){
		   	   for(int j = strFull.length - 1; j > i;j--){
		   	   	   if(strFull[i].equals(strFull[j])){
		   	   	   	 strFull[j] = null;
		   	   	   }	 
		   	   	   if(strFull[j-1]  == null){
		   	   	 	  strFull[j-1] = strFull[j];
		   	   	 	  strFull[j] = null;
		   	   }
		   	   	 }
		   	   	 
	
		   }*/
	      
	    
	   /* for(String obj : strFull){
	    if(obj != null) {
	    count++;}
	    }*/
	    
	    
	    
	 return count;
}

	

	public void printArray(){

		for(String str : strFull){
		 System.out.print(str + " ");		
		}


}
	
	
	public static void main(String []args){
		String [] unsort = {"as","sa","as","as","as","ki","as","as","as","as","ds","we","az","vf","vf","as","as","ki","as","as","vf","as","as","vf","as","as"};
		
		Duplicate myArr = new Duplicate(unsort);
		System.out.println("Massive with duplicate...\n");
		myArr.printArray();
		System.out.println("\nUniquie massive ...");
		myArr.DoUniqueArray();
		myArr.printArray();
		
	}
	
}
















