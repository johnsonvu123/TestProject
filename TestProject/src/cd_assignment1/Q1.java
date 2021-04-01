package cd_assignment1;

import ds_lab4.GStack;

public class Q1 {
	public static void main(String[] args) {
		//right case
		String r="300 5 +"; //string literal
		System.out.println("Result: "+calcPF(r)); //string literal passed through function calcPF
		
		//right case 2
		String x="300 5 / 8 9 + * 65 -"; //string literal
		System.out.println("Result: "+calcPF(x)); //string literal passed through function calcPF
		
		//wrong case
		String y="5 / 8 9 + * 65 -"; //string literal
		System.out.println("Result: "+calcPF(y)); //string literal passed through function calcPF
		
		//wrong case 2
		String z="hello"; //string literal
		System.out.println("Result: "+calcPF(z)); //string literal passed through function calcPF
		
		//wrong case 3
		String a="300 5 / 8 9 + * 6"; //string literal
		System.out.println("Result: "+calcPF(a)); //string literal passed through function calcPF
		
	}
	
	//function that calculates the postfix notation
	static int calcPF(String numstr) {
		GStack<Integer> stack=new GStack<Integer>(); //generic stack of integers
		int x=0, y=0; //x and y variables
		char[] ch=numstr.toCharArray(); //character array
		String s=""; //empty string
		//iterates through each character in the given string
		for(int i=0;i<ch.length;i++) {
			if(ch[i]==' ' || ch[i]==',') { //skips the spaces/delimiters
				continue;
			} else if(ch[i]>='0' && ch[i]<='9'){ //checks if the character is an operand/number
				while(ch[i]>='0' && ch[i]<='9') { //iterates until it reaches a character that is not a digit
					if(i<ch.length-1) {
						s=s+""+ch[i]; //takes in a digit and puts it into a string literal
						i++; //increment the i to ensure each character that is taken in is accounted for in the for loop
					} else {
						System.out.println("\nCannot calculate. Please try again.");
						return -1;
					}
					
				}
				int a=Integer.parseInt(s); //parses the string into integers
				stack.push(a); //pushes the integer into the stack
				//stack.print();
				s=""; //resets the s string
			
			} else { //otherwise execute this block
				if(stack.size()>=2) { //if an operator is found and the stack has two integer values
					y=stack.pop(); //initializes the y variable with the value popped from the stack
					x=stack.pop(); //initializes the x variable with the value popped from the stack
					switch(ch[i]) { //checks the operator and switches to an operation
					case '+': //adds when the operator is '+'
						//System.out.println("Adding: "+x+" + "+y);
						stack.push(x+y); //pushes the sum into the stack
						//stack.print();
						break;
					case '-': //subtracts when the operator is '-'
						//System.out.println("Subtracting: "+x+" - "+y);
						stack.push(x-y); //pushes the difference into the stack
						//stack.print();
						break;
					case '*': //multiplies when the operator is '*'
						//System.out.println("Multiplying: "+x+" * "+y);
						stack.push(x*y); //pushes the product into the stack
						//stack.print();
						break;
					case '/': //divides when the operator is '/'
						//System.out.println("Dividing: "+x+" / "+y);
						stack.push(x/y); //pushes the quotient into the stack
						//stack.print();
						break;
					}
				} else { //else print statement that says it cannot be calculated and return -1
					System.out.println("\nCannot calculate. Please try again.");
					return -1;
				}
			}
		}
		
		
		return stack.pop(); //returns the result in the stack
	}
	
	

}
