package finals;

public class PQMain {
	public static void main(String[] args) {
		PriorityQueue queue=new PriorityQueue(20);
		
		//checking enqueue function
		queue.enqueue(100, 20);
		queue.enqueue(60, 30);
		queue.enqueue(50, 24);
		queue.enqueue(70, 13);
		queue.enqueue(80, 25);
		queue.enqueue(90, 16);
		
		//checking queue
		queue.printHeap();
		
		//checking changeweight function
		queue.changeweight(100, 40);
		queue.changeweight(60, 14);
	    queue.changeweight(90, 24);
		
		//checking queue
		queue.printHeap();
		
		//checking the queue with printArray function
		//queue.printArray();
		//System.out.println();
		
		//checking if id 100 is dequeued
		System.out.print("ObjectID with Highest Priority: "+queue.dequeue()+" \n");
	}

}
