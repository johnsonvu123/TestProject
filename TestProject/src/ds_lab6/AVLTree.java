package ds_lab6;

class TreeNode {
	int key, height; //key/value and height
	TreeNode left, right; // left and right TreeNodes
	
	TreeNode(int val) { //TreeNode constructor
		key=val;
		height=1;
	}
}

public class AVLTree {
	TreeNode root;
	
	//returns boolean value whether tree is empty or not
	public boolean isTreeEmpty() {
		if(root==null) { //if root is null, all is null
			return true;
		} else { //else the tree is not empty
			return false;
		}
	}
	
	//returns the height of the tree node
	public int height(TreeNode x) {
		if(x==null) { //if root is null, tree is empty
			return 0;
		} else {
			return x.height;
		}
	}
	
    // returns the greater value of two integers 
    int max(int a, int b) 
    { 
        return (a > b) ? a : b; 
    }
	
    //returns the balance factor of given tree node
	public int getBF(TreeNode x) {
		if(x==null) {
			return 0;
		}
		return height(x.left)-height(x.right); 
	}
	
	//rotates nodes to the right
	public TreeNode rightRotate(TreeNode b) {
		TreeNode a=b.left; //a is the left node of b
		TreeNode c=a.right; //c is the right node of a
		
		a.right=b; //the right node of a is now b
		b.left=c; //the left node of b is now c
		
		/*
		 *         b		     a
		 *        /			    / \ 
		 *       a		->	   d   b
		 *      / \			      /
		 *     d   c		     c
		 */
		
		//updates the height of b and a
        b.height = max(height(b.left), height(b.right)) + 1; 
        a.height = max(height(a.left), height(a.right)) + 1; 
		
		return a; //returns the updated node
	}
	
	//rotates the nodes to the left
	public TreeNode leftRotate(TreeNode a) {
		TreeNode b=a.right; //b is the right node of a
		TreeNode c=b.left; //c is the left node of b
		
		b.left=a; //the left node of b becomes the a node (the value/node will take a's place)
		a.right=c; 	//the right node of a becomes the c node 
					//(whatever value/node is left of b will instead be positioned to the right of a)
		/*
		 *     a			     b
		 *      \			    / \ 
		 *       b		->	   a   d
		 *      / \			    \
		 *     c   d		     c
		 */
		
		//updates the height of b and a
        b.height = max(height(b.left), height(b.right)) + 1; 
        a.height = max(height(a.left), height(a.right)) + 1;
		
		return b; //returns the updated node
	}
	
	//simpler call for insert
	public TreeNode insert(int val) {
		return this.root=insert(this.root, val);
	}
	
	//adds a value into the AVL Tree which will self balance
	TreeNode insert(TreeNode x, int val) {
		if(x==null) { //inserts new value
			System.out.println("Inserted "+ val +" successfully");
			return (new TreeNode(val));
		}
		 //checks where the new value should go/search
		if(val < x.key) { //if val is less than the key of x, check the left values of x
			x.left = insert(x.left, val);
		} else if(val > x.key) { //if val is greater than the key of x, check the right values of x
			x.right = insert(x.right, val);
		} else { //if the value is equal
			System.out.println("No duplicate values allowed");
			return x;
		}
		
		//update height
		x.height=max(height(x.left),height(x.right))+1;
		
		//get balance factor
		int bf=getBF(x);
		
		//checks if node became unbalanced after insertion
		//LL case
		if(bf>1 && val < x.left.key) {
			return rightRotate(x);
		}
		//RR case
		if(bf<-1 && val > x.right.key) {
			return leftRotate(x);
		}
		//LR case
		if(bf>1 && val > x.left.key) {
			x.left=leftRotate(x.left);
			return rightRotate(x);
		}
		//RL case
		if(bf<-1 && val < x.right.key) {
			x.right=rightRotate(x.right);
			return leftRotate(x);
		}
		
		return x; //returns the unchanged tree node
	}
	
