package exam2;

class ObjectID{ //question 1
	private int objID=0; //id of object
	private int priority=0; //priority of object
	private int position=0; //position of object in the array
	
	public ObjectID(int id, int order) { //constructor with two int parameters
		this.objID=id;
		this.priority=order;
		this.position=0;
	}
	
	//sets objID to the given id
	public int setObjID(int id) {
		return this.objID=id;
	}
	
	//sets priority to the given order
	public int setPriority(int order) {
		return this.priority=order;
	}
	
	//sets the position to the given index
	public int setPosition(int index) {
		return this.position=index;
	}
	
	//gets the objID
	public int getObjID() {
		return this.objID;
	}
	
	//gets the priority of object
	public int getPriority() {
		return this.priority;
	}
	
	//gets the position of object
	public int getPosition() {
		return this.position;
	}
	
}

public class MaxHeap{
	ObjectID MAXVALUE=new ObjectID(0, 999999);
	private int length; //length length of array
	private int capacity; //max length of array
	public ObjectID[] heap; //ObjectID array
	
	public MaxHeap(int n) { //constructor with parameter of int n
		this.capacity=n;
		this.length=0;
		heap=new ObjectID[this.capacity+1];
		heap[0]= MAXVALUE;
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
	
	//returns the length of the heap
	public int size() {
		return this.length;
	}
	
	//returns the max of the heap 
	public int max() {
		return this.capacity;
	}
	
	//returns true or false based on its position of whether it is a Leaf 'node'
	boolean isLeaf(int index) {
		if(index>(length/2) && index<=length) {
			return true;
		}
		return false;
	}
	
	//swaps two indexes within the heap/array
	void swap(int index1, int index2) {
		//swaps the two objects
		ObjectID data=heap[index1];
		heap[index1]=heap[index2];
		heap[index2]=data;
		
		//updates position of the objects
		heap[index1].setPosition(index1);
		heap[index2].setPosition(index2);
	}
	
	//fixes the index when it is less than its child 'nodes'
	//so that it fits into the max heap properties
	public void heapify(int index) {
		//ignores leaf nodes
		if(isLeaf(index)) {
			return;
		}
		
		//checks priority and swaps them based on certain conditions met
		if(heap[index].getPriority()<heap[leftChild(index)].getPriority() //if the value is less than any of its children
		|| heap[index].getPriority()<heap[rightChild(index)].getPriority()) {
			if(heap[leftChild(index)].getPriority()>heap[rightChild(index)].getPriority()) { //if the left child is greater than the right child
				swap(index, leftChild(index)); //swaps the value with the left child
                heapify(leftChild(index)); //fixes the heap starting with the left child new index
			} else {
				swap(index, rightChild(index)); //swaps the value with the right child
				heapify(rightChild(index)); //fixes the heap starting with the right child new index
			}
		}
		
	}
	
	//adds an ObjectID into the heap
	public boolean insert(ObjectID obj) {
		if(length==capacity) { //if length reaches capacity
			//System.out.println("Insertion Unsuccessful");
			return false;
		}
		heap[++length]=obj; //adds length, then sets value into the heap[length]
		int current=length;
		
		//updates position
		obj.setPosition(current);
		
		//fixes the heap to meet heap conditions
		while(heap[current].getPriority()>heap[parent(current)].getPriority()) { //keep executing while the current value is greater than its parent
			swap(current, parent(current)); //swaps the current with its parent
			current = parent(current); 	//the next parent index is set into current index
										//to be checked by the while loop condition
		}
		//System.out.println("Inserted Successfully");
		return true;
	}
	
	//removes the max value in the heap
	public ObjectID remove() {
		//if no values
		if(this.length==0) {
			System.out.println("No values left");
			return null;
		}
		
		//if only one value left
		if(this.length==1) {
			ObjectID val=heap[1];
			heap[1]=null;
			this.length--;
			return val;
		}
		
		//execute normally
		ObjectID val=heap[1]; //sets the first heap value into a temp value
		heap[1]=heap[length--]; //deletes the first heap value by setting the last index into it, then decrementing the length
		heapify(1); //fixes the heap starting at the first index
		heap[1].setPosition(1);
		return val; //returns the removed value/max value if heap is proper
	}
	
	//finds the given ObjectID by checking each ObjectID's id with it
	//then it returns the ObjectID if found
	public ObjectID getObjectID(int ObjectID) {
		for(int i=1;i<=this.length;i++) {
			if(heap[i].getObjID()==ObjectID) {
				return heap[i];
			}
		}
		return null;
	}
	
	//prints the heap
	public void print() {
		if(this.length>1) { //if length is greater than 1
			for(int i=1;i<=length; i++) {
				System.out.print("ObjectID: "+heap[i].getObjID()
						+" Priority: "+heap[i].getPriority()
						+" Position: "+heap[i].getPosition());
				System.out.println();
			}
			System.out.println();
		} else if(this.length==1){ //if length is equal to 1
			System.out.print("ObjectID: "+heap[1].getObjID()
					+" Priority: "+heap[1].getPriority()
					+" Position: "+heap[1].getPosition());
			System.out.println("\n");
		}else { //if length is 0/ otherwise
			System.out.println("No values to print\n");
		}
	}
	
	//prints the ids by array index
	public void printArray() {
		if(this.length>1) { //if length is greater than 1
			for(int i=1;i<=length; i++) {
				System.out.print("ObjectID: "+heap[i].getObjID()+" ");
			}
			System.out.println();
		} else if(this.length==1){ //if length is equal to 1
			System.out.println("ObjectID: "+heap[1].getObjID()+" ");
		}else { //if length is 0/ otherwise
			System.out.println("No values to print");
		}
	}
}
