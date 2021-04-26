package exam2;

public class PriorityQueue { //question 1
	private MaxHeap queue;
	
	PriorityQueue(int n){
		queue=new MaxHeap(n);
	}
	
	//returns the size
	public int size() {
		return queue.size();
	}
	
	//returns the capacity
	public int capacity() {
		return queue.max();
	}
	
	//adds an ObjectID with given id and priority to the queue
	public void enqueue(int ObjectID, int priority) {
		ObjectID addedObj=new ObjectID(ObjectID, priority);
		queue.insert(addedObj);
	}
	
	//removes the highest priority ObjectID and returns the id of it
	public int dequeue() {
		ObjectID removedObj=queue.remove();
		return removedObj.getObjID();
	}
	
	//changes the priority of the ObjectID with given parameters
	public void changeweight(int ObjectID, int newPriority) {
		//finds the ObjectID
		ObjectID obj=queue.getObjectID(ObjectID);
		
		//return if obj was not found
		if(obj==null) {
			return;
		}
		
		//updates the priority
		obj.setPriority(newPriority);
		int current=obj.getPosition();
		
		//moves the ObjectIDs to fit heap conditions
		while(queue.heap[current].getPriority()>queue.heap[queue.parent(current)].getPriority()) {
			queue.swap(current, queue.parent(current)); //swaps the current with its parent
			current = queue.parent(current); 	//the next parent index is set into current index
												//to be checked by the while loop condition
		}
	}
	
	//prints the queue with id, priority, and position
	public void printHeap() {
		queue.print();
	}
	
	//prints the queue with only the ids
	public void printArray() {
		queue.printArray();
	}

}
