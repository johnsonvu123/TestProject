package ds_lab4;

public class GStack<T> {
	private DLink<T> head, tail; //head and tail links
	private int size; //counter of the size of the elements in the stack
	private final int capacity=5; //the default capacity for the array
	private T[] array=(T[]) new Object[capacity]; //the array that will be in the head link
	
	public GStack(){ //generic stack constructor/ creates a generic stack
		this.head=new DLink<T>(array); //initializes the head link with the array
		this.tail=head; //sets the tail to head
		this.size=0; //sets the size to 0
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
	
	//returns the element/value given the index
	public T get(int index) {
		if(index>=this.size || index<0) { //executes if index is out of bounds
			System.out.println("The index is out of bounds");
			return null;
		} else if(index<this.capacity && index>=0) { //executes when the index is within the bounds of the array
			return this.head.data[index];
		}
		
		//instructions to find the link of the index in the list after the head link
		int count=index-(this.capacity-1);
		DLink<T> currLink=this.head.next;
		while(index<=0) {
			index--;
			currLink=currLink.next;
		}
		
		return currLink.value;
	}
	
	//returns true when the value is added to the end of the stack
	public boolean push(T value) {
		if(this.size>=this.capacity) { //when the array in head link is full, the if block is executed
			DLink linkAdded=new DLink(value); //adding link with value in it
			this.tail.next=linkAdded; //sets the link next to the tail to the new link
			linkAdded.prev=this.tail; //sets the link previous to the new link to the "old" tail
			this.tail=linkAdded; //sets the tail to the new link
			this.size++; //increments the size
			return true;
		}
		this.head.data[this.size++]=value; //sets the value in the available index and increments the size
		return true;
	}
	
	//removes the last element in the stack
	public T pop() {
		DLink<T> temp;
		if(this.isEmpty()){ //returns null if the stack is empty
			//System.out.println("Empty");
		    return null;
		} else if(this.size>this.capacity) { //executes when the size is greater than the array capacity
		    temp=this.tail; //temp is set to the tail link
			this.tail= temp.prev; //the tail is set to the previous temp link
			this.tail.next=null; //the next tail is set to null
			this.size--; //decrement the size
			T value=temp.value; //temporary value set to the temp value
			return value; //returns the value popped
		}
		T tempValue=this.head.data[--size]; //temporary value set to the last value in the array of the head link, decrements the size
		return tempValue; //returns the value popped
	}
	
	//returns the last element/value
	public T top() {
		if(this.size>this.capacity) { //executes when the size is greater than the array capacity
			return this.tail.value; //returns the tail of the list when there is a link after the head
		}
		return this.head.data[size-1]; //returns an array value from the head link
	}
	
	//print function
	public void print() {
		if(this.size>this.capacity) { //prints the stack when the array is full, and it has links after the head link
			for(int i=0;i<5;i++) { //prints array items
				System.out.print(this.head.data[i]+" ");
			}
			DLink currLink=this.head.next; //current link set to the link after head
			while(currLink!=null) { //then print links so long as the current link is not null
				System.out.print(currLink.value+" ");
				currLink=currLink.next; //sets the current link to the next link
			}
			System.out.println();
		} else { //otherwise print the array only
			for(int i=0;i<this.size;i++) { //prints array items
				System.out.print(this.head.data[i]+" ");
			}
			System.out.println();
		}
	}
}
