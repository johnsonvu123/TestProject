package ds_lab6;

public class AVLTreeMain {
	public static void main(String[] args) {
		AVLTree tree=new AVLTree();
		
		//checking insertion function
		tree.insert(20);
		tree.insert(10);
		tree.insert(30);
		tree.insert(30); //duplicate value
		tree.insert(40);
		tree.insert(50);
		tree.insert(60);
		tree.insert(70);
		tree.insert(5);
		tree.insert(4);
		tree.insert(25);
		tree.insert(24);
		
		//checking traversal function
		System.out.println("PreOrder: ");
		tree.preOrderTraversal();
		System.out.println("InOrder: ");
		tree.inOrderTraversal();
		System.out.println("PostOrder: ");
		tree.postOrderTraversal();
		
		//checking search function
		System.out.println(tree.search(20));
		System.out.println(tree.search(35)); //false check
		System.out.println(tree.search(30));
		System.out.println(tree.search(70));
		
		//checking deletion function
		tree.delete(20);
		tree.delete(30);
		tree.delete(40);
		tree.delete(5);
		tree.delete(60);
		
		//checking traversal function after deletion
		System.out.println("PreOrder: ");
		tree.preOrderTraversal();
		System.out.println("InOrder: ");
		tree.inOrderTraversal();
		System.out.println("PostOrder: ");
		tree.postOrderTraversal();
	}

}
