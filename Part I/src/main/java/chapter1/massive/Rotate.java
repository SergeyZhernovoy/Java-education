/**
*поворот матрицы по часовой стрелке на 90 градусов
*@author Sergey Zhernovoy
*/

package chapter1.massive;

public class Rotate{
	
	public static void main(String[] args){
		
		final int SIZE = 4; //razmer
		int[SIZE][SIZE] kvadrat = new int[SIZE][SIZE] {{1,2,3,4},{2,3,4,5},{6,7,8,9},{2,5,6,9}};
		
		/*
		1 2 3 4
		2 3 4 5 
		6 7 8 9
		2 5 6 9 
		i = str 
		j - kol 
		
		a00 = a03
		a01 = a13
		a02 = a23
		a03 = a33
		
		a10 = a02
		a11 = a12
		a12 = a22
		a13 = a32
		
		a20 = a01
		a21 = a11
		a22 = a21
		a23 = a31
		
		a30 = a00
		a31 = a10
		a32 = a20
		a33 = a30
		*/
		
		for(int i = 0;i < SIZE/2; i++){
		    for{int j = i ; j< SIZE - 1 - i; j++){
			
				int temp = kvadrat[i][j];
				kvadrat[i][j] 	= kvadrat[j][SIZE-1-i];
				kvadrat[j][SIZE-1-i] = kvadrat[SIZE-1-i][SIZE-1-j];
                		kvadrat[SIZE-1-i][SIZE-1-j] = kvadrat[SIZE-1-j][i];
                		kvadrat[SIZE-1-j][i]     = tmp;
				
				
			}
			
		}	
		

	
	
	}
}