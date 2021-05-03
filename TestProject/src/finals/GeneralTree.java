package finals;

class GNode{
	int value, depth, height;
	GNode firstChild;
	GNode nextSibling;
	
	GNode(){
		this.value=0;
		this.depth=0;
		this.height=1;
		firstChild=null;
		nextSibling=null;
	}
	
	GNode(int val){
		this.value=val;
		this.depth=0;
		this.height=1;
		firstChild=null;
		nextSibling=null;
	}
	
	//adds a child with the given value
	void addChildNode(int val) {
		if(this.firstChild ==null) { //add child node if first child is null
			this.firstChild=new GNode(val);
			this.firstChild.depth=depth+1; //update the depth
			//System.out.println(this.firstChild.depth);
		} else { //otherwise add sibling
			this.firstChild.addSiblingNode(val);
		}
	}
	
	//adds a sibling node with the given value
	void addSiblingNode(int val) {
		GNode newNode=new GNode(val);
		if(this.nextSibling ==null) { //if next sibling is null, add one
			this.nextSibling=newNode;
			this.nextSibling.depth=this.depth; //set depth to the depth of its sibling
		} else {
			GNode curr=this.nextSibling;
			while(curr.nextSibling!=null) { //continue through each sibling until null is reached
				curr=curr.nextSibling;
			}
			curr.nextSibling=newNode; //add sibling after reaching null
			curr.nextSibling.depth=this.depth; //set depth to the depth of its sibling
		}
	}
}

public class GeneralTree {
	GNode root;
	int length;
	
	//sets the root node to the value
	void setRoot(int val) {
		root=new GNode(val);
	}
	
	//adds a child node
	public void addChild(GNode current, int val) {
		if(this.root==null) {
			setRoot(val);
			this.length++;
		} else {
			current.addChildNode(val);
			this.length++;
		}
	}
	
	//adds a sibling node
	public void addSibling(GNode current, int val) {
		if(current==null) {
			return;
		}
		current.addSiblingNode(val);
		this.length++;
	}
	
	//returns the size of tree
	public int size() {
		return this.length;
	}
	
    //draw function for general tree/specifically a 3-ary tree
    //limited to only three levels and three children nodes per parent for better look 
	public void printGTree() {
		if(root==null) { //if there is no general tree
			return;
		}
		GQueue<GNode> queue=new GQueue<GNode>(); //queue to print values
		GQueue<Character> queue2= new GQueue<Character>(); //queue to print the branches
		GNode nullValue=new GNode(0); //represents the empty leaf nodes with values of 0
		queue.enqueue(root); //start with the root in queue
		int space=this.length*2; //front space for tree
		int maxlvl=1; //keeps track of the level for the tree
		int extraspace=6; //extra space to try and make the tree look better if possible
		
		while(true) {
			int a=queue.size();
			
			//start the spacing
			if(maxlvl==1) { //extra space for the root
				System.out.print("   ");
			}
			//prints spaces for each level
			for(int i=space; i>=0;i--) {
				System.out.print(" ");
			}
			
			//prints every value in the level
			while(a>0) {
				GNode temp=queue.peek(); //set first item from queue into temp
				queue.dequeue(); //remove first item from queue
				
				//prints values
				if(temp.value==0) { //prints space for empty children
					System.out.print(" ");
				} else {
					System.out.print(temp.value); //print the value of temp
				}
				
				//prints spaces after if need be
				if(extraspace>0) { //prints extra spaces to align the value with the branch
					for(int i=0;i<extraspace;i++) {
						System.out.print(" ");
					}
					extraspace*=2;
				}
				
				//prints spaces after
				if(temp.value<10) { //prints the normal amount of spaces for 1-digit numbers
					for(int i=0; i<(space);i++) {
						System.out.print(" ");
					}
				} else { //prints one less space for 2 or more digit numbers
					for(int i=0; i<(space)-1;i++) {
						System.out.print(" ");
					}
				}
				
				GNode temp2=temp.firstChild; //set temp2 to the first child
				
				// add all the children of the parent node/
				// add all the siblings of the first child
				if(temp2==null) { //if the first child is not present
					for(int i=0;i<3;i++) {
						queue.enqueue(nullValue); //add delimiter for values
						queue2.enqueue(' '); //add delimiter for branches
					}
				} else { //add all children of temp starting with the first child/temp2
					int count=0; //keeps track of number of children added
					while(temp2!=null) {
						queue.enqueue(temp2); //add temp2
						if(count==0) { //if first child
							queue2.enqueue('/');
						} else if(count==1) { //if second child
							queue2.enqueue('|');
						} else if(count==2) { //if third child
							queue2.enqueue('\\');
						}
						temp2=temp2.nextSibling;
						count++;
					}
					for(int i=count; i<=3;i++) { //adds a number of delimiters based on count
						queue.enqueue(nullValue);
						queue2.enqueue(' ');
					}
				}
				a--; //decrement a
				if(extraspace>0) { //when extraspace is greater than 0, reduce it
					extraspace=(extraspace/2)-2;
				}
			}
			
			//setting up the branches and updating variables
			maxlvl++; //increment maxlvl
			int extraspace2=extraspace-1; //copy extraspace -1
			space=(space/maxlvl); //reduce space by dividing it by the max lvl
			
			//condition to stop while loop
			if(maxlvl==4) { //if maxlvl reaches past the third level
				System.out.println();
				break; //stop the while loop
			}
			System.out.println(); //continue to next line for branches
			
			//prints spaces before
			int b=queue2.size();
			for(int i=space+1; i>=0;i--) {
				System.out.print(" ");
			}
			
			//copying same format for printing space and values but instead
			//of printing values, the branches are printed
			while(b>0) {
				char ch=queue2.peek();
				queue2.dequeue();
				System.out.print(ch);
				
				//prints extra spaces if need be
				if(extraspace2>0) {
					for(int i=0;i<extraspace2;i++) {
						System.out.print(" ");
					}
					extraspace2*=2;
				}
				
				//prints spaces after
				for(int i=0; i<(space);i++) {
					System.out.print(" ");
				}
				b--; //decrement b
				if(extraspace2>0) { //when extraspace2 is greater than 0, reduce it
					extraspace2=(extraspace2/2)-2;
				}
			}
			System.out.println(); //continue to next line for the next level of values
		}
		//end of program
		System.out.println();
		
	}
}
