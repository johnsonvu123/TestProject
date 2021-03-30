package ds_lab4;

public class GStackMain {
	public static void main(String[] args) {
		
		//generic stack of integers
		GStack<Integer> stack=new GStack<Integer>();
		//pushing into stack
		for(int i=0;i<stack.capacity();i++) {
			System.out.println(stack.push(i*10));
		}
		
		//checking the stack and size
		stack.print();
		System.out.println("The size of the stack is "+stack.size());
		
		//checking push method when the head link reaches capacity
		System.out.println(stack.push(50));
		
		//checking the stack and size
		stack.print();
		System.out.println("The size of the stack is "+stack.size());
		
		//checking pop method
		stack.pop();
		stack.pop();
		
		//checking the stack and size
		stack.print();
		System.out.println("The size of the stack is "+stack.size());
		
		//checking top method
		System.out.println(stack.top());
		//checking get method
		System.out.println(stack.get(0));
		//checking get method
		System.out.println(stack.get(3));
		
		//generic stack of strings
		GStack<String> stack2=new GStack<String>();
		//pushing string into stack2
		for(int i=0;i<stack2.capacity();i++) {
			System.out.println(stack2.push("way"));
		}
		
		//checking the stack and size
		stack2.print();
		System.out.println("The size of the stack is "+stack2.size());
		
		//pushing value into stack2 when head link reaches capacity
		System.out.println(stack2.push("hero"));
		
		//checking the stack and size
		stack2.print();
		System.out.println("The size of the stack is "+stack2.size());
		
		//checking pop method
		stack2.pop();
		stack2.pop();
		
		//checking the stack and size
		stack2.print();
		System.out.println("The size of the stack is "+stack2.size());
		
		//checking top method
		System.out.println(stack2.top());
		//checking get method
		System.out.println(stack2.get(0));
		//checking get method when out of bounds
		System.out.println(stack2.get(5));
		
		
	}

}
