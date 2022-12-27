package myTools;

import java.util.Arrays;

import java.util.Scanner;

public class MyTools {
	
	//error trap for doubles that only checks input type
	public static double errorTrapd(Scanner input)
	{
		boolean goodInput = true;
		int number = 0;
		do 
		{
			goodInput = true;
			try
			{
				System.out.println("Please enter a number : ");
				number = input.nextInt();
			}
			catch (Exception e)//If exception is thrown it gets caught here
			{
				goodInput = false;
				input.next();
				System.out.print("Error occured.");
			}
		}while (goodInput == false);
		
		return number;
	}
	
	//error Trap for doubles that also checks range
	public static double errorTrapd(Scanner input, int max, int min)
	{
		boolean goodInput = true;
		int number = 0;
		do
		{
			try
			{
				System.out.print("Enter a number from " + min + " to " + max + ": ");
				goodInput = true;
				number = input.nextInt();
			}
			catch(Exception e)
			{
				goodInput = false;
				input.next();
				System.out.println("Invalid entry. Please re-make your choice.");
			}
			
			if(number > max || number < min)
				System.out.print("Number does not fit specified parameters.");
			
		}while(goodInput == false || number > max || number < min);
		
		return number;
	}
	
	//Error trap for integers that only checks input type
	public static int errorTrap(Scanner input)
	{
		//Scanner input = new Scanner(System.in);
		boolean goodInput = true;
		int number = 0;
		do 
		{
			goodInput = true;
			try
			{
				System.out.print("Please enter a number : ");
				number = input.nextInt();
			}
			catch (Exception e)//If exception is thrown it gets caught here
			{
				goodInput = false;
				input.next();
				System.out.print("Error occured.");
			}
		}while (goodInput == false);
		
		return number;
	}

	//Error Trap for integers that also checks range
	public static int errorTrap(Scanner input, int min, int max)
	{
		// Scanner input = new Scanner(System.in);
		boolean goodInput = true;
		int number = 0;
		do
		{
			try
			{
				System.out.print("Enter a number from " + min + " to " + max + ": ");
				goodInput = true;
				number = input.nextInt();
			}
			catch(Exception e)
			{
				goodInput = false;
				input.next();
				System.out.println("Invalid entry. Please re-make your choice. ");
			}
			
			if(number > max || number < min)
				System.out.print("Number does not fit specified parameters. ");
			
		}while(goodInput == false || number > max || number < min);
		
		return number;
	}
	
	//Random number generator that minimum and maximums in any order
	public static int numberGen(int min, int max)
	{
		int hold = 0;
				
		if(min > max) {
			hold = min;
			min = max;
			max = hold;
		}
		
		/*System.out.print("Please enter a minimum: ");
		min = errorTrap(); //calls minimum from error trap method
		System.out.print("Please enter a maximum: ");
		max = errorTrap(); // calls maximum from error trap method*/
		
		int number = (int) (Math.random()*(max-min+1)+min);
		
		return number;
	}

	//method that receives a number and returns the "n" digit
	public static int digitFinder(int number, int place)
	{
		int nbDigits = 0, trueDigit = 0, lastDigit = 0;
		int hold = number;
		
		//Finds out how many digits in the number
		while(hold > 0) {
			nbDigits++;
			hold = hold/10; // makes last digit a decimal so that it is eliminated by integer specification
		}
		
		//Determines which digit to output
		do {
			lastDigit = number % 10; // determines the last digit
			number = number/10; // makes last digit a decimal so that it is eliminated by integer specification
			nbDigits--;
		}while(nbDigits >= place);
		
		//System.out.println(lastDigit);
		trueDigit = lastDigit;
		
		return trueDigit;
	}
	
	public static void charFinder(String word) //Determines the "n" letter in a word
	{
		Scanner input = new Scanner(System.in);
		
		/*System.out.print("Please enter a word : ");
		String word = input.next();*/
		
		//input.close();
		
		int length = word.length();
		
		int charChoice = MyTools.errorTrap(input, 1, length);
		
		char letter = word.charAt(charChoice-1);
		
		if(charChoice % 10 == 1)
			System.out.println("The " +charChoice +"st letter is: " +letter);
		else if(charChoice % 10 == 2)
			System.out.println("The " +charChoice +"nd letter is: " +letter);
		else if(charChoice % 10 == 3)
			System.out.println("The " +charChoice +"rd letter is: " +letter);
		else 
			System.out.println("The " +charChoice +"th letter is: " +letter);
	}
	
