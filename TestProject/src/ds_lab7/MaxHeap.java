package ds_lab7;

public class MaxHeap {
	private int size; //length size of array
	private int capacity; //max size of array
	private int[] heap;
	
	public MaxHeap(int n) { //constructor with parameter of int n
		this.capacity=n;
		this.size=0;
		heap=new int [this.capacity+1];
		heap[0]=9999;
	}
	
	public MaxHeap(int [] arr) { //constructor with parameter of an int array
		this.capacity=arr.length-1;
		this.size=arr.length-1;
		heap=arr;
		heap[0]=9999;
		heapFromArray(heap);
	}
	
	//returns parent 'node' of given index
	int parent (int index) {
		return (index/2);
	}
	
	//returns leftChild 'node' of given index
	int leftChild(int index) {
		return (2*index);
	}
	
	//returns rightChild 'node' of given index
	int rightChild(int index) {
		return (2*index)+1;
	}
	
	//returns true or false based on its position of whether it is a Leaf 'node'
	boolean isLeaf(int index) {
		if(index>(size/2) && index<=size) {
			return true;
		}
		return false;
	}
	
	//swaps two indexes within the heap/array
	void swap(int index1, int index2) {
		heap[index1]=heap[index1]+heap[index2]; //a=a+b (a+b=c; a=c)
		heap[index2]=heap[index1]-heap[index2]; //b=a-b (c-b=a; b=a)
		heap[index1]=heap[index1]-heap[index2]; //a=a-b (c-a=b; a=b)
	}
	
	//turns an array into a proper heap
	void heapFromArray(int[] arr) {
		for(int i=0; i<this.size/4;i++) { //executes the for loop by 1/4 of the size
			for(int j=1; j<=this.size;j++) { //executes the heapify function through every index
				this.heapify(j);
			}
		}
	}
	
	//fixes the index when it is less than its child 'nodes'
	//so that it fits into the max heap properties
	public void heapify(int index) {
		if(isLeaf(index)) {
			return;
		}
		if(heap[index]<heap[leftChild(index)] //if the value is less than any of its children
		|| heap[index]<heap[rightChild(index)]) {
			if(heap[leftChild(index)]>heap[rightChild(index)]) { //if the left child is greater than the right child
				swap(index, leftChild(index)); //swaps the value with the left child
                heapify(leftChild(index)); //fixes the heap starting with the left child new index
			} else {
				swap(index, rightChild(index)); //swaps the value with the right child
				heapify(rightChild(index)); //fixes the heap starting with the right child new index
			}
		}
	}
	
	//adds a value into the heap
	public boolean insert(int value) {
		if(size==capacity) { //if size reaches capacity
			//System.out.println("Insertion Unsuccessful");
			return false;
		}
		heap[++size]=value; //adds size, then sets value into the heap[size]
		int current=size;
		while(heap[current]>heap[parent(current)]) { //keep executing while the current value is greater than its parent
			swap(current, parent(current)); //swaps the current with its parent
			current = parent(current); 	//the next parent index is set into current index
										//to be checked by the while loop condition
		}
		//System.out.println("Inserted Successfully");
		return true;
	}
	
	//removes the max value in the heap
	public int remove() {
		int val=heap[1]; //sets the first heap value into a temp value
		heap[1]=heap[size--]; //deletes the first heap value by setting the last index into it, then decrementing the size 
		heapify(1); //fixes the heap starting at the first index
		return val; //returns the removed value/max value if heap is proper
	}
	
	//prints the heap by array index
	public void print() {
		for(int i=1;i<=size; i++) {
			System.out.print(heap[i]+" ");
		}
		System.out.println();
	}
}
