package ds_lab5;

public class SwQMain {
	public static void main(String[] args) {
		System.out.println("Integer Stack: ");
		//checking StackWithQueues creation/constructor
		StackWithQueues<Integer> s=new StackWithQueues<Integer>(); //created a generic stack with stacks of integers
				
		//checking push function
		for(int i=0; i<6;i++) { //pushed 5 elements
			s.push(i*10);
		}
		System.out.print("Added: ");
		s.print(); //printing the stack after all elements have been pushed
				
		//checking size function
		System.out.println("Size of stack: "+s.size());
				
		//checking pop function
		System.out.print("Removed: ");
		for(int i=0; i<2;i++) { //pops two elements in the stack
			System.out.print(s.pop()+" ");
		}
		System.out.println();
				
		//checking size function after popping
		System.out.println("Size of stack: "+s.size());
				
		//checking print function after pushing and popping
		System.out.print("Elements in the stack: ");
		s.print();
				
		//checking top function
		System.out.println("Top element in stack: "+s.top());
				
		//checking isEmpty function
		System.out.println("Stack is empty: "+s.isEmpty());
			
		//dequeuing all elements in the list
		int count=s.size(); //integer variable that is set to the size of the stack which is 3
		System.out.print("Removed: ");
		for(int i=0; i<count;i++) { //pops all elements left in stack
			System.out.print(s.pop()+" ");
		}
		System.out.println();
				
		//checking isEmpty function after pop of all elements
		System.out.println("Stack is empty: "+s.isEmpty());
		
		System.out.println();
		
		System.out.println("String Stack: ");
		//checking StackWithQueues creation/constructor
		StackWithQueues<String> s2=new StackWithQueues<String>(); //created a generic stack with stacks of strings
						
		//checking push function
		//pushed 5 elements
		s2.push("a");
		s2.push("s");
		s2.push("d");
		s2.push("f");
		s2.push("g");
		System.out.print("Added: ");
		s2.print(); //printing the stack after all elements have been pushed
						
		//checking size function
		System.out.println("Size of stack: "+s2.size());
						
		//checking pop function
		System.out.print("Removed: ");
		for(int i=0; i<2;i++) { //pops two elements in the stack
			System.out.print(s2.pop()+" ");
		}
		System.out.println();
						
		//checking size function after popping
		System.out.println("Size of stack: "+s2.size());
						
		//checking print function after pushing and popping
		System.out.print("Elements in the stack: ");
		s2.print();
						
		//checking top function
		System.out.println("Top element in stack: "+s2.top());
						
		//checking isEmpty function
		System.out.println("Stack is empty: "+s2.isEmpty());
					
		//dequeuing all elements in the list
		int count2=s2.size(); //integer variable that is set to the size of the stack which is 3
		System.out.print("Removed: ");
		for(int i=0; i<count2;i++) { //pops all elements left in stack
			System.out.print(s2.pop()+" ");
		}
		System.out.println();
						
		//checking isEmpty function after pop of all elements
		System.out.println("Stack is empty: "+s2.isEmpty());
	}
}
