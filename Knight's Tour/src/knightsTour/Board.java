package knightsTour;

public class Board {
	
	private int width;
    private int length;
    private Node topCorner; //top left corner of board
    int step = 1;

    public Board(int size)
    {
        width = size;
        length = size;
        topCorner = new Node();
        
        Node position = topCorner; //duplicate variable of topCorner
        Node columnPos = position; //Keeps track of which column to traverse
        Node rowPos = new Node(); //node preceeding (on top) position
        
        for(int c = 0; c < width-1; c++){
            for(int r = 0; r < length; r++){
                //initializer temp nodes
                Node temp1 = new Node();
                Node temp2 = new Node();
                
                //For the first column, right and down nodes are initialized
                if(c == 0){
                    position.setRight(temp1);
                    temp1.setLeft(position);
                    if(r != length-1){
                        position.setDown(temp2);
                        temp2.setUp(position);
                    }
                    //Joins the position and rowPos nodes together
                    if(r != 0){
                        position.getRight().setUp(rowPos.getRight());
                        rowPos.getRight().setDown(position.getRight());
                    }
                }
                //For other columns only right nodes are initialized 
                else{
                    position.setRight(temp1);
                    temp1.setLeft(position);
                    //Joins the position and rowPos nodes together
                    if(r != 0){
                        position.getRight().setUp(rowPos.getRight());
                        rowPos.getRight().setDown(position.getRight());
                    }
                }
                //When position has reached the end of the column, 
                //it goes to the top of the next column
                if(r == length-1){
                    columnPos = columnPos.getRight();
                    position = columnPos;
                    rowPos = null;
                }
                //Moves position down the column
                else{
                    position = position.getDown();
                    rowPos = position.getUp();
                }
            }
        }
    }
    
    public void display()
    {
        if(topCorner != null){
		 	Node temp = topCorner;
		 	Node marker = topCorner;
			while(marker != null){
			    while(temp != null){
			        if(temp.getData() > 9)
			            System.out.print(temp.getData() +" ");
			        else
			            System.out.print(temp.getData() +"  ");
				    temp = temp.getRight();
			    }
                marker = marker.getDown();
                temp = marker;
                System.out.println();
			}
			
			System.out.println();
		
		}
		else
			System.out.println("Board is empty.");
    }
    
    //GETTERS and SETTERS
    public Node getTopCorner(){
        return topCorner;
    }
    
    public void setTopCorner(Node topCorner){
        this.topCorner = topCorner;
    }
    
    /*public int getStep(){
        return step;
    }
    
    public void setCounter(int counter){
        this.step = step;
    }*/
    
    public boolean tour(Node knight, Board board, int width, int length)
	{
        knight.setData(step);
        step++;
	    
	    /*if(step == 14)
	        board.display();*/
	        
	   //System.out.println(step);
	    
	    if(step == width*length+1) //Checks if solution has been found
	        return true;
	    //board.display();
	    
	    //Knight goes right and down 2
	    if(knight.getRight() != null){
            if(knight.getRight().getDown() != null){
                if(knight.getRight().getDown().getDown() != null){
                    if(knight.getRight().getDown().getDown().getData() == 0){
                        knight = knight.getRight().getDown().getDown();
	                    if(tour(knight, board, width, length))
	                        return true;
                        knight.setData(0);
                        step--;
                        //board.display();
                    }
                }
            }
        }
        
        //knight goes right and up 2
        if(knight.getRight() != null){
            if(knight.getRight().getUp() != null){
                if(knight.getRight().getUp().getUp() != null){
                    if(knight.getRight().getUp().getUp().getData() == 0){
                        knight = knight.getRight().getUp().getUp();
	                    if(tour(knight, board, width, length))
	                        return true;
                        knight.setData(0);
                        step--;
                        //board.display();
                    }
                }
            }
        }
            
        //Knight goes right 2 and down
        if(knight.getRight() != null){
            if(knight.getRight().getRight() != null){
                if(knight.getRight().getRight().getDown() != null){
                    if(knight.getRight().getRight().getDown().getData() == 0){
                        knight = knight.getRight().getRight().getDown();
	                    if(tour(knight, board, width, length))
	                        return true;
                        knight.setData(0);
                        step--;
                        //board.display();
                    }
                }
            }
        }
            
        //Knight goes right 2 and up
        if(knight.getRight() != null){
            if(knight.getRight().getRight() != null){
                if(knight.getRight().getRight().getUp() != null){
                    if(knight.getRight().getRight().getUp().getData() == 0){
                        knight = knight.getRight().getRight().getUp();
	                    if(tour(knight, board, width, length))
	                        return true;
                        knight.setData(0);
                        step--;
                        //board.display();
                    }
                }
            }
        }
            
        //Going Left
        //Knight goes left and down 2
        if(knight.getLeft() != null){
            if(knight.getLeft().getDown() != null){
                if(knight.getLeft().getDown().getDown() != null){
                    if(knight.getLeft().getDown().getDown().getData() == 0){
                        knight = knight.getLeft().getDown().getDown();
	                    if(tour(knight, board, width, length))
	                        return true;
                        knight.setData(0);
                        step--;
                        //board.display();
                    }
                }
            }
        }
            
        //knight goes left and up 2
        if(knight.getLeft() != null){
            if(knight.getLeft().getUp() != null){
                if(knight.getLeft().getUp().getUp() != null){
                    if(knight.getLeft().getUp().getUp().getData() == 0){
                        knight = knight.getLeft().getUp().getUp();
	                    if(tour(knight, board, width, length))
	                        return true;
                        knight.setData(0);
                        step--;
                        //board.display();
                    }
                }
            }
        }
            
        //Knight gows left 2 and down
        if(knight.getLeft() != null){
            if(knight.getLeft().getLeft() != null){
                if(knight.getLeft().getLeft().getDown() != null){
                    if(knight.getLeft().getLeft().getDown().getData() == 0){
                        knight = knight.getLeft().getLeft().getDown();
	                    if(tour(knight, board, width, length))
	                        return true;
                        knight.setData(0);
                        step--;
                        //board.display();
                    }
                }
            }
        }
        
        //Knight gows left 2 and up
        if(knight.getLeft() != null){
            if(knight.getLeft().getLeft() != null){
                if(knight.getLeft().getLeft().getUp() != null){
                    if(knight.getLeft().getLeft().getUp().getData() == 0){
                        knight = knight.getLeft().getLeft().getUp();
	                    if(tour(knight, board, width, length))
	                        return true;
	                    knight.setData(0);
                        step--;    
                        //board.display();
                    }
                }
            }
        }
            
        //Goes back a move
        //knight.setData(0);
        //board.display();
        //step--;
        //System.out.println(step);
        //System.out.println("Path not found");
        return false;
	}

}
