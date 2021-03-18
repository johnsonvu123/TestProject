package ds_lab3;

public class Arraylist_main {
	public static void main(String[] args) {
		Arraylist<Integer> list=new Arraylist<Integer>(5);
		
		for(int i=0;i<60;i++) {
			list.add(i+1);
		}
		list.print();
		System.out.println("List size is "+list.size());
		
		System.out.println();
		
		System.out.println(list.get(5));
		
		System.out.println();
		
		list.set(10, 10);
		list.print();
		
		System.out.println();
		
		list.add(12, 1);
		list.print();
		
		System.out.println();
		
		list.remove(15);
		list.print();
		System.out.println("List size is "+list.size());
		
		System.out.println();
		
		list.remove(29);
		list.print();
		System.out.println("List size is "+list.size());
		
		System.out.println();
		
		System.out.println(list.contains(12));
		
		System.out.println();
		
		System.out.println(list.isEmpty());
		
		System.out.println();
		
		list.clear();
		
		System.out.println();
		
		System.out.println(list.isEmpty());
		
		System.out.println();
		
		list.print();
		
		System.out.println();
		
		//String Arraylist
		Arraylist<String> list2=new Arraylist<String>(4);
		
		for(int i=0;i<4;i++) {
			list2.add("a");
		}
		list2.print();
		System.out.println("List2 size is "+list2.size());
		
		System.out.println();
		
		for(int i=0;i<4;i++) {
			list2.add("c");
		}
		list2.print();
		System.out.println("List2 size is "+list2.size());
		
		System.out.println();
		
		for(int i=0;i<4;i++) {
			list2.add("p");
		}
		list2.print();
		System.out.println("List2 size is "+list2.size());
		
		System.out.println();
		
		for(int i=0;i<4;i++) {
			list2.add("k");
		}
		list2.print();
		System.out.println("List2 size is "+list2.size());
		
		System.out.println();
		
		System.out.println(list2.get(5));
		
		System.out.println();
		
		list2.set(10, "g");
		list2.print();
		
		System.out.println();
		
		list2.add(12, "f");
		list2.print();
		
		System.out.println();
		
		list2.remove(15);
		list2.print();
		System.out.println("List2 size is "+list2.size());
		
		System.out.println();
		
		list2.remove(29);
		list2.print();
		System.out.println("List2 size is "+list2.size());
		
		System.out.println();
		
		System.out.println(list2.contains("a"));
		
		System.out.println();
		
		System.out.println(list2.isEmpty());
		
		System.out.println();
		
		list2.clear();
		
		System.out.println();
		
		System.out.println(list2.isEmpty());
		
		System.out.println();
		
		list2.print();
	}

}
