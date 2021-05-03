package finals;

class BNode{
	int value, height;
	BNode left;
	BNode right;
	
	BNode(int val){
		this.value=val;
		this.height=1;
		this.left=null;
		this.right=null;
	}
	
}

public class BTree {
	BNode root;
	int length=0;
	
	//returns boolean value whether tree is empty or not
	public boolean isTreeEmpty() {
		if(root==null) { //if root is null, all is null
			return true;
		} else { //else the tree is not empty
			return false;
		}
	}
	
	//returns the size of the tree
	public int size() {
		return this.length;
	}
	
	//returns the height of the tree node
	public int height(BNode x) {
		if(x==null) { //if root is null, tree is empty
			return 0;
		} else {
			return x.height;
		}
	}
	
    //returns the greater value of two integers 
    int max(int a, int b) 
    { 
        return (a > b) ? a : b; 
    }
	
	//simpler call for insert
	public BNode insert(int val) {
		return this.root=insert(this.root, val);
	}
	
	//adds a value into the binary Tree
	public BNode insert(BNode x, int val) {
		if(x==null) { //inserts new value
			//System.out.println("Inserted "+ val +" successfully");
			this.length++;
			return (new BNode(val));
		}
		 //checks where the new value should go/search
		if(val < x.value) { //if val is less than the value of x, check the left values of x
			x.left = insert(x.left, val);
		} else if(val > x.value) { //if val is greater than the value of x, check the right values of x
			x.right = insert(x.right, val);
		} else { //if the value is equal
			System.out.println("No duplicate values allowed");
			return x;
		}
		
		//update height
		x.height=max(height(x.left),height(x.right))+1;
		return x; //returns the unchanged tree node
	}
	
	//prints the binary tree
	//limited on number of values printed from tree 
	//the further the levels go as space is limited
	public void printBTree(BNode root) {
		GQueue<BNode> queue=new GQueue<BNode>(); //queue for values
		GQueue<Character> queue2=new GQueue<Character>(); //queue for branches/drawing of tree
		BNode nullValue=new BNode(0); //represents the empty leaf nodes with values of 0
		queue.enqueue(root); //start with the root in queue
		
		//integer variables for the spacing and drawing
		int space=this.length*2; //front space for each level
		int space2=16; //space in between each value
		int maxlvl=1; //counter for level of tree
		int max=this.root.height; //integer value for calculations
		int count=0; //counter for each value within a level
		
		//while loop to draw to tree until the condition is met within the loop
		while(true) {
			int a=queue.size();
			
			//start the spacing
			for(int i=space; i>=0;i--) {
				System.out.print(" ");
			}
			
			while(a>0) {
				BNode curr=queue.peek(); //get the top of queue
				queue.dequeue(); //remove the top of queue
				
				//prints values
				if(curr.value==0) { //prints space for empty children
					System.out.print(" ");
				} else {
					System.out.print(curr.value); //print the value of temp
				}
				
				//for each odd positioned value/ the left children
				if(count%2==0) {
					System.out.print(" ");
					if(curr.value<10) { //prints the normal amount of spaces for 1-digit numbers
						for(int i=0; i<(space2);i++) {
							System.out.print(" ");
						}
					} else { //prints one less space for 2 or more digit numbers
						for(int i=0; i<(space2)-1;i++) {
							System.out.print(" ");
						}
					}
				} else { //for every even positioned value/ the right children
					if(curr.value<10) { //prints the normal amount of spaces for 1-digit numbers
						for(int i=0; i<(space2);i++) {
							System.out.print(" ");
						}
					} else { //prints one less space for 2 or more digit numbers
						for(int i=0; i<(space2)-1;i++) {
							System.out.print(" ");
						}
					}
				}
				count++; //increment count
				
				//adds left and right children or delimiters
				if(curr.left==null) { //add delimiter
					queue.enqueue(nullValue);
					queue2.enqueue(' ');
				} else { //add left child and branch
					queue.enqueue(curr.left);
					queue2.enqueue('/');
				}
				if(curr.right==null) { //add delimiter
					queue.enqueue(nullValue);
					queue2.enqueue(' ');
				} else { //add right child and branch
					queue.enqueue(curr.right);
					queue2.enqueue('\\');
				}
				a--;
			}
			count=0; //reset count
			maxlvl++; //increment maxlvl
			space=space-max; //reduce space by subtracting it with max
			max--; //decrement max
			space2=space2/2; //reduce space2 by dividing it with 2
			
			//condition to stop while loop
			if(maxlvl==this.root.height+1) { //if maxlvl reaches further than the lowest depth of tree
				System.out.println();
				break; //stop the while loop
			}
			System.out.println(); //continue to next line for branches
			
			//prints spaces before
			int b=queue2.size();
			for(int i=space; i>=0;i--) {
				System.out.print(" ");
			}
			
			//copying same format for printing space and values but instead
			//of printing values, the branches are printed
			while(b>0) {
				char ch=queue2.peek();
				queue2.dequeue();
				System.out.print(ch);
				
				if(count%2==0) { //for odd positions corresponding to left children
					//prints spaces after
					for(int i=0; i<(space2);i++) {
						System.out.print(" ");
					}
				} else { //for even positions corresponding to right children
					//prints spaces after
					for(int i=0; i<(space2)+1;i++) {
						System.out.print(" ");
					}
				}
				count++; //increment count
				b--; //decrement b
			}
			space--; //decrement space
			count=0; //reset count
			System.out.println(); //continue to next line for the next level of values
		}
	}
}

