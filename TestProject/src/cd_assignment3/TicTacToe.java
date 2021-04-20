package cd_assignment3;

public class TicTacToe {
	public static final int x=1, o=-1; //X and O values
	public static final int EMPTY=0; //empty value
	GameTree root; //the first node of the game tree
	GameTree current; //the current node position in the game tree
	
	public TicTacToe(){ //constructor with no parameters
		root=new GameTree(); //initialize root
		current=root; //set current to root
	}
	
	//function that finds the best move for X, then plays it
	public GameTree bestMoveX() {
		this.current=minimax(this.current,x);
		return this.current;
	}
	
	//function that finds the best move for O, then plays it
	public GameTree bestMoveO() {
		this.current=minimax(this.current,o);
		return this.current;
	}
	
	//function that finds the best move for X or O based on min/max scoring
	public GameTree minimax(GameTree current, int player) {
		GameTree bestMove=current;
		
		/*
		 * creates possible moves for X and checks the max score,
		 * then it assigns bestMove with the current node that had
		 * the best score which will then be returned
		 */
		if(player==x) { //executes only for X
			createMovesforPlayerOne(current);
			GameTree curr=current.firstChild;
			int best=-1000;
			while(curr!=null) {
				if(evaluate(curr.board)>best) {
					best=evaluate(curr.board);
					curr.value=best;
					bestMove=curr;
				}
				curr=curr.nextSibling;
			}
		}
		
		/*
		 * creates possible moves for O and checks the min score,
		 * then it assigns bestMove with the current node that had
		 * the best score which will then be returned
		 */
		if(player==o) { //executes only for O
			createMovesforPlayerTwo(current);
			GameTree curr=current.firstChild;
			int best=1000;
			while(curr!=null) {
				if(evaluate(curr.board)<best) {
					best=evaluate(curr.board);
					curr.value=best;
					bestMove=curr;
				}
				curr=curr.nextSibling;
			}
		}
		return bestMove; //returns bestMove
	}
	
	//creates possible moves for X and adds them to the given current game tree
	public void createMovesforPlayerOne(GameTree current) {
		if(current.depth%2==1) {
			System.out.println("It is Player Two's turn");
			return;
		}
		GameTree node=new GameTree(current.board);
		for(int i=0; i<3;i++) {
			for(int j=0; j<3;j++) {
				if(node.board[i][j]==EMPTY) {
					node.board[i][j]=x;
					current.addChild(node.board);
					node.board[i][j]=EMPTY;
				}
			}
		}
	}
	
	//creates possible moves for O and adds them to the given current game tree
	public void createMovesforPlayerTwo(GameTree current) {
		
		if(current.depth%2==0) {
			System.out.println("It is Player Two's turn");
			return;
		}
		
		if(isWin(current, x) || isWin(current, o)) {
			System.out.println("Cannot generate moves");
			return;
		}
		
		GameTree node=new GameTree(current.board);
		for(int i=0; i<3;i++) {
			for(int j=0; j<3;j++) {
				if(node.board[i][j]==EMPTY) {
					node.board[i][j]=o;
					current.addChild(node.board);
					node.board[i][j]=EMPTY;
				}
			}
		}
	}
	
	//function that allows the user to place a mark on the tic tac toe board using integer array positions
	public void putMark(GameTree node, int a, int b, int player){
		GameTree node2=new GameTree(node.board);
		if(a<0 || a>2 || b<0 || b>2){
			System.out.println("Invalid board position");
			return;
		}
		if(node.board[a][b]!=0) {
			System.out.println("Board position occupied");
			return;
		}
		node2.board[a][b]=player;
		//this.printBoard(node);
		node.addChild(node2.board);
		this.current=node.firstChild;
	}
	
	//prints the tic tac toe board with Xs and Os
	public void printBoard(GameTree node) {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				switch(node.board[i][j]){
				case 1:
					System.out.print("X ");
					break;
				case -1:
					System.out.print("O ");
					break;
				default:
					System.out.print("_ ");
				}
			}
			System.out.println();
		}
	}
	
	//computes the score for the given board
	int evaluate(int[][] board) {
		int score=0;
	    score += evaluateLine(board, 0, 0, 0, 1, 0, 2);  // row 0
	    score += evaluateLine(board, 1, 0, 1, 1, 1, 2);  // row 1
	    score += evaluateLine(board, 2, 0, 2, 1, 2, 2);  // row 2
	    score += evaluateLine(board, 0, 0, 1, 0, 2, 0);  // col 0
	    score += evaluateLine(board, 0, 1, 1, 1, 2, 1);  // col 1
	    score += evaluateLine(board, 0, 2, 1, 2, 2, 2);  // col 2
	    score += evaluateLine(board, 0, 0, 1, 1, 2, 2);  // diagonal
	    score += evaluateLine(board, 0, 2, 1, 1, 2, 0);  // rev diagonal
	    return score;
	}
	
	//computes a given line/series of integers that correspond with a row or column from the given board
	int evaluateLine(int[][]board, int row1, int col1, int row2, int col2, int row3, int col3) {
		int score=0;
		
		//checks the first row and col and assigns a new score
		if(board[row1][col1]==x) {
			score=1;
		} else if(board[row1][col1]==o) {
			score=-1;
		}
		
		//checks the second row and col and assigns a new score
		if(board[row2][col2]==x) {
			if(score==1) {
				score=10;
			} else if(score == -1) {
				return 0;
			} else {
				score=1;
			}
		} else if(board[row2][col2]==o){
			if(score==-1) {
				score=-10;
			} else if(score == 1) {
				return 0;
			} else {
				score=-1;
			}
		}
		
		//checks the third row and col and assigns a new score
		if(board[row3][col3]==x) {
			if(score>0) {
				score*=10;
			} else if(score<0) {
				return 0;
			} else {
				score=1;
			}
		} else if(board[row3][col3]==o) {
			if(score<0) {
				score*=10;
			} else if(score>1) {
				return 0;
			} else {
				score=-1;
			}
		}
		return score; //returns the score
	}
	
	//checks whether there is a win, loss, or tie
	public int winner(GameTree node) {
		if(isWin(node, x)) {
			return x;
		} else if(isWin(node, o)) {
			return o;
		} else {
			return 0;
		}
	}
	
	//checks the board for any possible 3 in a row of the given mark/integer 1 or -1
	public boolean isWin(GameTree node, int mark) {
		return ((node.board[0][0] + node.board[0][1] + node.board[0][2] == mark*3) // row 0
				|| (node.board[1][0] + node.board[1][1] + node.board[1][2] == mark*3) // row 1
				|| (node.board[2][0] + node.board[2][1] + node.board[2][2] == mark*3) // row 2
				|| (node.board[0][0] + node.board[1][0] + node.board[2][0] == mark*3) // column 0
				|| (node.board[0][1] + node.board[1][1] + node.board[2][1] == mark*3) // column 1
				|| (node.board[0][2] + node.board[1][2] + node.board[2][2] == mark*3) // column 2
				|| (node.board[0][0] + node.board[1][1] + node.board[2][2] == mark*3) // diagonal
				|| (node.board[2][0] + node.board[1][1] + node.board[0][2] == mark*3)); //rev diagonal
	}

}
