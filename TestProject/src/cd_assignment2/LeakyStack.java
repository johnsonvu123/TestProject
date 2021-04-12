package cd_assignment2;

public class LeakyStack<T>{
	private int size; //size counter
	private final int capacity=10; //array capacity
	private int head; //head pointer
	private int tail; //tail pointer
	private T[] array; //array for leaky stack
	
	LeakyStack(){ //leaky stack constructor
		array=(T[]) new Object[capacity];
		size=0;
		head=0;
		tail=0;
	}
	
	//returns the size of the stack
	public int size() {
		return this.size;
	}
	
	//returns the capacity of the array in the head link
	public int capacity() {
		return this.capacity;
	}
	
	//returns whether the stack is empty or not
	public boolean isEmpty() {
		return size==0;
	}
	
	//returns value of the given index
	public T get(int index) {
		if(index>=this.size || index<0) { //executes if index is out of bounds
			System.out.println("The index is out of bounds");
			return null;
		}
		int count=tail;
		count=(count+index)%this.capacity; //calculates the right index with mod
		return array[count];
	}
	
	//adds a value to the end of the stack
	public boolean push(T value) {
		if(this.size>=5) { //executes if the size is greater than or equal to 5
			array[tail]=null; //removes the "last" pushed element in the stack
			tail=(tail+1)%this.capacity; //changes the tail
			array[head]=value; //adds the values to the end/head
			head=(head+1)%this.capacity; //changes the head
			return true;
		}
		array[head]=value; //adds the value to the end/head
		head=(head+1)%this.capacity; //changes head
		size++; //increment the size
		return true;
	}
	
	//removes the top element in the stack
	public T pop() {
		if(this.isEmpty()) { //if empty, return null
			System.out.println("Empty");
			return null;
		}
		if(head==0) { //if the head "pointer" is at 0, execute
			head=this.capacity-1; //sets head to the top element
			T value=array[head]; //creates a temp value and sets it to the soon to be removed element
			array[head]=null; //nulls the value where head is
			size--; //decrements the size
			return value; //returns the removed value
		}
		T value=array[head-1]; //creates a temp value and sets it to the soon to be removed element
		array[head-1]=null; //nulls the value where head is
		head=(head-1)%this.capacity; //changes head
		size--; //decrement size
		return value; //returns the removed value
	}
	
	//returns the top element in the stack
	public T top() {
		int count=head-1;
		if(head==0) {
			count=this.capacity-1;
		}
		return array[count];
	}
	
	//prints all the elements in the stack
	public void printAll() {
		for(int i=0; i<this.capacity;i++) {
			if(array[i]==null) {
				System.out.print("null ");
			} else {
				System.out.print(array[i]+" ");
			}
		}
		System.out.println();
	}
	
	//prints the right elements from the leaky stack
	public void print() {
		int curr=tail;
		if(this.isEmpty()) {
			System.out.println("Stack is Empty");
		} else {
			for(int i=0; i<this.size;i++) {
				System.out.print(array[curr]+" ");
				curr=(curr+1)%10;
			}
			System.out.println();
		}
	}

}
