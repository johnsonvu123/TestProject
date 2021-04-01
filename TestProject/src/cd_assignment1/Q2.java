package cd_assignment1;

import ds_lab4.GStack;

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
		GStack<Character> stack=new GStack<Character>(); //generic stack of characters
		char[] ch=str.toCharArray(); //converting the given string to a character array
		for(int i=0;i<str.length();i++) { //for loop that executes through the whole string/character array
			if(ch[i]==' ' || ch[i]==',') { //skips spaces/delimiters if there are
				continue;
			} else if(ch[i]=='(') { //checks for '('
				stack.push(ch[i]); //pushes the character into stack when '(' is found
			} else if(ch[i]==')') { //checks for ')'
				if(stack.isEmpty()) { //checks if the stack is empty, if so, it will return false
					System.out.println("Not Balanced");
					return false;
				}
				stack.pop(); //pops the value in the stack when ')' is found
			} else { //otherwise the given string is wrong and returns false
				System.out.println("Wrong format");
				return false;
			}
		}
		System.out.println("Balanced");
		return true; //returns true by default
	}

}
