/**
*Пузырьковая сортировка
*@author
*@since 
*/


package chapter1.massive;

public class BubbleSort{

private int[] myMassive;

public BubbleSort(int[] initMassive){
	myMassive = new int[initMassive.length];
	for(int index = 0; index!=initMassive.length;index++){
		myMassive[index] = initMassive[index]; 		
	}

}

public void sortMassive(){

	for(int back = myMassive.length - 1;back>=0;back--){
	 for(int forward = 0; forward < back; forward++){
	    int temp = myMassive[forward];
	    if(myMassive[forward]>myMassive[forward+1]){
		myMassive[forward] = myMassive[forward+1];
		myMassive[forward+1] = temp;
		}
	}		

	}
}

public int[] getMassive(){
	return myMassive;
}

public void printMassive(){

	for(int index = 0; index < myMassive.length;index++){
		System.out.printf("%d",myMassive[index]);
		System.out.print(" ");			
	}

}

public static void main(String[] args){
	
	int[] unsort = new int[] {1,3,45,32,12,89,54,32,2,78,87,54,45,33,88,99,11};
	BubbleSort bubl = new BubbleSort(unsort);
	System.out.println("\nUnsorting massive...\n");
	bubl.printMassive();
	System.out.println("\n\nSorting massive...\n");
	bubl.sortMassive();
	bubl.printMassive();
		
}

}