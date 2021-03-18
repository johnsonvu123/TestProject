package ds_lab3;

public class Arraylist<T> {
	private ANode<T> head, tail, currNode; //head, tail, and current nodes created
	private int numLength; //Keeps count of the total number of elements in the arraylist
	
	@SuppressWarnings("unchecked")
	// creates a default Arraylist
	Arraylist(){
		this.head=new ANode<T>(10); //creates a new Node/Array of capacity 10 and sets it into the head
		this.tail=head; //head is set into the tail
		this.currNode=head; //head is set into the currNode
		this.numLength=0; //0 is set into the numLength
	}
	
	//creates an Arraylist of the given size
	Arraylist(int size){
		this.head=new ANode<T>(size); //creates a new Node/Array of capacity given size and sets it into the head
		this.tail=head; //head is set into the tail
		this.currNode=head; //head is set into the currNode
		this.numLength=0; //0 is set into the numLength
	}
	
	//when called, the function will create another node with double the previous node's capacity
	private <T> void ensureCapacity() {
		ANode nodeAdded=new ANode(currNode.capacity*2); //creates a node with double capacity
		this.tail.next=nodeAdded; //sets the node next to the tail to the node with double capacity
		nodeAdded.prev=this.tail; //sets the node previous to the node with double capacity to the tail
		this.tail=nodeAdded; //sets the tail to the node with double capacity
		currNode=currNode.next; //moves the currNode pointer to the next node
	}
	
	//adds an element to the end of the arraylist
	public boolean add(T element) {
		// calls the ensureCapacity function 
		// if the current node length is equal to the current node capacity
		if(currNode.length==currNode.capacity) {
			ensureCapacity();
		}
		currNode.data[currNode.length++]=element; // sets the element to the end of the arraylist
		System.out.println(element+" has been added to index "+(numLength));
		numLength++; //increments the length of the whole arraylist
		return true; //returns true when the element has been added
		
	}
	
	//adds an element at the given index
	public void add(int index, T element) {
		ANode temp=this.head; //temporary node set as head
		int tempIndex=index; //temporary index set as index
		while(temp!=null) { //a while loop that will continue through each node until the node is null
			if(tempIndex>=numLength || tempIndex<0) { // checking if tempIndex is outside the bounds of the arraylist
				System.out.println("This index is out of bounds");
				break; //stops the while loop
			}
			if(tempIndex>=temp.capacity) { //checking if tempIndex is more than the temp capacity
				tempIndex=tempIndex-temp.capacity; //reduces tempIndex to the "right" index
			} else { //executes when tempIndex is the "right" index
				if(this.tail.length==this.tail.capacity) { //ensures capacity
					ensureCapacity();
				}
				ANode curr=this.tail; //creating a temporary current node pointer
				while(curr!=temp) { //a while loop that will continue backwards from the tail until it reaches the temp node
						for(int i=curr.length;i>0;i--) { //iterating through each element
							if(i==curr.capacity) { //if the current node is full
								curr.next.data[0]=curr.data[curr.length-1]; //moves the very last element of the node to the next node
							} else { // else move the elements over normally from left to right
								curr.data[i]=curr.data[i-1];
							}
						}
						curr=curr.prev; //change current pointer to the previous node
				}
				for(int i=curr.length;i>tempIndex;i--) { //iterates through the temp node until it reaches the tempIndex
					if(i==curr.capacity) { //if the current node is full
						curr.next.data[0]=curr.data[curr.length-1]; //moves the very last element of the node to the next node
					} else { // else shift the elements over normally from left to right
						curr.data[i]=curr.data[i-1];
					}
				}
				curr.data[tempIndex]=element; //set the tempIndex of the node to the element
				System.out.println(element+" has been added to index "+index);
				this.tail.length++; //increment the tail length
				numLength++; //increment the whole length
				break; //stops the while loop
			}
			
			temp=temp.next; //moves the temp node pointer to the next node
		}
		
	}
	
	//returns the size of the arraylist
	public int size() {
		return numLength; // returns numLength-the counter of the number of elements in the arraylist
	}
	
	//sets the given element to the given index
	public void set(int index, T element) {
		ANode temp=this.head; //creates a temporary node has the head set into it
		int tempIndex=index; //index is set into a temporary index
		while(temp!=null) { //iterates until temp node is equal to null
			if(tempIndex>=numLength || tempIndex<0) { //checks if index is out of bounds/over the length of the whole arraylist
				System.out.println("This index is out of bounds");
				break;
			}
			if(tempIndex>=temp.capacity) { //checks if the index is over the capacity
				tempIndex=tempIndex-temp.capacity; //reduces the temporary index by the node capacity
			} else { //executes once the tempIndex is "right"
				temp.data[tempIndex]=element; //sets the tempIndex of the node/array to the element
				System.out.println(element+" has been set to index "+index);
				break;
			}
			
			temp=temp.next; //moves the temp node pointer to the next node
		}
		
	}
	
