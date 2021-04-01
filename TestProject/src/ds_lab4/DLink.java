package ds_lab4;

public class DLink<T> { //double link list
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
