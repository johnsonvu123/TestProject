package finals;

public class GTreePrint {
	public static void main(String[] args) {
		//case1
		GeneralTree tree = new GeneralTree();
		
		
		tree.addChild(tree.root, 15);
		GNode current=tree.root;
		tree.addChild(current, 16);
		current=tree.root.firstChild;
		tree.addSibling(current, 6);
		tree.addSibling(current, 14);
		tree.addChild(current, 11);
		tree.addChild(current, 7);
		tree.addChild(current, 9);
		current=current.nextSibling;
		tree.addChild(current, 8);
		tree.addChild(current, 30);
		tree.addChild(current, 10);
		current=current.nextSibling;
		tree.addChild(current, 10);
		tree.addChild(current, 20);
		tree.addChild(current, 18);
		
		//checking printTree function
		System.out.println("Case 1: Complete and Full Tree");
		tree.printGTree();
		
		//case2
		GeneralTree tree2 = new GeneralTree();
		
		
		tree2.addChild(tree2.root, 30);
		GNode current2=tree2.root;
		tree2.addChild(current2, 12);
		current2=tree2.root.firstChild;
		tree2.addSibling(current2, 14);
		tree2.addSibling(current2, 6);
		tree2.addChild(current2, 21);
		tree2.addChild(current2, 4);
		tree2.addChild(current2, 5);
		current2=current2.nextSibling;
		current2=current2.nextSibling;
		tree2.addChild(current2, 8);
		tree2.addChild(current2, 10);

		
		//checking printTree function
		System.out.println("Case 2: Not Full and Not Complete Tree");
		tree2.printGTree();
		
		//case3
		GeneralTree tree3 = new GeneralTree();
		
		
		tree3.addChild(tree3.root, 30);
		GNode current3=tree3.root;
		tree3.addChild(current3, 12);
		current3=tree3.root.firstChild;
		tree3.addSibling(current3, 14);
		tree3.addSibling(current3, 6);
		tree3.addChild(current3, 15);

		
		//checking printTree function
		System.out.println("Case 3: Complete but Not Full Tree");
		tree3.printGTree();
		

	}

}
