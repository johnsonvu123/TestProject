package finals;

public class HMMain {
	public static void main(String[] args) {
		HashMap hashmap=new HashMap();
		
		//checking insertion function
		hashmap.insert(new Key("Kite"), new Value(20));
		hashmap.insert(new Key(99), new Value(15));
		hashmap.insert(new Key(15), new Value(17));
		hashmap.insert(new Key(200), new Value(65));
		hashmap.insert(new Key("Fly"), new Value(38));
		hashmap.insert(new Key(67), new Value(99));
		
		//checking hashmap with print
		hashmap.printHashMap();
		
		System.out.println();
		
		//checking the remove function
		hashmap.remove(new Key(20));
		hashmap.remove(new Key(99));
		hashmap.remove(new Key("Kite"));
		
		System.out.println();
		
		//checking hashmap with print
		hashmap.printHashMap();
		
		System.out.println();
		
		//checking containsKey function
		System.out.println(hashmap.containsKey(new Key(99)));
		System.out.println(hashmap.containsKey(new Key(200)));
		System.out.println(hashmap.containsKey(new Key("Fly")));
		
		System.out.println();
		
		//checking containsValue function
		System.out.println(hashmap.containsValue(new Value(99)));
		System.out.println(hashmap.containsValue(new Value(200)));
		
		System.out.println();
		
		//checking get method
		Value value1=hashmap.get(new Key(15));
		Value value2=hashmap.get(new Key(53));
		System.out.println();
		if(value1!=null) {
			System.out.println(value1.getValue());
		} else {
			System.out.println("Value not there");
		}
		if(value2!=null) {
			System.out.println(value2.getValue());
		} else {
			System.out.println("Value not there");
		}
		
		System.out.println();
		
		//checking length and capacity functions
		System.out.println(hashmap.length());
		System.out.println(hashmap.capacity());
	}

}
