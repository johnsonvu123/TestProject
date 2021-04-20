package cd_assignment3;

public class GameTree {
	int depth=0; //depth of node
	int value=0; //minimax value of node
	int board[][]=new int[3][3];
	GameTree firstChild; //first child node
	GameTree nextSibling; //sibling nodes of child
	
	GameTree() { //constructor with no parameter
		for(int i=0; i<9; i++) {
			board[i/3][i%3]= 0; //fills in with 0
		}
		firstChild=null; //set to null
		nextSibling=null; //set to null
	}
	
	GameTree(int newBoard[][]) { //constructor with parameter 2d int array
		for(int i=0; i<9; i++) {
			board[i/3][i%3]= newBoard[i/3][i%3]; //fills the board with values from the given array
		}
		firstChild=null; //set to null
		nextSibling=null; //set to null
	}
	
	//returns the depth value
	int depth() {
		return this.depth;
	}
	
	//adds a child node with the given array if there isn't one
	void addChild(int newBoard[][]) {
		if(this.firstChild ==null) { //add child node if first child is null
			this.firstChild=new GameTree(newBoard);
			this.firstChild.depth=depth+1; //update the depth
			//System.out.println(this.firstChild.depth);
		} else { //otherwise add sibling
			this.firstChild.addSibling(newBoard);
		}
	}
	
	//adds a sibling node with the given array
	void addSibling(int newBoard[][]) {
		GameTree newMove=new GameTree(newBoard);
		if(this.nextSibling ==null) { //if next sibling is null, add one
			this.nextSibling=newMove;
			this.nextSibling.depth=this.depth; //set depth to the depth of its sibling
		} else {
			GameTree curr=this.nextSibling;
			while(curr.nextSibling!=null) { //continue through each sibling until null is reached
				curr=curr.nextSibling;
			}
			curr.nextSibling=newMove; //add sibling after reaching null
			curr.nextSibling.depth=this.depth; //set depth to the depth of its sibling
		}
	}
}
