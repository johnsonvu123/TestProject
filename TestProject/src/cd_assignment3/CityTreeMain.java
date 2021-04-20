package cd_assignment3;

public class CityTreeMain {
	public static void main(String[] args) {
		/* Running Time Statistics
		 * insert function: O(log n)
		 * deleteCity function (by name): O(log n)
		 * deleteCoor function (by coordinates): O(n)
		 * search function (by name): O(log n)
		 * searchCoor function (by coordinates): O(n)
		 * 
		 * insert, deleteCity, and search can be implemented
		 * reasonably in log n time using a BST
		 * 
		 * The database system could be made more efficient
		 * by using one or more BSTs to organize the records by location
		 * as the delete and search runtimes for location 
		 * would be O(log n) rather than O(n).
		 */
		CityTree tree=new CityTree();
		
		//checking insertion function
		tree.insert("Vancouver", 10, 20);
		tree.insert("Atlanta", 20, 50);
		tree.insert("San Jose", 60, 10);
		tree.insert("San Jose", 60, 10);
		tree.insert("Santa Monica", 40, 50);
		tree.insert("Sacremento", 60, 20);
		tree.insert("San Diego", 60, 30);
		
		//checking traversal function
		System.out.println("PreOrder: ");
		tree.preOrderTraversal();
		System.out.println("InOrder: ");
		tree.inOrderTraversal();
		System.out.println("PostOrder: ");
		tree.postOrderTraversal();
		
		//checking print records within given point and distance
		System.out.println("Print All Records in Given Distance: ");
		tree.printAll(10, 50);
		System.out.println("Print All Records in Given Distance: ");
		tree.printAll(20,30);
		
		//checking delete function with city name
		tree.delete("San Diego");
		tree.delete("San Jose");
		tree.delete("Santa");
		tree.delete("Santa");
		
		//checking delete function with coordinates
		tree.delete(60, 30); //San Diego
		tree.delete(60, 10); //San Jose
		tree.delete(10, 10); //Wrong coor
		tree.delete(20, 20); //Wrong coor
		
		//checking traversal function
		System.out.println("PreOrder: ");
		tree.preOrderTraversal();
		System.out.println("InOrder: ");
		tree.inOrderTraversal();
		System.out.println("PostOrder: ");
		tree.postOrderTraversal();
		
		//checking print records within given point and distance
		System.out.println("Print All Records in Given Distance: ");
		tree.printAll(10, 50);
		System.out.println("Print All Records in Given Distance: ");
		tree.printAll(20,30);
		
		//checking search function with city name
		System.out.println("Search by city name:");
		System.out.println(tree.search("San Diego")); //deleted city case
		System.out.println(tree.search("Santa Monica")); //right case
		System.out.println(tree.search("San Jose")); //deleted city case
		System.out.println(tree.search("San")); //wrong case
		System.out.println(tree.search("Vancouver")); //right case
		
		//checking search function with city coordinates
		System.out.println("Search by city coordinates:");
		System.out.println(tree.search(20, 50)); //Atlanta coordinates
		System.out.println(tree.search(40, 50)); //Santa Monica coordinates
		System.out.println(tree.search(60, 30)); //deleted coordinates
		System.out.println(tree.search(10, 10)); //wrong coordinates
		System.out.println(tree.search(20, 20)); //wrong coordinates
	}

}
