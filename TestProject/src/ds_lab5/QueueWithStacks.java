package ds_lab5;
import ds_lab4.GStack;

public class QueueWithStacks <T>{
	GStack<T> s; //main stack
	GStack<T> temp; //secondary stack
	
	//creating QueueWithStacks constructor
	QueueWithStacks(){
		s=new GStack<T>(); //initializing main stack
		temp = new GStack<T>(); //initializing secondary stack
	}
	
	//size function that returns an integer
	public int size() {
		return s.size(); //returns the main stack size
	}
	
	//isEmpty function that returns a boolean statement
	public boolean isEmpty() {
		return s.size()==0; //returns true or false whether main stack size is equal to 0
	}
	
	//get function that returns the element of the given index in the queue
	public T get(int index) {
		return s.get(index); //returns the element of the given index in the main stack
	}
	
	//enqueue function that adds at the end of the queue
	public boolean enqueue(T value) {
		s.push(value); //pushes the given value into the main stack
		return true;
	}
	
	//dequeue function that removes the first element from the queue
	public T dequeue() {
		for(int i=s.size(); i>1; i--) { //iterating through each element except the very first element
			temp.push(s.pop()); //pushes the popped value of the main stack into the secondary stack
		}
		T value=s.pop(); //creates and initializes value with the last popped element from the main stack
		for(int j=temp.size(); j>0; j--) { //iterates through every element in the secondary stack
			s.push(temp.pop()); //pushes the popped value of the secondary stack back into the main stack
		}
		return value; //returns the value that was dequeued
	}
	
	//peek function that returns the first element in the queue
	public T peek() {
		return s.get(0); //returns the first element in the main stack
	}
	
	//print function that prints all the elements in the queue
	public void print() {
		s.print(); //prints all the elements in the main stack
	}
}
