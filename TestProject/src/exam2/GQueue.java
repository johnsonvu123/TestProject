package exam2;

class Stock{ //question 2
	private int shares; //number of shares
	private int value; //dollar value
	private int day; //day it was bought
	
	Stock(int share, int val){
		this.shares=share;
		this.value=val;
		this.day=0;
	}
	
	//sets shares to the given number of share
	public int setShares(int share) {
		return this.shares=share;
	}
	
	//sets dollar value to the given value
	public int setValue(int val) {
		return this.value=val;
	}
	
	//set the day counter
	public int setDay(int num) {
		return this.day=num;
	}
	
	//gets the number of shares
	public int getShares() {
		return this.shares;
	}
	
	//gets the dollar value of the stock
	public int getValue() {
		return this.value;
	}
	
	//gets the day count
	public int getDay() {
		return this.day;
	}
}

class StockNode {  //question 2 / doubly linked list
	public Stock value;
	public Stock[] data;
	public StockNode next, prev;
	StockNode(Stock value) { //constructor for a single value
		this.value =value;//1
		next = null; //1
		prev = null; //1
	}
	
	StockNode(Stock[] array){ //constructor for an array/head link
		this.data=array;
		next=null;
		prev=null;
	}
}

public class GQueue {
	public StockNode head, tail; //head and tail links
	private int length; //counter of the length of the elements in the queue
	private final int capacity=5; //the default capacity for the array
	private Stock[] array=new Stock[capacity]; //the array that will be in the head link
	
	public GQueue(){ //generic queue constructor/ creates a generic queue
		this.head=new StockNode(array); //initializes the head link with the array
		this.tail=head; //sets the tail to head
		this.length=0; //sets the length to 0
	}
	
	//returns the length of the queue
	public int size() {
		return this.length;
	}
	
	//returns the capacity of the array in the head link
	public int max() {
		return this.capacity;
	}
	
	//returns whether the queue is empty or not
	public boolean isEmpty() {
		return length==0;
	}
	
	//returns the element/value given the index
	public Stock get(int index) {
		if(index>=this.length || index<0) { //executes if index is out of bounds
			System.out.println("The index is out of bounds");
			return null;
		} else if(index<this.capacity && index>=0) { //executes when the index is within the bounds of the array
			return this.head.data[index];
		}
		
		//instructions to find the link of the index in the list after the head link
		StockNode currLink=this.head.next;
		while(index<=0) {
			index--;
			currLink=currLink.next;
		}
		
		return currLink.value;
	}
	
	//returns true when the value is added to the end of the queue
	public boolean enqueue(Stock value) {
		if(this.length>=this.capacity) { //when the array in head link is full, the if block is executed
			StockNode linkAdded=new StockNode(value); //adding link with value in it
			this.tail.next=linkAdded; //sets the link next to the tail to the new link
			linkAdded.prev=this.tail; //sets the link previous to the new link to the "old" tail
			this.tail=linkAdded; //sets the tail to the new link
			this.length++; //increments the length
			return true;
		}
		
		this.head.data[this.length++]=value; //sets the value in the available index and increments the length
		return true;
	}
	
	//removes the first element in the queue
	public Stock dequeue() {
		StockNode currLink=this.head;
		StockNode temp=this.tail;
		Stock tempValue=this.head.data[0];
		if(this.isEmpty()){ //returns null if the queue is empty
		      return null;
		    } else if(this.length<=this.capacity) { //executes when the queue's length is less than or equal to the array capacity
		    	for(int i=0; i<this.length-1;i++) {
		    			this.head.data[i]=this.head.data[i+1]; //shifts the elements over from right to left, ignoring the last item in the array
				}
		    	length--; //length is decremented
		    	return tempValue; //returns the value removed/dequeued
		    }
		//executes when all the instructions above do not execute
		while(currLink!=null) { //while loop that checks if currLink is null or not
		    if(currLink==head) { //executes block if currLink is the head link
				for(int i=0; i<this.capacity-1;i++) { //shifts the array data over to "delete" the first item in the queue
					this.head.data[i]=this.head.data[i+1];
				}
				this.head.data[capacity-1]=currLink.next.value; //the last item will be updated to the value of the next link/after the head link
			} else { //executes if currLink not at head link
				if(currLink.next!=null) { //executes when the next current link is not null
					currLink.value= currLink.next.value; //shifts the value of the next link into the current link
				} else { //executes when the last/tail node is reached
					this.tail=temp.prev; //changes tail to the previous link
					tail.next=null; //changes the next link of the tail to null, "deleting" the link.
				}
			}
			currLink=currLink.next; //current link becomes the next link
		}
		length--; //decrement the length
		return tempValue; //returns the value dequeued
	}
	
	//returns the last element/value
	public Stock peek() {
		return this.head.data[0]; //returns the first array value from the head link
	}

}
