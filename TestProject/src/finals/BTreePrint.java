package finals;

public class BTreePrint {
	public static void main(String[] args) {
		//case1
		BTree tree3 = new BTree();
		
		//filling tree3 up to 15 values
		tree3.insert(15);
		tree3.insert(6);
		tree3.insert(14);
		tree3.insert(16);
		tree3.insert(8);
		tree3.insert(30);
		tree3.insert(10);
		tree3.insert(4);
		tree3.insert(3);
		tree3.insert(7);
		tree3.insert(13);
		tree3.insert(5);
		tree3.insert(9);
		tree3.insert(20);
		tree3.insert(31);
		
		//checking printTree function
		System.out.println("Case 1: Binary Tree");
		tree3.printBTree(tree3.root);
		
		System.out.println();
		
		//case 2
		BTree tree4 = new BTree();
		
		//filling the tree partially
		tree4.insert(20);
		tree4.insert(6);
		tree4.insert(9);
		tree4.insert(8);
		tree4.insert(30);
		tree4.insert(5);
		
		//checking printTree function
		System.out.println("Case 2: Binary Tree 2");
		tree4.printBTree(tree4.root);
	}

}
