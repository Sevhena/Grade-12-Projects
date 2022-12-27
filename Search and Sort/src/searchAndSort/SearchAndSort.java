package searchAndSort;

import myTools.MyTools;

import java.util.Arrays;
import java.util.Scanner;

public class SearchAndSort {
	
	public static void merge(int[] array, int leftBegin, int middle, int rightEnd)
	{
		int[] array1 = Arrays.copyOfRange(array, leftBegin, middle+1); //Sets new copy array for left side
		int[] array2 = Arrays.copyOfRange(array, middle+1, rightEnd+1); //Sets new copy array for right side
		
		int leftP = 0, rightP = 0, arrayP = leftBegin; //Pointers
		
		while(leftP < array1.length && rightP < array2.length) { //Inserts numbers from temp arrays until one is "empty"
			
			if(array1[leftP] <= array2[rightP]) {
				array[arrayP] = array1[leftP];
				leftP++;
			}
			else {
				array[arrayP] = array2[rightP];
				rightP++;
			}
			arrayP++;
		}
		
		while(leftP < array1.length) { //Inserts remaining numbers from array 1 into array
			array[arrayP] = array1[leftP];
			leftP++;
			arrayP++;
		}
		while(rightP < array2.length) { //Inserts remaining numbers from array 2 into array
			array[arrayP] = array2[rightP];
			rightP++;
			arrayP++;
		}
	}
	
	public static void mergeSort(int[] array, int start, int end)
	{
		if(start < end) { //Checks to see if new array length is greater than 1
			int middle = (start + end)/2;
			
			mergeSort(array, start, middle); //Splits left side
			mergeSort(array, middle+1, end); //Splits right side
			
			merge(array, start, middle, end); // Calls merge method
		} 
	}
	
	public static void main(String[] args)throws Exception {
		
		Scanner input = new Scanner(System.in);
		//int[] array = {1,2,3,4,5,6,7,8,9,10}; //Test Array
		final int SIZE = 100;
		int[] array = new int [SIZE];
		int userChoice = 0;
		
		do {
			System.out.println("\nWelcome to the The Array.");
			System.out.println("What would you like to do?");
			System.out.println("0.\tExit the program.");
			System.out.println("1.\tDisplays the array.");
			System.out.println("2.\tChecks if array is sorted.");
			System.out.println("3.\tPopulate the array randomly.");
			System.out.println("4.\tPopulate the array sequentially.");
			System.out.println("5.\tShuffle the Array.");
			System.out.println("6.\tLinear Search.");
			System.out.println("7.\tBubble Sort.");
			System.out.println("8.\tQuick Sort.");
			System.out.println("9.\tBinary Search.");
			System.out.println("10.\tSelection Sort.");
			System.out.println("11.\tInsertion Sort.");
			System.out.println("12.\tRadix Sort.");
			System.out.println("13.\tMerge Sort.\n");
			
			
			userChoice = MyTools.errorTrap(input,0,13);
			
			if(userChoice == 1) { //Displays array
				for (int x = 0; x < array.length; x++)
					System.out.print(array[x] + " ");
				System.out.println();
			}
			else if(userChoice == 2) { //Checks if array is sorted
				MyTools.checksSortedAr(array);
			}
			else if(userChoice == 3) { //Populates Randomly
				 MyTools.randomArray(array, 1, SIZE); 
			}    
			else if(userChoice == 4) { //Populates sequentially
				MyTools.sortedArray(array); 
			}
			else if(userChoice == 5) { // Shuffle
				MyTools.shuffleArray(array); 
			}
			else if(userChoice == 6) { //Find number
				MyTools.linearSearch(array); 
			}
			else if(userChoice == 7) { // Bubble Sort
				System.out.print("Time taken: ");
				long time = System.currentTimeMillis();
				MyTools.bubbleSort(array); 
				System.out.println(System.currentTimeMillis()-time);
			}
			else if(userChoice == 8) { //Quick Sort
				System.out.print("Time taken: ");
				long time = System.currentTimeMillis();
				MyTools.quickSort(array, 0, array.length-1); 
				System.out.println(System.currentTimeMillis()-time);
			}
			else if(userChoice == 9) { //Binary Search
				//Array must be sorted
				MyTools.binarySearch(array); 
			}
			else if(userChoice == 10) { //Selection Sort
				MyTools.selectionSort(array);
			}
			else if(userChoice == 11) { // Insertion Sort
				long time = System.currentTimeMillis();
				array = MyTools.insertionSort(array);
				System.out.print(System.currentTimeMillis()-time);
			}
			else if(userChoice == 12) { // Radix Sort
				array = MyTools.radixSort(array);
			}
			else if(userChoice == 13) {
				System.out.print("Time taken: ");
				long time = System.currentTimeMillis();
				mergeSort(array, 0, array.length-1);
				System.out.print(System.currentTimeMillis()-time);
			}
			
		}while(userChoice != 0);
			System.out.println("Goodbye!");

		input.close();
	}

}
