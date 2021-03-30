package ds_lab4;

public class GQueueMain {
	public static void main(String[] args) {
		//generic queue of integers is created
		GQueue<Integer> queue=new GQueue<Integer>();
		//enqueues values into the queue
		for(int i=0;i<queue.capacity()+1;i++) {
			System.out.println(queue.enqueue(i*10));
		}
		
		//checking queue and size
		queue.print();
		System.out.println("The size of the queue is "+queue.size());
		
		//checking the enqueue when the array is full
		System.out.println(queue.enqueue(60));
		
		//checking queue and size
		queue.print();
		System.out.println("The size of the queue is "+queue.size());
		
		//checking dequeue method
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		
		//checking queue and size
		queue.print();
		System.out.println("The size of the queue is "+queue.size());
		
		//checking peek method
		System.out.println(queue.peek());
		//checking get method
		System.out.println(queue.get(0));
		//checking get method with index out of bounds
		System.out.println(queue.get(4));
		
		//generic queue of string is created
		GQueue<String> queue2=new GQueue<String>();
		//enqueue string values into queue2
		for(int i=0;i<queue2.capacity();i++) {
			System.out.println(queue2.enqueue("way"));
		}
		
		//checking queue and size
		queue2.print();
		System.out.println("The size of the queue is "+queue2.size());
		
		//enqueue a string value after the array reaches capacity
		System.out.println(queue2.enqueue("hero"));
		
		//checking queue and size
		queue2.print();
		System.out.println("The size of the queue is "+queue2.size());
		
		//checking dequeue method
		queue2.dequeue();
		queue2.dequeue();
		
		//checking queue and size
		queue2.print();
		System.out.println("The size of the queue is "+queue2.size());
		
		//checking peek method
		System.out.println(queue2.peek());
		//checking get method
		System.out.println(queue2.get(0));
		//checking get method
		System.out.println(queue2.get(3));
		
		
	}

}
