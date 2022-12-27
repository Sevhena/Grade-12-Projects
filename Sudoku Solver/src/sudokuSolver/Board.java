package sudokuSolver;

import java.util.Scanner;

import java.io.*;

public class Board{
	
	/*The Sudoku Board is made of 9x9 cells for a total of 81 cells.
	 * In this program we will be representing the Board using a 2D Array of cells.
	 * 
	 */

	private Cell[][] board = new Cell[9][9];
	
	//The variable "level" records the level of the puzzle being solved.
	private String level = "";

	
	///TODO: CONSTRUCTOR
	//This must initialize every cell on the board with a generic cell.  It must also assign all of the boxIDs to the cells
	public Board()
	{
		for(int x = 0; x < 9; x++)
			for(int y = 0 ; y < 9; y++)
			{
				board[x][y] = new Cell();
				board[x][y].setBoxID( 3*(x/3) + (y)/3+1);
		        //System.out.println(board[x][y].numberOfPotentials());
			}
	}
	
	///TODO: loadPuzzle
	/*This method will take a single String as a parameter.  The String must be either "easy", "medium" or "hard"
	 * If it is none of these, the method will set the String to "easy".  The method will set each of the 9x9 grid
	 * of cells by accessing either "easyPuzzle.txt", "mediumPuzzle.txt" or "hardPuzzle.txt" and setting the Cell.number to 
	 * the number given in the file.  
	 * 
	 * This must also set the "level" variable
	 * TIP: Remember that setting a cell's number affects the other cells on the board.
	 */
	public void loadPuzzle(String level) throws Exception
	{
		this.level = level;
		String fileName = "src\\sudokuSolver\\" + level + "Puzzle.txt";
		// if(level.contentEquals("medium"))
		// 	fileName = "mediumPuzzle.txt";
		// else if(level.contentEquals("hard"))
		// 	fileName = "hardPuzzle.txt";
		
		System.out.println(new File(".").getAbsoluteFile());
		
		Scanner input = new Scanner(new File(fileName));
		
		for(int x = 0; x < 9; x++)
			for(int y = 0 ; y < 9; y++)
			{
				int number = input.nextInt();
				if(number != 0)
					solve(x, y, number);
		        //System.out.println(board[x][y].numberOfPotentials());
			}
						
		input.close();
		
	}
	
	///TODO: isSolved
	/*This method scans the board and returns TRUE if every cell has been solved.  Otherwise it returns FALSE
	 * 
	 */
	public boolean isSolved()
	{
		for(int r = 0; r < 9; r++){
		    for(int c = 0; c < 9; c++)
		        if(board[r][c].getNumber() == 0)
		            return false;
		}
		return true;
	}


	///TODO: DISPLAY
	/*This method displays the board neatly to the screen.  It must have dividing lines to show where the box boundaries are
	 * as well as lines indicating the outer border of the puzzle
	 */
	public void display()
	{
		for(int r = 0; r < 9; r++){ //Traverses row
		    if(r > 0)
		        System.out.println();
	        if(r%3 == 0)
	            System.out.print(" ___________________\n");
		    for(int c = 0; c < 9; c++){
		        if(c%3 == 0)
		            System.out.print(" | ");
	            System.out.print(board[r][c].getNumber());
	            if(c == 8)
		            System.out.print(" | ");
		    }
		    if(r == 8)
	            System.out.println("\n -------------------\n");
		}
	}
	
	///TODO: solve
	/*This method solves a single cell at x,y for number.  It also must adjust the potentials of the remaining cells in the same row,
	 * column, and box.
	 */
	public void solve(int x, int y, int number)
	{
	    board[x][y].setNumber(number);
	    
        for(int r = 0; r < 9; r++){
		    for(int c = 0; c < 9; c++){
		        if((r == x || c == y || board[r][c].getBoxID() == board[x][y].getBoxID()) && board[r][c] != board[x][y])
		            board[r][c].cantBe(number);
		        //System.out.println(board[r][c].numberOfPotentials());
		    }
		}
	}
	
	
	//logicCycles() continuously cycles through the different logic algorithms until no more changes are being made.
	public void logicCycles()throws Exception
	{
		
		while(isSolved() == false)
		{
			int changesMade = 0;
			do
			{
				changesMade = 0;
				changesMade += logic1();
				changesMade += logic2();
				changesMade += logic3();
				changesMade += logic4();
				//display();
				//System.out.println(board[0][4].numberOfPotentials());
				if(errorFound()){
				    System.out.println("error found");
					break;
				}
			}while(changesMade != 0);
			
			/*if(isSolved() == false){
			    Cell[][] oldBoard = new Cell[9][9];
			    
			for(int r = 0; r < 9; r++)
    		    for(int c = 0; c < 9; c++)
    		        oldBoard[r][c] = board[r][c];
			    
			    for(int i = 1; i < 10; i++){
			        Cell guess = board[(int)(Math.random()*9][(int)(Math.random()*9]
			        if(guess.getNumber() == 0 && guess.canBe(i)){
			            guess.setNumber(i);
			            logicCycles();
			            if(isSolved() == false){
			                board == oldBoard;
			                oldBoard
			            }
			            else break;
			        }
			    }
			}*/
	
		}			
		
	}
	
	
	///TODO: logic1
	/*This method searches each row of the puzzle and looks for cells that only have one potential.  If it finds a cell like this, it solves the cell 
	 * for that number. This also tracks the number of cells that it solved as it traversed the board and returns that number.
	 */
	public int logic1()
	{
		int changesMade = 0;
        for(int r = 0; r < 9; r++){ //Traverses row
		    for(int c = 0; c < 9; c++) //Traverses column
		        if(board[r][c].numberOfPotentials() == 1 && board[r][c].getNumber() == 0){ //Checks number of potentials
		            solve(r,c,board[r][c].getFirstPotential());
		            changesMade++;
		        }
		}
		
		return changesMade;
	}
	
