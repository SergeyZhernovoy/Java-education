package chapter1.massive;

public class Rotate {
	
	public static void main(String[] args){
		
		final int SIZE = 4; //razmer
		int[][] kvadrat = {
			{1,2,3,4},
			{2,3,4,5},
			{6,7,8,9},
			{2,5,6,9}
			};
		System.out.println("massive"); 
		for(int i = 0; i < SIZE; i++){
                    System.out.print("\n");  
	            for(int j = 0; j < SIZE; j++){
			System.out.print(kvadrat[i][j]+" ");
			}
		}  
					
		

		for(int i = 0;i < SIZE/2; i++){
		    for(int j = i ; j< SIZE - 1 - i; j++){
				int temp = kvadrat[i][j];
				kvadrat[i][j] 	= kvadrat[j][SIZE-1-i];
				kvadrat[j][SIZE-1-i] = kvadrat[SIZE-1-i][SIZE-1-j];
                		kvadrat[SIZE-1-i][SIZE-1-j] = kvadrat[SIZE-1-j][i];
                		kvadrat[SIZE-1-j][i]     = temp;
			}
		}

		System.out.println("\nrotate massive"); 
		for(int i = 0; i < SIZE; i++){
                    System.out.print("\n");  
	            for(int j = 0; j < SIZE; j++){
			System.out.print(kvadrat[i][j]+" ");
			}
		}  


	}
}