package knightsTour;

public class KnightsTour {

	public static void main(String[] args) {
		int boardSize = 5;
	    Board board = new Board(boardSize);
	    //board.display();
	    if(board.tour(board.getTopCorner(), board, boardSize, boardSize)){
            System.out.println("Path found.");
            board.display();
	    }
	        
        else 
            System.out.println("Path not found.");
	}

}