	public static int[] createRandomAr(int SIZE) //Creates a random array
	{
		int[] array = new int[SIZE];
		
		for(int x = 0; x < SIZE; x++)
			 array[x] = (int)(Math.random()*SIZE+1);
		
		return array;
	}
	
	public static int[] initializeSortedAr(int[] array)
	{
		int value = 1;
		for(int i = 0; i < array.length; i++) {
			array[i] = value;
			value++;
		}
		
		return array;
	}
	
	public static void randomArray(int[] array) //Populates a random array
	{
		//generates array
		for(int x = 0; x < array.length; x++)
			 array[x] = (int)(Math.random()*array.length+1);
		
		//outputs array
		/*for (int x = 0; x < array.length; x++)
			System.out.print(array[x] + " ");*/
	}

	public static void randomArray(int[] array, int min, int max) //Populates a random array
	{
		//generates array
		for(int x = 0; x < array.length; x++)
			 array[x] = (int) (Math.random()*(max-min+1)+min);
		
		//outputs array
		/*for (int x = 0; x < array.length; x++)
			System.out.print(array[x] + " ");*/
	}
	
	public static void sortedArray(int[] array) //Populates the array sequentially
	{
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
	}
	
	public static void shuffleArray(int[] array) //Shuffles the array
	{ 			
		//Shuffle
		//Swaps number at position x with another number 
		//at a random position
		for (int x = 0; x < array.length; x++) {
		    int randomPosition = (int)(Math.random()*array.length);
		    int temp = array[x];
		    array[x] = array[randomPosition];
		    array[randomPosition] = temp;
		}
		//Output
		for (int x = 0; x < array.length; x++)
			System.out.print(array[x] + " ");
	}

	public static void linearSearch(int[] array) //Finds a number in the array
	{
		Scanner input = new Scanner(System.in);
		int index = 0;
		boolean found = false;
		//Asks user which number they would like to find
		System.out.print("Which number would you like to find? ");
		int number = MyTools.errorTrap(input,1, array.length);
		//Determines whether the number occurred and at which index
		for (int x = 0; x < array.length; x++) {
			if(array[x] == number && found == false) {
				index = x;
				found = true;
			}
		}
		if(found)
			System.out.println("The number " +number +" populated at index " +index +".");
		else
			System.out.println("-1");
	}
	
	public static void bubbleSort(int[] array)
	{
		for(int a = 0; a < array.length-1; a++) { //Traverses the array
			for(int b = a + 1; b < array.length; b++) { //Traverses the array to compare with number of outer loop
				if(array[b] < array[a]) { //Number swap
					int temp = array[b];
					array[b] = array[a];
					array[a] = temp;
				}
			}
		}
	}
	
	public static void selectionSort(int[] array)
	{
		for(int a = 0; a < array.length/2; a++) {
			int smallest = a, biggest = a;
			for(int b = a + 1; b < array.length-a; b++) {
				if(array[b] > array[biggest]) //Checks next biggest number
					biggest = b;
				else if(array[b] < array[smallest]) //Checks next smallest number
					smallest = b;
			}
			
			//MUST CHECK IF THE SMALLEST NUMBER WILL BE SWAPPED OUT OF POSITION BY THE
			//BIGGEST NUMBER SWAP
			if( (array.length-a-1) == smallest )
				smallest = biggest;
			
			//System.out.println("Swapping " + array[array.length-a-1] +" with " +array[biggest]);
			//Swaps biggest number into correct position
			int temp = array[array.length-(1+a)];
			array[array.length-(1+a)] = array[biggest];
			array[biggest] = temp;
			
			//System.out.println("Swapping " + array[a] +" with " +array[smallest]);
			//Swaps smallest number into correct position
			temp = array[a];
			array[a] = array[smallest];
			array[smallest] = temp;
			
			//for (int x = 0; x < array.length; x++)
			//	System.out.print(array[x] + " ");
			//System.out.println();
		}
	}
	
