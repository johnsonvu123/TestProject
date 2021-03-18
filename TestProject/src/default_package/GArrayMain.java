package default_package;

public class GArrayMain {
	public static void main(String[] args) {
		//Integer Arraylist
		GArrayList<Integer> list=new GArrayList<Integer>();
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		System.out.println();
		
		System.out.println(list.get(0));
		System.out.println(list.get(6));
		
		System.out.println();
		
		list.add(3,6);
		list.print();
		System.out.println(list.size());
		
		System.out.println();
		
		list.add(4,7);
		list.print();
		System.out.println(list.size());
		
		System.out.println();
		
		list.add(7,8);
		list.print();
		System.out.println(list.size());
		
		System.out.println();
		
		list.set(3, 15);
		list.print();
		System.out.println(list.size());
		
		System.out.println();
		
		list.remove(2);
		list.print();
		System.out.println(list.size());
		
		System.out.println();
		
		list.remove(10);
		list.print();
		System.out.println(list.size());
		
		System.out.println();
		
		System.out.println(list.isEmpty());
		
		System.out.println();
		
		System.out.println(list.contains(3));
		
		System.out.println();
		
		System.out.println(list.contains(8));
		
		System.out.println();
		
		list.clear();
		
		System.out.println();
		
		System.out.println(list.isEmpty());
		
		System.out.println();
		
		
		//String Arraylist 
		GArrayList<String> list2=new GArrayList<String>();
		
		list2.add("a");
		list2.add("b");
		list2.add("c");
		list2.add("d");
		list2.add("e");
		
		System.out.println();
		
		list2.print();
		
		System.out.println();
		
		list2.add(3,"g");
		list2.print();
		System.out.println(list2.size());
		
		System.out.println();
		
		list2.add(4,"h");
		list2.print();
		System.out.println(list2.size());
		
		System.out.println();
		
		list2.add(7,"i");
		list2.print();
		System.out.println(list2.size());
		
		System.out.println();
		
		list2.set(3, "j");
		list2.print();
		System.out.println(list2.size());
		
		System.out.println();
		
		list2.remove(2);
		list2.print();
		System.out.println(list2.size());
		
		System.out.println();
		
		list2.remove(10);
		list2.print();
		System.out.println(list2.size());
		
		System.out.println();
		
		System.out.println(list2.contains("a"));
		
		System.out.println();
		
		System.out.println(list2.contains("c"));
		
		System.out.println();
		
		System.out.println(list2.isEmpty());
		
		System.out.println();
		
		list2.clear();
		
		System.out.println();
		
		System.out.println(list2.isEmpty());
		
		
	}
}
