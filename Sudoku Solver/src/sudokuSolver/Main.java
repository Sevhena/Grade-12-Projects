package sudokuSolver;

public class Main {

	public static void main(String[] args) throws Exception {
		Board puzzle = new Board();
		puzzle.loadPuzzle("hard");
		puzzle.display();
		//System.out.println(puzzle.errorFound());
		puzzle.logicCycles();
		//int changes = puzzle.logic1();
		//System.out.println(changes);
		//System.out.println();
		//puzzle.display();
		//changes = puzzle.logic2();
		//changes = puzzle.logic3();
		//changes = puzzle.logic4();
		puzzle.display();
		System.out.println(puzzle.errorFound());
		System.out.println(puzzle.isSolved());

	}

}
