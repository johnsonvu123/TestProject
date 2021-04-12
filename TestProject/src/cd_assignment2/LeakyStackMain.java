package cd_assignment2;

public class LeakyStackMain {
	public static void main(String[] args) {
		System.out.println("Integer Leaky Stack: ");
		LeakyStack<Integer> stack=new LeakyStack<Integer>(); //integer leaky stack
		//pushing integers into stack
		for(int i=0; i<10;i++) { //pushes 10 integers
			stack.push(i+5);
			//stack.printAll();
		}
		System.out.print("Elements in Stack: ");
		stack.print();
		
		//checking get function
		System.out.println("Get: "+stack.get(3));
		
		//checking top function
		System.out.println("Top: "+stack.top());
		
		//checking pop function
		for(int i=0; i<5;i++) { //empties the stack
			stack.pop();
			//stack.printAll();
		}
		System.out.print("Elements in Stack: ");
		stack.print();
		
		//checking get function
		System.out.println("Get: "+stack.get(0));
		
		//checking top function
		System.out.println("Top: "+stack.top());
		
		//checking push function again
		for(int i=0; i<2;i++) { //pushing two integers
			stack.push(i+5);
			//stack.printAll();
		}
		System.out.print("Elements in Stack: ");
		stack.print();
		
		//checking get function
		System.out.println("Get: "+stack.get(0));
		
		//checking top function
		System.out.println("Top: "+stack.top());
		
		//checking push function again
		for(int i=0; i<4;i++) { //pushing four integers
			stack.push(i+5);
			//stack.printAll();
		}
		System.out.print("Elements in Stack: ");
		stack.print();
		
		//checking get function
		System.out.println("Get: "+stack.get(3));
		
		//checking top function
		System.out.println("Top: "+stack.top());
		
		System.out.println();
		
		System.out.println("String Leaky Stack: ");
		LeakyStack<String> stack2=new LeakyStack<String>(); //string leaky stack
		
		//pushing strings into stack
		for(int i=0; i<10;i++) { //pushes 10 strings
			stack2.push("y");
			//stack2.printAll();
		}
		System.out.print("Elements in Stack: ");
		stack2.print();
		
		//checking get function
		System.out.println("Get: "+stack2.get(3));
		
		//checking top function
		System.out.println("Top: "+stack2.top());
		
		//checking pop function
		for(int i=0; i<5;i++) { //empties the stack
			stack2.pop();
			//stack2.printAll();
		}
		System.out.print("Elements in Stack: ");
		stack2.print();
		
		//checking get function
		System.out.println("Get: "+stack2.get(0));
		
		//checking top function
		System.out.println("Top: "+stack2.top());
		
		//checking push function again
		for(int i=0; i<2;i++) { //pushing two strings
			stack2.push("o");
			//stack2.printAll();
		}
		System.out.print("Elements in Stack: ");
		stack2.print();
		
		//checking get function
		System.out.println("Get: "+stack2.get(0));
		
		//checking top function
		System.out.println("Top: "+stack2.top());
		
		//checking push function again
		for(int i=0; i<4;i++) { //pushing four strings
			stack2.push("u");
			//stack2.printAll();
		}
		System.out.print("Elements in Stack: ");
		stack2.print();
		
		//checking get function
		System.out.println("Get: "+stack2.get(3));
		
		//checking top function
		System.out.println("Top: "+stack2.top());
		
	}
}
