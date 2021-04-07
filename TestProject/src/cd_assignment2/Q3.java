package cd_assignment2;

import ds_lab4.GQueue;
import ds_lab4.GStack;

public class Q3 {
	public static void main(String[] args) {
		//case 1 - correct
		String str="kayak";
		System.out.println("Result: " + checkPalin(str));
		
		//case 2 - correct
		String str2="tacocat";
		System.out.println("Result: " + checkPalin(str2));
		
		//case 3 - correct
		String str3="go dog";
		System.out.println("Result: " + checkPalin(str3));
		
		//case 4 - correct
		String str4="step on no pets";
		System.out.println("Result: " + checkPalin(str4));
		
		//case 5 - wrong
		String str5="hello";
		System.out.println("Result: " + checkPalin(str5));
		
		//case 6 - wrong
		String str6="got dog";
		System.out.println("Result: " + checkPalin(str6));
		
		//case 7 - correct
		String str7="gotd t o g ";
		System.out.println("Result: " + checkPalin(str7));
	}
	
	//function that checks if the given string is a palindrome
	static boolean checkPalin(String str) {
		GStack<Character> stack=new GStack<Character>(); //generic stack of characters
		GQueue<Character> queue=new GQueue<Character>(); //generic queue of characters
		for(int i=0; i<str.length();i++) { //fills in the stack and queue with characters from the given string
			stack.push(str.charAt(i));
			queue.enqueue(str.charAt(i));
		}
		for(int i=0; i<str.length()/2;i++) { //iterates through half of the string
			if(stack.top()==' ') { //checks if the top element of stack is a space
				while(stack.top()==' ') { //removes all the space
					stack.pop();
				}
			}
			if(queue.peek()==' ') { //checks if the first element in the queue is a space
				while(queue.peek()==' ') { //removes all the space
					queue.dequeue();
				}
			}
			if(stack.top()==queue.peek()) { //checks if the top element of stack is the same as first element of queue
				stack.pop(); //pop the value if same
				queue.dequeue(); //dequeue the value if same
			} else { //otherwise return false
				return false;
			}
		}
		
		return true; //returns true by default
	}
}
