package finals;

public class HashMap {
	HMEntry[] hashMap;
	private int size;
	private int max;
	
	public HashMap() { //default constructor
		size=0;
		max=19;
		hashMap=new HMEntry[max];
	}
	
	public HashMap(int n) { //constructor with integer value
		size=0;
		max=n;
		hashMap=new HMEntry[max];
	}
	
	//returns the size of hashMap
	public int length() {
		return this.size;
	}
	
	//returns the capacity of the hashMap
	public int capacity() {
		return this.max;
	}
	
	//adds an entry by taking in the given paramaters
	public void insert(Key k, Value val) {
		int index=getIndex(k) ;
		
		//if the index entry is null, insert into that index
		if(hashMap[index]==null) {
			hashMap[index]=new HMEntry(k, val);
			size++;
			return;
		} else { //else do a linear search and insert when an entry is null
			if(index>=this.max/2) { //linear search from index to 0
				for(int i=index;i>=0;i--) {
					if(hashMap[i]==null) {
						hashMap[i]=new HMEntry(k, val);
						size++;
						return;
					}
				}
			} else { //linear search from index to max
				for(int i=index;i<this.max;i++) {
					if(hashMap[i]==null) {
						hashMap[i]=new HMEntry(k, val);
						size++;
						return;
					}
				}
			}
		}
		System.out.println("No available space for this entry");
	}
	
	//removes the given key if found
	public void remove(Key k) {
		if(k==null) { //if given key is null
			System.out.println("Key not found");
			return;
		}
		int index=getIndex(k) ;
		
		if(hashMap[index]==null) { //if the entry is null
			System.out.println("Key not found");
			return;
		}
		
		if(hashMap[index].key.getKey()==k.getKey()) { //when key is found
			hashMap[index]=null;
			size--;
			return;
		} else { //do linear search to check for possible collision
			if(index>=this.max/2) {
				for(int i=index;i>=0;i--) { //from index to 0
					if(hashMap[i]==null) {
						System.out.println("Key not found");
						return;
					} else if(hashMap[i].key.getKey()==k.getKey()) {
						hashMap[index]=null;
						size--;
						return;
					}
				}
			} else {
				for(int i=index;i<this.max;i++) { //from index to max
					if(hashMap[i]==null) {
						System.out.println("Key not found");
						return;
					} else if(hashMap[i].key.getKey()==k.getKey()) {
						hashMap[index]=null;
						size--;
						return;
					}
				}
			}
		}
		System.out.println("Key not found");
	}
	
	//gets the Value object of a given key if found
	public Value get(Key k) {
		int index=getIndex(k);
		
		//checks if the given index's entry key is equal to the given key
		if(hashMap[index].key.getKey()==k.getKey()) {
			return hashMap[index].value;
		} else { //hash collision, do linear search
			if(index>=this.max/2) { //linear search from index to 0
				for(int i=index;i>=0;i--) {
					if(hashMap[i]==null) { //when not found
						System.out.println("Key not found");
						return null;
					} else if(hashMap[i].key.getKey()==k.getKey()) { //when found return the value
						return hashMap[i].value;
					}
				}
			} else { //linear search from index to max
				for(int i=index;i<this.max;i++) {
					if(hashMap[i]==null) { //when not found
						System.out.println("Key not found");
						return null;
					} else if(hashMap[i].key.getKey()==k.getKey()) { //when found return the value
						return hashMap[i].value;
					}
				}
			}
		}
		System.out.println("Key not found");
		return null;
	}
	
	//searches for the key and returns true if found
	public boolean containsKey(Key k) {
		if(k==null) { //if k is null
			return false;
		}
		int index=getIndex(k) ;
		
		if(hashMap[index]==null) { //if entry is null
			return false;
		}
		
		if(hashMap[index].key.getKey()==k.getKey()) { //if key is found
			return true;
		} else {
			if(index>=this.max/2) { //linear search from index to 0
				for(int i=index;i>=0;i--) {
					if(hashMap[i]==null) {
						System.out.println("Key not found");
						return false;
					} else if(hashMap[i].key.getKey()==k.getKey()) {
						return true;
					}
				}
			} else { //linear search from index to max
				for(int i=index;i<this.max;i++) {
					if(hashMap[i]==null) {
						System.out.println("Key not found");
						return false;
					} else if(hashMap[i].key.getKey()==k.getKey()) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	//searches the given value and returns true if found
	public boolean containsValue(Value val) {
		for(int i=0; i<this.max; i++) { //search through each entry in the hashMap
			if(hashMap[i]!=null) { //check if the entry is not null
				if(hashMap[i].value.getValue()==val.getValue()) { //check if the values are the same
					return true;
				}
			}
		}
		return false;
	}
	
	//returns the given key's index through mod
	int getIndex(Key k) {
		return k.getKey() % this.max;
	}
	
	//prints all the items in the array of hashMap
	public void printArray() {
		if(this.size==0) {
			return;
		}
		for(int i=0; i<this.max; i++) {
			if(hashMap[i]!=null) {
				if(hashMap[i].value!=null) {
					System.out.print("Key: "+hashMap[i].key.getKey()
							+", Value: "+hashMap[i].value.getValue());
					System.out.println();
				} else {
					System.out.print("Key: "+hashMap[i].key.getKey()
							+", Value: None");
					System.out.println();
				}
			} else {
				System.out.print("Key: None, Value: None");
				System.out.println();
			}
		}
	}
	
	//returns all the valid keys and values in the hashMap
	public void printHashMap() {
		for(int i=0; i<this.max; i++) {
			if(hashMap[i]!=null) { //only print valid entries
				if(hashMap[i].value!=null) { //when there is a value
					if(hashMap[i].key.getKeyStr()!=" ") { //when there is a string key
						System.out.print("Key: "+hashMap[i].key.getKeyStr()
								+", Value: "+hashMap[i].value.getValue());
						System.out.println();
					} else { //when there is not a string key
						System.out.print("Key: "+hashMap[i].key.getKey()
								+", Value: "+hashMap[i].value.getValue());
						System.out.println();
					}
				} else { //when there is not a value
					if(hashMap[i].key.getKeyStr()!=" ") { //when there is a string key
						System.out.print("Key: "+hashMap[i].key.getKeyStr()
								+", Value: None");
						System.out.println();
					} else { //when there is not a string key
						System.out.print("Key: "+hashMap[i].key.getKey()
								+", Value: None");
						System.out.println();
					}
				}
			}
		}
	}

}
