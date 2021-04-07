package cd_assignment2;

import ds_lab4.GQueue;

public class Q2 {
	public static void main(String[] args) {
		//first case-correct
		String a="()";
		balanceP(a);
		
		//second case-correct
		String b="()()(())";
		balanceP(b);
		
		//third case-wrong
		String c=")(";
		balanceP(c);
		
		//fourth case-wrong
		String d="())(";
		balanceP(d);
		
		//fifth case-wrong
		String e="wrong";
		balanceP(e);
	}
	
	//function that checks if the given string has balanced parenthesis
	static boolean balanceP(String str) {
		GQueue<Character> queue=new GQueue<Character>(); //generic queue of characters
		GQueue<Character> queue2=new GQueue<Character>(); //generic queue2 of characters
		for(int i=0; i<str.length();i++) { //fills in both the queues with characters from the given string
			queue.enqueue(str.charAt(i));
		}
		for(int i=0;i<str.length();i++) { //for loop that executes through the whole string
			if(queue.peek()==' ' || queue.peek()==',') { //skips spaces/delimiters if there are
				queue.dequeue();
			} else if(queue.peek()=='(') { //checks for '('
				queue2.enqueue(queue.dequeue()); //enqueue the dequeued character from queue into queue2
			} else if(queue.peek()==')') { //checks for ')'
				queue.dequeue(); //dequeues the character
				if(queue2.isEmpty()) { //checks if the queue is empty, if so, it will return false
					System.out.println("Not Balanced");
					return false;
				}
				queue2.dequeue(); //dequeue the value in the queue2 when ')' is found
			} else { //otherwise the given string is wrong and returns false
				System.out.println("Wrong format");
				return false;
			}
		}
		System.out.println("Balanced");
		return true; //returns true by default
	}

}