	//returns the element of the given index
	public T get(int index) {
		ANode<T> temp=this.head; //temporary node set with the head in it
		int tempIndex=index; //temporary index set witht the index in it
		while(temp!=null) { //iterates through the nodes until temp node is null
			if(tempIndex>=numLength || tempIndex<0) { //checks if index is out of bounds
				System.out.println("This index is out of bounds");
				return null; //returns null if index is out of bounds
			}
			if(tempIndex>=temp.capacity) { //reduces tempIndex if it is greater than or equal to the capacity of the temp node
				tempIndex=tempIndex-temp.capacity;
			} else { //stops the while loop
				break;
			}
			
			temp=temp.next; //moves the temp pointer to the next node
		}
		return temp.data[tempIndex]; //returns the element of the tempIndex in the node
	}
	
	//removes the element from the given index
	public T remove(int index) {
		ANode temp=this.head; //temp pointer node set to head
		int tempIndex=index; //tempIndex set to the index
		T tempValue=null; //creates a tempValue that is set to null
		while(temp!=null) { //iterates through the nodes until it reaches null
			if(tempIndex>=numLength || tempIndex<0) { //checks if the index is out of bounds
				System.out.println("This index is out of bounds");
				break;
			}
			if(tempIndex>=temp.capacity) { //reduces the tempIndex if greater than or equal to the node capacity
				tempIndex=tempIndex-temp.capacity;
			} else {
				ANode curr=temp; //current node pointer set to the temp node
				tempValue=(T) curr.data[tempIndex]; //tempValue is set the value of the element that is about to be removed
				for(int i=tempIndex;i<curr.length;i++) { //iterates from the tempIndex to the current node length
					if(i==curr.capacity-1) { //if i equals the capacity - 1/the very last index of the array/node
						curr.data[i]=curr.next.data[0]; //sets the very last index of the current node to the next node's first element
					} else { //else continue shifting the elements over from the right to the left
						curr.data[i]=curr.data[i+1];
					}
				}
				
				curr=curr.next; //moves the current node pointer to the next node
				
				while(curr!=null) { //iterate through each node until the current node is null
					for(int i=0;i<curr.length;i++) { //iterate through each element in the node
						if(i==curr.capacity-1) { //if i equals the capacity - 1/the very last index of the array/node
							curr.data[i]=curr.next.data[0]; //sets the very last index of the current node to the next node's first element
						} else { //else continue shifting the elements over from the right to the left
							curr.data[i]=curr.data[i+1];
						}
					}
					curr=curr.next; //moves the current node pointer to the next node
				}
				
				System.out.println(tempValue+" from index "+ index +" has been removed from the list");
				curr=this.tail; //the current node is set to the tail node
				if(curr.length==0) { //if the current node length equals 0
					curr=curr.prev; //move the current node pointer to the previous node
				}
				curr.length--; //decrements the current node length
				numLength--; //decrements the whole arraylist length
				break;
			}
			
			temp=temp.next; //moves the temp node pointer to the next node
		}
		return tempValue; //returns the element that was removed
	}
	
	//returns a true or false statement depending on whether the list is empty or not
	public boolean isEmpty(){
		if(this.numLength==0) { //returns true if the numLength equals 0
			return true;
		}
		
		ANode curr=this.head; //current node pointer set to the head node
			  
		while(curr!=null) { //iterates through each node until the current node is null
			for(int i=0; i<curr.length;i++) { //iterates through each element in the node
				if(curr.data[i]!=null) { //checks if the data element does not equal null
					return false; //returns false is there is an element present
				}
			}
			curr=curr.next; //moves the current node pointer to the next node
		}

		return true; //returns true by default
	}
	
	//checks if the given element is in the arraylist, and returns a boolean statement
	public boolean contains(T element) {
		if(this.numLength==0) { //if list is empty, returns false
			return false;
		}
		
		ANode curr=this.head; //current node pointer set to the head node
		  
		while(curr!=null) { //iterates through the nodes until the current node is null
			for(int i=0; i<curr.length;i++) { //iterates through each element in the node
				if(curr.data[i]==element) { //checks if the data element is equal to the given element
					return true; //returns true if so
				}
			}
			curr=curr.next; //moves the current node pointer to the next node
		}
		return false; //returns false by default
	}
	
	//clears the arraylist
	public void clear() {
		ANode curr=this.head; //current node is set to the head node
		
		while(curr!=null) { //iterates through each node until the current node is null
			for(int i=0; i<curr.length;i++) { //iterates through each element in the current node
				curr.data[i]=null; //sets the elements to null
			}
			curr.length=0; //sets the current length to 0
			curr=curr.next; //moves the current node pointer to the next node
			
		}
		numLength=0; //sets the whole length of the arraylist to 0
		this.currNode=this.head; //sets the currNode to the head node
		System.out.println("List has been cleared");
	}
	
	//print function
	public void print() {
		ANode temp=this.head;
		while(temp!=null) {
			if(numLength==0) {
				System.out.println("No elements to be printed");
				break;
			} else {
				for(int i=0; i<temp.length;i++) {
					System.out.print(temp.data[i]+" ");
				}
			}
			temp=temp.next;
		}
		System.out.println();
	}

}
