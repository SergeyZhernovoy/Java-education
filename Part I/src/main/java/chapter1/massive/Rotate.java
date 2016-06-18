/**
*поворот матрицы по часовой стрелке на 90 градусов
*@author Sergey Zhernovoy
*/

package chapter1.massive;

public class Rotate{
	
	public static void main(String[] args){
		
		final int RAZMER_MATRICA = 4; //razmer
		int[RAZMER_MATRICA][RAZMER_MATRICA] kvadrat = new int[RAZMER_MATRICA][RAZMER_MATRICA] {{1,2,3,4},{2,3,4,5},{6,7,8,9},{2,5,6,9}};
		
		/*
		1 2 3 4
		2 3 4 5 
		6 7 8 9
		2 5 6 9 
		i = str 
		j - kol 
		
		a11 = a14
		a12 = a24
		a13 = a34
		a14 = a44
		
		a21 = a13
		a22 = a23
		a23 = a33
		a24 = a43
		
		a31 = a12
		a32 = a22
		a33 = a32
		a34 = a42
		
		a41 = a11
		a42 = a12
		a43 = a13
		a44 = a14
		*/
		
		for(int i = 0;i < RAZMER_MATRICA; i++){
			for{int j = 0 ; j < RAZMER_MATRICA; j++){
				int temp = kvadrat[j][RAZMER_MATRICA - 1-j]
				kvadrat[][] = kvadrat[][]
				
				
			}
			
		}	
		
		
		
		
	
	
	
	
	
	}
}