package ds_lab4;

public class DLink<T> {
	public T value;
	public T[] data;
	public DLink next, prev;
	DLink(T value) {
		this.value =value;//1
		next = null; //1
		prev = null; //1
	}
	
	DLink(T[] array){
		this.data=array;
		next=null;
		prev=null;
	}
}
