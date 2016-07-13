package chapter1.massive;

public class Rotate {
	
	private final int SIZE = 4; //razmer
	private int[][] kvadrat;
	public Rotate(int [][] src){
	
		kvadrat = new int[SIZE][SIZE];
		System.arraycopy(src,0,kvadrat,0,src.length);
		
	}
	
	public void printArray(){
		
			for(int i = 0; i < SIZE; i++){
                    System.out.print("\n");  
	            for(int j = 0; j < SIZE; j++){
			System.out.print(kvadrat[i][j]+" ");
			}
		}  
	
		
	}
	
	public void rotateArray(){
		
		for(int i = 0;i < SIZE/2; i++){
		    for(int j = i ; j< SIZE - 1 - i; j++){
				int temp = kvadrat[i][j];
				kvadrat[i][j] 	= kvadrat[j][SIZE-1-i];
				kvadrat[j][SIZE-1-i] = kvadrat[SIZE-1-i][SIZE-1-j];
                		kvadrat[SIZE-1-i][SIZE-1-j] = kvadrat[SIZE-1-j][i];
                		kvadrat[SIZE-1-j][i]     = temp;
			}
		}

	
		
	}
	
public int[][] getMassive(){

	return kvadrat;

}


	
	public static void main(String[] args){
		
		
		int[][] kvadrat = {
			{1,2,3,4},
			{2,3,4,5},
			{6,7,8,9},
			{2,5,6,9}
			};
			
		Rotate microArray = new Rotate(kvadrat);
		System.out.println("massive"); 
	    microArray.printArray();
	    System.out.println("\nrotate massive"); 
	    microArray.rotateArray();
	    microArray.printArray();
	
	}
}