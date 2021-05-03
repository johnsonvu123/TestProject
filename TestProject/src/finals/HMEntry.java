package finals;

class Key{ //key object that holds an integer key
	private int key;
	private String keyStr=" ";
	
	public Key(int k) {
		key=k;
	}
	
	public Key(String k) {
		keyStr=k;
		for(int i=0; i<k.length();i++) {
			int n=(int)k.charAt(i);
			key+=n;
		}
	}
	
	public int getKey() { //get key function
		return this.key;
	}
	
	public String getKeyStr() { //get key function
		return this.keyStr;
	}
}

class Value{ //value object that holds an integer value
	private int value;
	
	public Value(int val) {
		value=val;
	}
	
	public int getValue() { //get value function
		return this.value;
	}
}

public class HMEntry { //entry that holds a key object and value object
	public Key key;
	public Value value;
	
	public HMEntry() {
		key=null;
		value=null;
	}
	public HMEntry(Key k, Value val) { //constructs the entry with given key and value
		key=k;
		value=val;
	}

}