	///TODO: logic2
	/*This method searches each row for a cell that is the only cell that has the potential to be a given number.  If it finds such a cell and it
	 * is not already solved, it solves the cell.  It then does the same thing for the columns.This also tracks the number of cells that 
	 * it solved as it traversed the board and returns that number.
	 */
	
	public int logic2()
	{
		int changesMade = 0;
		
		boolean cellsWithPotential = false;
		int rowHolder = 0, columnHolder = 0;
		
		for(int i = 1; i < 10; i++){ //Goes through potentials 1 to 9
		    for(int r = 0; r < 9; r++){ //Traverses row
		        for(int c = 0; c < 9; c++){ //Traverses column
		            if(board[r][c].canBe(i)){ //Checks potential
		                if(cellsWithPotential == false){
		                    cellsWithPotential = true;
		                    columnHolder = c;
		                }
		                else{
		                    cellsWithPotential = false;
		                    break;
		                }
		            }
		        }
		        //Solves the cell
		        if(cellsWithPotential && board[r][columnHolder].getNumber() == 0){
	                solve(r,columnHolder,i);
	                changesMade++;
		        }
		    }
		        
		}
		for(int i = 1; i < 10; i++){ //Goes through potentials 1 to 9
		    for(int c = 0; c < 9; c++){ // Traverse column
		        for(int r = 0; r < 9; r++){ //Traverses row
		            if(board[r][c].canBe(i)){ //Checks potential
		                if(cellsWithPotential == false){
		                    cellsWithPotential = true;
		                    rowHolder = r;
		                }
		                else{
		                    cellsWithPotential = false;
		                    break;
		                }
		            }
		        }
		        //Solves cell
		        if(cellsWithPotential && board[rowHolder][c].getNumber() == 0){
	                solve(rowHolder,c,i);
	                changesMade++;
	            }
		    }
		}

		return changesMade;
	}
	
	///TODO: logic3

