package ds_lab3;

public class ANode<T> {
	public int capacity; //the maximum size of the array
	public int length; //the number of elements inside the array
	public T[] data; //the generic array
	public ANode<T> next; //the next pointer/node
	public ANode<T> prev; //the prev pointer/node
	
	@SuppressWarnings("unchecked")
	//creates a node that is an array of the given size
	ANode(int size){
		this.capacity=size; //set capacity to the given size
		this.length=0; //0 is set to the length
		data=(T[])new Object[capacity]; //sets data with an object array of given size
		next=null; //null is set into next
		prev=null; //null is set into prev
		
	}
}
