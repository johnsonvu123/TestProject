package ds_lab7;

public class MaxHeapMain {
	public static void main(String[] args) {
		System.out.println("Heap with given size: ");
		
		//heap with integer parameter
		MaxHeap heap=new MaxHeap(11);
		
		//checking insert function
		heap.insert(6);
		heap.insert(13);
		heap.insert(10);
		heap.insert(20);
		heap.insert(56);
		heap.insert(63);
		heap.insert(5);
		heap.insert(12);
		heap.insert(19);
		heap.insert(32);
		heap.insert(32);
		heap.insert(20);
		
		//checking print function
		heap.print();
		
		//checking remove function
		System.out.println("Max value is "+heap.remove());
		System.out.println("Max value is "+heap.remove());
		System.out.println("Max value is "+heap.remove());
		
		//checking print function after remove
		heap.print();
		
		System.out.println();
		
		System.out.println("Heap from Array: ");
		
		//changing an int array into a heap, 
		//the value at index 0 needs to be no important value
		int arr[]= {0, 69, 2, 5, 1, 34, 21, 19, 30, 18, 12, 49};
		
		//heap with an int array parameter
		MaxHeap heap2=new MaxHeap(arr);
		
		//checking the heap
		heap2.print();
		
		//checking heap insertion
		heap2.insert(49);
		
		//checking remove function
		System.out.println("Max value is "+heap2.remove());
		System.out.println("Max value is "+heap2.remove());
		System.out.println("Max value is "+heap2.remove());
		
		//checking print function after remove
		heap2.print();
	}
}