	//returns minimum value found in the given tree
	TreeNode minVal(TreeNode x) {
		TreeNode curr=x;
		while(curr.left != null) {
			curr=curr.left;
		}
		return curr;
	}
	
	//simpler call to deletion function
	public TreeNode delete(int val) {
		return this.root=deleteNode(this.root, val);
	}
	
	//removes the given value from the avl tree
	TreeNode deleteNode(TreeNode x, int val) {
		if(x==null) {
			return x;
		}
		
		//checks for the value that needs to be removed
		if(val<x.key) {
			x.left=deleteNode(x.left, val);
		} else if (val>x.key){
			x.right=deleteNode(x.right, val);
		} else { //removes the value once found
			if((x.left == null) || (x.right == null)){ 	//removal of a subtree with one leaf
														//or removal of a possible leaf
				TreeNode temp = null;
				if(temp==x.left) { //if left is null
					temp=x.right; //temp will equal the node to the right of x, the right leaf of x
				} else { //else / if left is not null
					temp=x.left; //temp will equal the node to the left of x, the left leaf of x
				}
				if(temp==null) { //if temp is null / if left and right nodes are null / x is a leaf
					temp=x; //temp will equal x which is a leaf
					x=null; //nulls x
				} else { //if temp is not null /there is a left or right node / x is a subtree with one leaf
					x=temp; //x becomes temp
				}
			} else { //removal of a sub tree/ if x has both left and right nodes with values
				TreeNode temp=minVal(x.right);
				x.key=temp.key;	//replaces the key of x with the next appropriate
								//value which is the minimum value of the right node of x
				x.right=deleteNode(x.right, temp.key); 	//removing the original position of the value 
														//that replaced the removed value, so it does not appear twice
			}
		}
		
		if(x==null) {
			return x;
		}
		
		//updating the height of x
		x.height=max(height(x.left), height(x.right))+1;
		
		//getting the balance factor of x
		int bf=getBF(x);
		
		//checking for imbalances and fixing them
		//LL case
		if(bf>1 && getBF(x.left)>=0) {
			return rightRotate(x);
		}
		//RR case
		if(bf<-1 && getBF(x.right)<=0) {
			return leftRotate(x);
		}
		//LR case
		if(bf>1 && getBF(x.left)<0) {
			x.left=leftRotate(x.left);
			return rightRotate(x);
		}
		//RL case
		if(bf<-1 && getBF(x.right)>0) {
			x.right=rightRotate(x.right);
			return leftRotate(x);
		}
		
		return x; //returns the unchanged tree node
	}
	
	//searches for the given value
	public boolean search(int value) {
		TreeNode curr=this.root; //current set to the root
		while(curr!=null) { //while current is not null
			if(curr.key==value) { //if the value equals the current key, return true
				return true;
			}
			if(curr.key>value) { //if the value is less than the current key, move current to the less node
				curr=curr.left;
			} else if(curr.key<value){
				curr=curr.right; //if the value is greater than the current key, move current to the right node
			} else { //otherwise, the value is not in the tree
				return false;
			}
		}
		return false; //return false by default
	}
	
	//prints the tree in preorder
	void preOrder(TreeNode current){
		if(current==null){
			return;
		}

		System.out.print(current.key+" ");
		preOrder(current.left);
		preOrder(current.right);
	}
	
	//simpler call to preorder function
	public void preOrderTraversal(){
		this.preOrder(this.root);
		System.out.println();
	}
	
	//prints the tree in inorder
	void inOrder(TreeNode current){
		if(current==null){
			return;
		}

		inOrder(current.left);
		System.out.print(current.key+" ");
		inOrder(current.right);
	}
	
	//simpler call to inorder function
	public void inOrderTraversal(){
		this.inOrder(this.root);
		System.out.println();
	}
	
	//prints the tree in postorder
	void postOrder(TreeNode current){
		if(current==null){
			return;
		}

		postOrder(current.left);
		postOrder(current.right);
		System.out.print(current.key+" ");
	}
	
	//simpler call to inorder function
	public void postOrderTraversal(){
		this.postOrder(this.root);
		System.out.println();
	}
}
