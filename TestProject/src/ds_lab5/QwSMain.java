package ds_lab5;

public class QwSMain {
	public static void main(String[] args) {
		System.out.println("Integer Queue: ");
		//checking QueueWithStacks creation/constructor
		QueueWithStacks<Integer> q=new QueueWithStacks<Integer>(); //created a generic queue with stacks of integers
		
		//checking enqueue function
		for(int i=0; i<5;i++) { //enqueued 5 elements
			q.enqueue(i*10);
		}
		System.out.print("Added: ");
		q.print(); //printing the queue after all elements have been enqueued
		
		//checking size function
		System.out.println("Size of queue: "+q.size());
		
		//checking dequeue function
		System.out.print("Removed: ");
		for(int i=0; i<2;i++) { //dequeues two elements in the queue
			System.out.print(q.dequeue()+" ");
		}
		System.out.println();
		
		//checking size function after dequeuing
		System.out.println("Size of queue: "+q.size());
		
		//checking print function after enqueuing and dequeuing
		System.out.print("Elements in the queue: ");
		q.print();
		
		//checking peek function
		System.out.println("Top element in queue: "+q.peek());
		
		//checking isEmpty function
		System.out.println("Queue is empty: "+q.isEmpty());
		
		//dequeuing all elements in the list
		int count=q.size(); //integer variable that is set to the size of the queue which is 3
		System.out.print("Removed: ");
		for(int i=0; i<count;i++) { //dequeues all elements left in queue
			System.out.print(q.dequeue()+" ");
		}
		System.out.println();
		
		//checking isEmpty function after dequeue of all elements
		System.out.println("Queue is empty: "+q.isEmpty());
		
		System.out.println();
		
		System.out.println("String Queue: ");
		//checking QueueWithStacks creation/constructor
		QueueWithStacks<String> q2=new QueueWithStacks<String>(); //created a generic queue with stacks of integers
				
		//checking enqueue function
		//enqueued 5 elements
		q2.enqueue("a");
		q2.enqueue("s");
		q2.enqueue("d");
		q2.enqueue("f");
		q2.enqueue("g");
		System.out.print("Added: ");
		q2.print(); //printing the queue after all elements have been enqueued
				
		//checking size function
		System.out.println("Size of queue: "+q2.size());
				
		//checking dequeue function
		System.out.print("Removed: ");
		for(int i=0; i<2;i++) { //dequeues two elements in the queue
			System.out.print(q2.dequeue()+" ");
		}
		System.out.println();
				
		//checking size function after dequeuing
		System.out.println("Size of queue: "+q2.size());
				
		//checking print function after enqueuing and dequeuing
		System.out.print("Elements in the queue: ");
		q2.print();
				
		//checking peek function
		System.out.println("Top element in queue: "+q2.peek());
				
		//checking isEmpty function
		System.out.println("Queue is empty: "+q2.isEmpty());
				
		//dequeuing all elements in the list
		int count2=q2.size(); //integer variable that is set to the size of the queue which is 3
		System.out.print("Removed: ");
		for(int i=0; i<count2;i++) { //dequeues all elements left in queue
			System.out.print(q2.dequeue()+" ");
		}
		System.out.println();
				
		//checking isEmpty function after dequeue of all elements
		System.out.println("Queue is empty: "+q2.isEmpty());
		
	}

}
