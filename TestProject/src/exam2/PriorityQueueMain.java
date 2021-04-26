package exam2;

public class PriorityQueueMain { //question 1
	public static void main(String[] args) {
		PriorityQueue queue=new PriorityQueue(20);
		
		//checking enqueue function
		queue.enqueue(100, 20);
		queue.enqueue(60, 30);
		queue.enqueue(50, 24);
		queue.enqueue(70, 13);
		queue.enqueue(80, 25);
		queue.enqueue(90, 16);
		
		//checking the queue with printHeap function
		queue.printHeap();
		
		//checking the queue with printArray function
		//queue.printArray();
		//System.out.println();
		
		int size=queue.size();
		
		//checking dequeue function and high priority
		for(int i=0; i<size;i++) {
			System.out.print("ObjectID with Highest Priority: "+queue.dequeue()+" \n");
			queue.printHeap();
			
			//checking the queue with printArray function
			//queue.printArray();
			//System.out.println();
		}
		
		//enqueuing more ObjectIDs
		queue.enqueue(100, 20);
		queue.enqueue(60, 30);
		queue.enqueue(50, 24);
		queue.enqueue(70, 13);
		queue.enqueue(80, 25);
		queue.enqueue(90, 16);
		
		//checking the queue
		queue.printHeap();
		
		//checking the queue with printArray function
		//queue.printArray();
		//System.out.println();
		
		//checking changeweight function
		queue.changeweight(100, 40);
		
		//checking queue
		queue.printHeap();
		
		//checking the queue with printArray function
		//queue.printArray();
		//System.out.println();
		
		//checking if id 100 is dequeued
		System.out.print("ObjectID with Highest Priority: "+queue.dequeue()+" \n");
	}

}
