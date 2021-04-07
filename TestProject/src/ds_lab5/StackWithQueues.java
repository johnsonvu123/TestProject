package ds_lab5;
import ds_lab4.GQueue;

public class StackWithQueues <T>{
	GQueue<T> q; //main queue
	GQueue<T> temp; //secondary queue
	
	//creating StackWithQueues constructor
	StackWithQueues(){
		q=new GQueue<T>(); //initializing the main queue
		temp = new GQueue<T>(); //initializing the secondary queue
	}
	
	//size function that returns an integer
	public int size() {
		return q.size(); //returns the size of the main queue
	}
	
	//isEmpty function that returns a boolean statement
	public boolean isEmpty() {
		return q.size()==0; //returns true or false based on whether the main queue size is equal to 0
	}
	
	//get function that returns the element of the given index in the stack
	public T get(int index) {
		return q.get(index); //returns the element of the given index in the main queue
	}
	
	//push function that adds at the end of the stack
	public boolean push(T value) {
		q.enqueue(value); //enqueues the given value into the main queue
		return true;
	}
	
	//pop function that removes an element at the end of the stack
	public T pop() {
		for(int i=q.size(); i>1; i--) { //iterates through each element in the main queue except the last element
			temp.enqueue(q.dequeue()); //enqueues the dequeued element of the main queue into the secondary queue
		}
		T value=q.dequeue(); //creates and initializes value with the last dequeued element from the main queue
		for(int j=temp.size(); j>0; j--) { //iterates through each element in the secondary queue
			q.enqueue(temp.dequeue()); //enqueues the dequeued element of the secondary queue back into the main queue
		}
		return value; //returns the value that was popped
	}
	
	//top function that returns the last element in the stack
	public T top() {
		return q.get(q.size()-1); //returns the last element in the main queue
	}
	
	//print function that prints all the elements in the stack
	public void print() {
		q.print(); //prints the elements in the main queue
	}

}
