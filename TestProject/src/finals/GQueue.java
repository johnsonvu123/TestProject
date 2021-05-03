package finals;

class DLink<T> { //double link list
	public T value;
	public T[] data;
	public DLink next, prev;
	DLink(T value) { //constructor for a single value
		this.value =value;//1
		next = null; //1
		prev = null; //1
	}
	
	DLink(T[] array){ //constructor for an array/head link
		this.data=array;
		next=null;
		prev=null;
	}
}

public class GQueue<T> {
	private DLink<T> head, tail; //head and tail links
	private int size; //counter of the size of the elements in the queue
	private final int capacity=5; //the default capacity for the array
	private T[] array=(T[]) new Object[capacity]; //the array that will be in the head link
	
	public GQueue(){ //generic queue constructor/ creates a generic queue
		this.head=new DLink<T>(array); //initializes the head link with the array
		this.tail=head; //sets the tail to head
		this.size=0; //sets the size to 0
	}
	
	//returns the size of the queue
	public int size() {
		return this.size;
	}
	
	//returns the capacity of the array in the head link
	public int capacity() {
		return this.capacity;
	}
	
	//returns whether the queue is empty or not
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
	
	//returns true when the value is added to the end of the queue
	public boolean enqueue(T value) {
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
	
	//removes the first element in the queue
	public T dequeue() {
		DLink<T> currLink=this.head;
		DLink<T> temp=this.tail;
		T tempValue=this.head.data[0];
		if(this.isEmpty()){ //returns null if the queue is empty
		      return null;
		    } else if(this.size<=this.capacity) { //executes when the queue's size is less than or equal to the array capacity
		    	for(int i=0; i<this.size-1;i++) {
		    			this.head.data[i]=this.head.data[i+1]; //shifts the elements over from right to left, ignoring the last item in the array
				}
		    	size--; //size is decremented
		    	return tempValue; //returns the value removed/dequeued
		    }
		//executes when all the instructions above do not execute
		while(currLink!=null) { //while loop that checks if currLink is null or not
		    if(currLink==head) { //executes block if currLink is the head link
				for(int i=0; i<this.capacity-1;i++) { //shifts the array data over to "delete" the first item in the queue
					this.head.data[i]=this.head.data[i+1];
				}
				this.head.data[capacity-1]=(T) currLink.next.value; //the last item will be updated to the value of the next link/after the head link
			} else { //executes if currLink not at head link
				if(currLink.next!=null) { //executes when the next current link is not null
					currLink.value=(T) currLink.next.value; //shifts the value of the next link into the current link
				} else { //executes when the last/tail node is reached
					this.tail=temp.prev; //changes tail to the previous link
					tail.next=null; //changes the next link of the tail to null, "deleting" the link.
				}
			}
			currLink=currLink.next; //current link becomes the next link
		}
		size--; //decrement the size
		return tempValue; //returns the value dequeued
	}
	
	//returns the last element/value
	public T peek() {
		return this.head.data[0]; //returns the first array value from the head link
	}
	
	//print function
	public void print() {
		if(this.size>this.capacity) { //prints the queue when the array is full and has links after the head link
			for(int i=0;i<5;i++) {
				System.out.print(this.head.data[i]+" ");
			}
			DLink currLink=this.head.next;
			while(currLink!=null) {
				System.out.print(currLink.value+" ");
				currLink=currLink.next;
			}
			System.out.println();
		} else { //otherwise print the array only
			for(int i=0;i<this.size;i++) {
				System.out.print(this.head.data[i]+" ");
			}
			System.out.println();
		}
	}

}