	public static int[] insertionSort(int[] array)
	{
		int[] sortedAr = new int [array.length];
		int index = 0;
		
		sortedAr[0] = array[0]; //Inserts first number into sorted array
		
		for(int x = 1; x < array.length; x++) {
			boolean greater = false; //Resets boolean "greater"
			for(int i = sortedAr.length-2; i >= 0; i--) { //Traverses the array in reverse
				if(array[x] >= sortedAr[i] && sortedAr[i] != 0 && sortedAr[i+1] == 0) { 
					//Checks in number from outer loop is greater than extreme right number in sorted array
					sortedAr[i+1] = array[x];
					greater = true;
					break;
				}	
				else if(array[x] < sortedAr[i]) //Checks where in sorted array number need to be inserted
					index = i;
			}
			if(greater)
				continue;
			else {
				for(int z = sortedAr.length-2; z >= index; z--) 
					//Moves all numbers to the right of index one position over including number at index
					sortedAr[z+1] = sortedAr[z];
				sortedAr[index] = array[x]; // Inserts number where index number used to be
			}
		}
		return sortedAr;
	}
	
	public static int[] radixSort(int[] array)
	{
		int[] sortedAr = new int[array.length]; 
		int counter = 0;
		
		for(int a = 0; a < 3; a++) { //number place
			counter = 0; //To determine where in sorted array number should go
			if(a > 0) {
				//Resetting both arrays
				for(int i = 0; i < array.length; i++)
					array[i] = sortedAr[i];
				Arrays.fill(sortedAr, 0);
			}
			for(int b = 0; b < 10; b++) { //number of digit
				for(int c = 0; c < array.length; c++) { //goes through array
					if(digitFinder(array[c],a) == b) {
						sortedAr[counter] = array[c];
						counter++;
					}
				}
			}
		}
		
		return sortedAr;
	}
	
	public static void quickSort(int[] array, int start, int end)
	{
		if(start < end) {
			int slider = start, pivotIndex = end;
			
			do {
				//IF ELSE statement to check if slider is before or after the pivot
				if(slider < pivotIndex) {
					if(array[slider] > array[pivotIndex]) {
						//Swapping values at slider and pivot positions
						int temp = array[slider];
						array[slider] = array[pivotIndex];
						array[pivotIndex] = temp;
						//Swapping slider and pivot markers
						temp = slider;
						slider = pivotIndex;
						pivotIndex = temp;
						
						slider--;
					}
					else
						slider++;
				}
				else if(slider > pivotIndex) {
					if(array[slider] < array[pivotIndex]) {
						//Swapping values at slider and pivot positions
						int temp = array[slider];
						array[slider] = array[pivotIndex];
						array[pivotIndex] = temp;
						//Swapping slider and pivot markers
						temp = slider;
						slider = pivotIndex;
						pivotIndex = temp;
						
						slider++;
					}
					else
						slider--;
				}
			}while(slider != pivotIndex);
			
			//Sorting array before the pivot
			quickSort(array, start, pivotIndex-1);
			//Sorting array after the pivot
			quickSort(array, pivotIndex+1, end);
		}
	}
	
	public static void binarySearch(int[] array)
	{
		Scanner input = new Scanner(System.in);
		int guess = 0, guessIndex = 0, stake1 = 0, stake2 = array.length-1;
		boolean found = false;
		//Asks user which number they would like to find
		System.out.print("Which number would you like to find? ");
		int number = MyTools.errorTrap(input,1, array.length);
		//Determines whether the number occurred and at which index
		do {
			if(stake1 - stake2 == 1 || stake1 - stake2 == -1 || stake1 - stake2 == 0) {
				//If search range is less or equal to 2
				if(array[stake1] != number && array[stake2] != number)
					//If number is not at either stake, then number isn't in the array
					break;
				else {
					found = true;
					if(array[stake1] == number) {
						guess = array[stake1];
						guessIndex = stake1;
					}
					else {
						guess = array[stake2];
						guessIndex = stake2;
					}
				}	
			}
			else {
				guessIndex = (stake1 + stake2)/2; //Sets midpoint
				if(array[guessIndex] == number) { //Checks if midpoint is equal to number
					found = true;
					guess = array[guessIndex];
				}
				//Checks if number is greater or less than midpoint
				else if(array[guessIndex] > number)
					stake2 = guessIndex-1;
				else
					stake1 = guessIndex+1;
			}
			
		}while(guess != number || (0 + array.length)/2 == guess);
		
		if(found)
			System.out.println("The number " +number +" populated at index " +guessIndex +".");
		else
			System.out.println("-1");
	}
	
