package ds_lab3;


class GArrayList<T> {
	private int capacity;
	private int length;
	private T[] data;

	@SuppressWarnings("unchecked")
	GArrayList() {
		capacity = 10;
		length = 0;
		data = (T[])new Object[capacity];
	}
	
	@SuppressWarnings("unchecked")
	GArrayList(int size) {
		capacity = size;
		length = 0;
		data = (T[])new Object[capacity];
	}
	
	@SuppressWarnings("unchecked")
	private void ensureCapacity() {
		int newSize = capacity*2;
		T[] temp = (T[])new Object[newSize];
		
		for(int i=0;i<length;i++) {
			temp[i]=data[i];
		}
		
		data=temp;
		capacity=newSize;
		
	}

	public void clear(){
		for(int i=0; i<this.length;i++) {
			data[i]=null;
		}
		length = 0;
		System.out.println("The list has been cleared");
	}
	
	public boolean add(T element) {
		if(length==capacity) {
			ensureCapacity();
		}
		data[length++] = element;
		System.out.println(element+" has been added to index "+(length-1));
		return true;
	}

	public void add(int index, T element) {
		if(length==capacity) {
			ensureCapacity();
		}
		
		if(index<length && index>=0){
			for (int i=length; i>index; i--) {
				data[i] = data[i-1];
			}
			data[index] = element;
			length++;
			System.out.println(element+" has been added to index "+index);
			
		} else{
			System.out.println("Index out of bounds");
		}
	}

	public T remove(int index) {
		if ((index<0) || (index>=length)) {
			System.out.println("Index out of bounds");
			return null;
		}
		T temp = data[index];
		for(int i=index; i<length-1; i++) {
			data[i] = data[i+1];
		}
		length--; // Decrement size
		System.out.println(temp+" has been removed at index "+index);
		return temp;
	}

	public int size() {
		return length; 
	}

	T get(int index){
	    if(index<0||index>=length){
	      System.out.print("Index is out of bounds: ");
	      return null;
	    } else {
	    	return (T) data[index];
	    }
	  }
	
	public void set(int index, T element) {
		if(index<0||index>=length){
			System.out.println("Index is out of bounds");
		}
		else {
			data[index]=element;
			System.out.println(element+" is set into the index "+index);
		}
	}
	
	public boolean isEmpty(){
		if(this.length==0) {
			return true;
		}
			  
		for( int index =  0 ; index < this.length; index ++ ) {
			if(data[index] != null) {
				return false;
			}
		}

		return true;
	}
	
	public boolean contains(T element){
		if(this.length==0) {
			return false;
		}
			  
		for( int index =  0 ; index < this.length; index ++ ) {
			if(data[index] == element) {
				return true;
			}
		}

		return false;
	}
	
	void print() {
		for(int i=0; i<this.length;i++) {
			System.out.print(data[i]+" ");
		}
		System.out.println();
	}
}