	/*This method searches each box for a cell that is the only cell that has the potential to be a given number.  If it finds such a cell and it
	 * is not already solved, it solves the cell. This also tracks the number of cells that it solved as it traversed the board and returns that number.
	 */
	public int logic3()
	{
		int changesMade = 0;
		
		int cellsWithPotential = 0;
		int rowHolder = 0, columnHolder = 0;
		
    	for(int x = 1; x < 10; x++){ //Cycles through box IDs
    	    for(int i = 1; i < 10; i++){ //Cycles through number potentials
    		    for(int r = (x-1)/3*3; r < (x-1)/3*3+3; r++){ //Traverses rows in box
    		        for(int c = 0; c < 9; c++){ //Traverses columns in box
    		            if(board[r][c].canBe(i) && board[r][c].getBoxID() == x){
		                    cellsWithPotential++;
		                    rowHolder = r;
		                    columnHolder = c;
        		        }
    		        }
    		    }
    		    //Solves the cell 
    		    if(cellsWithPotential == 1 && board[rowHolder][columnHolder].getNumber() == 0){
	                solve(rowHolder,columnHolder,i);
	                cellsWithPotential = 0;
	                changesMade++;
	            }
	            else
	                cellsWithPotential = 0;
		    }
    	}
		
		return changesMade;
	}
	
	
	///TODO: logic4
		/*This method searches each row for the following conditions:
		 * 1. There are two unsolved cells that only have two potential numbers that they can be
		 * 2. These two cells have the same two potentials (They can't be anything else)
		 * 
		 * Once this occurs, all of the other cells in the row cannot have these two potentials.  Write an algorithm to set these two potentials to be false
		 * for all other cells in the row.
		 * 
		 * Repeat this process for columns and rows.
		 * 
		 * This also tracks the number of cells that it solved as it traversed the board and returns that number.
		 */
	public int logic4()
	{
		int changesMade = 0;
		int counter = 0; //Traverses temp array when storing indexes
		int cell1Potential1 = 0, cell1Potential2 = 0, cell2Potential1 = 0, cell2Potential2 = 0; //The potentials of
		                                                                              //the two cells being compared
		boolean matchFound = false;
		
		for(int r = 0; r < 9; r++){
		    int[] columnHolder = {10,10,10,10,10,10,10,10,10}; //Holds column indexes
		    int possibleMatches = 0; //How many cells have only 2 potentials in a row
		    for(int c = 0; c < 9; c++){
		        //Checks how many potentials a cell has
		        if(board[r][c].numberOfPotentials() == 2){
		            possibleMatches++;
		            columnHolder[counter] = c;
		            counter++;
		        }
		    }
		    if(possibleMatches >= 2){
    		    for(int x = 1; x < 9 && columnHolder[x] != 10; x++){
    		        //Sets each potential of the first cell to a variable
    		        cell1Potential1 = board[r][columnHolder[x-1]].getFirstPotential();
    		        for(int z = cell1Potential1+1; z < 9; z++) //Traverses potential array to find second potential
    		            if(board[r][columnHolder[x-1]].canBe(z))
    		                cell1Potential2 = z;
    		                
    		        //Sets each potential of the second cell to a variable
    		        cell2Potential1 = board[r][columnHolder[x]].getFirstPotential();
    		        for(int z = cell2Potential1+1; z < 9; z++)//Traverses potential array to find second potential
    		            if(board[r][columnHolder[x]].canBe(z))
    		                cell2Potential2 = z;
    		        
    		        //Checks if the potentials of both cells match
        		    if((cell1Potential1 == cell2Potential1 || cell1Potential1 == cell2Potential2) && (cell1Potential2 == cell2Potential1 || cell1Potential2 == cell2Potential2)){
    		            matchFound = true;
    		            changesMade++;
    		            for(int r2 = 0; r2 < 9; r2++){
                		    for(int c2 = 0; c2 < 9; c2++)
                		        //Adjusts the potentials of the other cells in the row
                		        if(r2 == r && board[r2][c2] != board[r][columnHolder[x-1]] && board[r2][c2] != board[r][columnHolder[x]]){
                		            board[r2][c2].cantBe(cell1Potential1);
                		            board[r2][c2].cantBe(cell1Potential2);
                		        }
            		    }
            		    break;
    		        }
    		    }  
		    }
		    matchFound = false;
		    counter = 0;
		}
		
		for(int c = 0; c < 9; c++){
		    int[] rowHolder = {10,10,10,10,10,10,10,10,10}; //Stores row indexes
		    int possibleMatches = 0;
		    for(int r = 0; r < 9; r++){
		        //Checks number of potentials a cell has
		        if(board[r][c].numberOfPotentials() == 2){
		            possibleMatches++;
		            rowHolder[counter] = r;
		            counter++;
		        }
		    }
		    if(possibleMatches >= 2){
    		    for(int x = 1; x < 9 && rowHolder[x] != 10; x++){
    		        //Sets each potential of the first cell to a variable
    		        cell1Potential1 = board[rowHolder[x-1]][c].getFirstPotential();
    		        for(int z = cell1Potential1+1; z < 9; z++)//Traverses potential array to find second potential
    		            if(board[rowHolder[x-1]][c].canBe(z))
    		                cell1Potential2 = z;
    		                
    		        //Sets each potential of the second cell to a variable
    		        cell2Potential1 = board[rowHolder[x]][c].getFirstPotential();
    		        for(int z = cell2Potential1+1; z < 9; z++)//Traverses potential array to find second potential
    		            if(board[rowHolder[x]][c].canBe(z))
    		                cell2Potential2 = z;
    		                
	                //Compares the potentials of each cell
        		    if((cell1Potential1 == cell2Potential1 || cell1Potential1 == cell2Potential2) && (cell1Potential2 == cell2Potential1 || cell1Potential2 == cell2Potential2)){
    		            matchFound = true;
    		            changesMade++;
    		            for(int c2 = 0; c2 < 9; c2++){
                		    for(int r2 = 0; r2 < 9; r2++)
                		        //Adjust the potentials of the other cells in the column
                		        if(c2 == c && board[r2][c2] != board[rowHolder[x-1]][c] && board[r2][c2] != board[rowHolder[x]][c]){
                		            board[r2][c2].cantBe(cell1Potential1);
                		            board[r2][c2].cantBe(cell1Potential2);
                		        }
            		    }
            		    break;
    		        }
    		    }
		    }
		    matchFound = false;
		    counter = 0;
		}
		
		//display();
		return changesMade;
	}
	
	
	///TODO: errorFound
	/*This method scans the board to see if any logical errors have been made.  It can detect this by looking for a cell that no longer has the potential to be 
	 * any number.
	 */
	public boolean errorFound()
	{
	    for(int r = 0; r < 9; r++){
		    for(int c = 0; c < 9; c++)
		        if(board[r][c].numberOfPotentials() == 0)
		            return true;
		}
		    
	    return false;
	}
}
