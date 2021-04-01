package cd_assignment1;

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
		char[] ch=str.toCharArray(); //converting the given string to a character array
		int curr=(str.length()); //serves as a current position for the character values at the end of the string
		for(int i=0;i<str.length()/2;i++) { //for loop that executes through half string/character array
			curr--; //decrement curr
			if(ch[i]!=' ') { //then checks if the character is not a ' '
				stack.push(ch[i]); //pushes the character value into stack
				if(ch[curr]==' ') { //checks for spaces
					while(ch[curr]==' ') { //iterates through each space
						curr--; //decrements curr
					}
				} 
				if(stack.top()==ch[curr]) { //checks if the character value matches its mirror end/side
					stack.pop(); //if so, pop the value in the stack
				}
			}
		}
		if(stack.isEmpty()) { //if stack is empty
			return true; //return true
		}
		return false; //returns false by default
	}
}