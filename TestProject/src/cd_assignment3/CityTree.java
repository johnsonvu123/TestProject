package cd_assignment3;

class TreeNode {
	String city; //city name
	int x, y, height; //x and y coordinates, height
	TreeNode left, right; // left and right TreeNodes
	
	TreeNode(String str, int a, int b) { //TreeNode constructor
		city=str;
		x=a;
		y=b;
		height=1;
	}
}

public class CityTree {
	TreeNode root;
	
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
		TreeNode a=b.left;
		TreeNode c=a.right;
		
		a.right=b;
		b.left=c;
		
        b.height = max(height(b.left), height(b.right)) + 1; 
        a.height = max(height(a.left), height(a.right)) + 1; 
		
		return a;
	}
	
	//rotates the nodes to the left
	public TreeNode leftRotate(TreeNode a) {
		TreeNode b=a.right;
		TreeNode c=b.left;
		
		b.left=a;
		a.right=c;
		
        b.height = max(height(b.left), height(b.right)) + 1; 
        a.height = max(height(a.left), height(a.right)) + 1;
		
		return b;
	}
	
	//returns minimum value found in the given tree
	TreeNode minVal(TreeNode x) {
		TreeNode curr=x;
		while(curr.left != null) {
			curr=curr.left;
		}
		return curr;
	}

	//adds a city into the AVL Tree which will self balance
	TreeNode insert(TreeNode x, String str, int a, int b) {
		
		if(x==null) { //inserts new value
			System.out.println("Inserted "+str+" successfully");
			return (new TreeNode(str, a, b));
		}
		
		if(compareStr(x.city,str)) {
			System.out.println("Same city");
			return x;
		}
		
		 //checks where the new city should go/search
		if(compareLesserAlpha(str, x.city)) {
			x.left = insert(x.left, str, a, b);
		} else if(compareGreaterAlpha(str, x.city)) { 
			x.right = insert(x.right, str, a, b);
		}
		
		//update height
		x.height=max(height(x.left),height(x.right))+1;
		
		//get balance factor
		int bf=getBF(x);
		
		//checks if node became unbalanced after insertion
		//LL case
		if(bf>1 && compareLesserAlpha(str, x.left.city)) {
			return rightRotate(x);
		}
		//RR case (int)
		if(bf<-1 && compareGreaterAlpha(str, x.right.city)) {
			return leftRotate(x);
		}
		//LR case
		if(bf>1 && compareGreaterAlpha(str, x.left.city)) {
			x.left=leftRotate(x.left);
			return rightRotate(x);
		}
		//RL case
		if(bf<-1 && compareLesserAlpha(str, x.right.city)) {
			x.right=rightRotate(x.right);
			return leftRotate(x);
		}
		
		return x; //returns the unchanged tree node
	}
	
	//simpler call for insert
	public TreeNode insert(String str, int a, int b) {
		return this.root=insert(this.root, str, a, b);
	}
	
	//removes the given string from the avl tree
	TreeNode deleteCity(TreeNode x, String str) {
		if(x==null) {
			return x;
		}
		
		if(compareLesserAlpha(str,x.city)) {
			x.left=deleteCity(x.left, str);
		} else if (compareGreaterAlpha(str,x.city)){
			x.right=deleteCity(x.right, str);
		} else {
			if((x.left == null) || (x.right == null)){
				TreeNode temp = null;
				if(temp==x.left) {
					temp=x.right;
				} else {
					temp=x.left;
				}
				if(temp==null) {
					temp=x;
					x=null;
				} else {
					x=temp;
				}
			} else {
				TreeNode temp=minVal(x.right);
				x.city=temp.city;
				x.x=temp.x;
				x.y=temp.y;
				x.right=deleteCity(x.right, temp.city);
			}
		}
		
		if(x==null) {
			return x;
		}
		x.height=max(height(x.left), height(x.right))+1;
		int bf=getBF(x);
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
	
	//removes the city by the given coordinates from the avl tree
	TreeNode deleteCoor(TreeNode node, int a, int b) {
		if(node==null) {
			return null;
		}
		//System.out.println(node.city+": x="+node.x+", y="+node.y);
		//System.out.println(a+", "+b);
		if(a==node.x && b==node.y) {
			//System.out.println("Deleted city");
			return deleteCity(node, node.city);
		} else {
			//System.out.println();
			node.left = deleteCoor(node.left, a, b);
			node.right = deleteCoor(node.right, a, b);
		}
		return node;
	}
	
	//simpler call to deleteCity function
	public TreeNode delete(String str) {
		return this.root=deleteCity(this.root, str);
	}
	
	//simpler call to deleteCoor function
	public TreeNode delete(int a, int b) {
		return deleteCoor(this.root, a, b);
	}
	
	//searches for the given city
	public boolean search(String str) {
		TreeNode curr=this.root;
		while(curr!=null) {
			if(compareStr(curr.city, str)) {
				return true;
			}
			if(compareGreaterAlpha(curr.city, str)) {
				curr=curr.left;
			} else if(compareLesserAlpha(curr.city,str)){
				curr=curr.right;
			} else {
				return false;
			}
		}
		return false;
	}
	
	//searches the city based on the given coordinates
	boolean searchCoor(TreeNode node, int a, int b) {
		if(node==null) {
			return false;
		}
		//System.out.println(node.city+": x="+node.x+", y="+node.y);
		//System.out.println(a+", "+b);
		if(node.x==a && node.y==b) {
			//System.out.println("Found");
			return true;
		} else {
			if(searchCoor(node.left, a, b)) {
				return true;
			}
			if(searchCoor(node.right, a, b)){
				return true;
			}
			//System.out.println("End");
		}
		return false;
	}
	
	//simpler call to searchCoor function
	public boolean search(int a, int b) {
		return searchCoor(this.root, a, b);
	}
	
	//checks if two strings are the same, returns true if they are
	boolean compareStr(String str1, String str2) {
		char curr=str1.charAt(0), curr2=str2.charAt(0);
		int count=0;
		for(int i=0; i<str1.length() && i<str2.length();i++) {
			if(curr==curr2) {
				curr=str1.charAt(i);
				curr2=str2.charAt(i);
				count++;
			}
		}
		if(count==str1.length() && count==str2.length()) {
			return true;
		} else {
			return false;
		}
	}
	
	//checks if two strings are different, returns true if the first one is 'greater than' the second one
	boolean compareGreaterAlpha(String str1, String str2) {
		char curr=str1.charAt(0), curr2=str2.charAt(0);
		for(int i=0; i<str1.length() && i<str2.length();i++) {
			if(curr==curr2) {
				curr=str1.charAt(i);
				curr2=str2.charAt(i);
			} else {
				break;
			}
		}
		if(curr>curr2) {
			return true;
		} else if(curr==curr2 && str1.length()>str2.length()){
			return true;
		} else {
			return false;
		}
	}
	
	//checks if two strings are different, returns true if the first one is 'less than' the second one
	boolean compareLesserAlpha(String str1, String str2) {
		char curr=str1.charAt(0), curr2=str2.charAt(0);
		for(int i=0; i<str1.length() && i<str2.length();i++) {
			if(curr==curr2) {
				curr=str1.charAt(i);
				curr2=str2.charAt(i);
			} else {
				break;
			}
		}
		if(curr<curr2) {
			return true;
		} else if(curr==curr2 && str1.length()<str2.length()){
			return true;
		} else {
			return false;
		}
	}
	
	//prints the tree in preorder
	void preOrder(TreeNode current){
		if(current==null){
			return;
		}

		System.out.print(current.city+" ");
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
		System.out.print(current.city+" ");
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
		System.out.print(current.city+" ");
	}
	
	//simpler call to inorder function
	public void postOrderTraversal(){
		this.postOrder(this.root);
		System.out.println();
	}
	
	void printAllGivenDistance(TreeNode current, int startPoint, int distance) {
		if(current==null) {
			return;
		}
		
		int endPoint=startPoint+distance;
		printAllGivenDistance(current.left, startPoint, distance);
		if(current.x<=endPoint && current.x>=startPoint) {
			if(current.y<=endPoint && current.y>=startPoint) {
				System.out.print(current.city+" ");
			}
		}
		printAllGivenDistance(current.right, startPoint, distance);
	}
	
	public void printAll(int startPoint, int distance) {
		this.printAllGivenDistance(this.root, startPoint, distance);
		System.out.println();
	}
}