	public static void findArNumber(int[] array) //Finds a number in the array
	{
		Scanner input = new Scanner(System.in);
		int position = 0;
		boolean occurred = false;
		//Asks user which number they would like to find
		System.out.print("Which number would you like to find? ");
		int occurrence = MyTools.errorTrap(input, 1, array.length);
		//Determines whether the number occurred and at which index
		for (int x = 0; x < array.length; x++) {
			if(array[x] == occurrence && occurred == false) {
				position = x;
				occurred = true;
			}
		}
		if(occurred)
			System.out.println("The number " +occurrence +" populated at index " +position +".");
		else
			System.out.println("-1");
	}
	
	public static void checksSortedAr(int[] array) //Checks to see if the array is sorted
	{
		boolean croissant = true; //"Croissant" means ascending in French
		//Checks to see if the array is sorted and breaks at 
		//first sign of that being false
		for(int x = 0; x < array.length-1; x++){
			if(array[x] > array[x+1]) {
				croissant = false;
				break;
			}
		}
		if(croissant == true)
			System.out.println("Array in ascending order.");
		else
			System.out.println("Not in ascending order.");
	}
	
	public static void shuffleSort(int[] array) //Shuffles array until sorted or after 100,000 tries
	{
		boolean croissant = true;
		for(int tries = 0; tries < 100000; tries++) {
			croissant = true;
			//Checks to see if the array was sorted
			for(int x = 0; x < array.length-1; x++){
				if(array[x] > array[x + 1])
					croissant = false;
			}
			//If the array was sorted, breaks out of the loop
			if(croissant)
				break;
			//If the array was not sorted, it shuffles 
			else if(croissant == false) {
				for (int x = 0; x < array.length; x++) {
				    int randomPosition = (int)(Math.random()*array.length);
				    int temp = array[x];
				    array[x] = array[randomPosition];
				    array[randomPosition] = temp;
				}
			}
		}
		if(croissant)
			System.out.println("The array was succesfully sorted.");
		else 
			System.out.println("100,000 tries have elapsed. The array was not successfully sorted.");
	}
	
	public static void lowestArNumber(int[] array) //Finds the lowest number in the list
	{
		int smallNumber = array[0];
		//Determines the lowest number in the array
		for (int x = 0; x < array.length; x++) {
			if(array[x] < smallNumber)
				smallNumber = array[x];
		}
		System.out.println("The smallest number in the array is " +smallNumber +".");
	}
	
	public static void greatestArNumber(int[] array)//Finds the greatest number in the list
	{
		int bigNumber = array[0];
		//Determines the greatest number in the array
		for (int x = 0; x < array.length; x++) {
			if(array[x] > bigNumber)
				bigNumber = array[x];
		}
		System.out.println("The biggest number in the array is " +bigNumber +".");
	}
	
	public static void recurrentArNumber(int[] array) //Finds how many times a number occurred in the list
	{
		Scanner input = new Scanner(System.in);
		int occurrence = 0;
		boolean occurred = false;
		//Asks user which number they are inquiring about
		System.out.print("Which number would you like to find? ");
		int numberChoice = MyTools.errorTrap(input,1,array.length);
		//Checks to see if the number occurred and how many times
		for (int x = 0; x < array.length; x++) {
			if(array[x] == numberChoice) {
				occurred = true;
				occurrence++;
			}
		}
		if(occurred == false)
			System.out.println("The number " +numberChoice +" did not occure in the array.");
		else if(occurrence == 1)
			System.out.println("The number " +numberChoice +" occured " +occurrence +" time in the array.");
		else 
			System.out.println("The number " +numberChoice +" occured " +occurrence +" times in the array.");
	}

	public static void main(String[] args) {
		
	}

}
