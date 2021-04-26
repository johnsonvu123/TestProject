package exam2;

public class TextEditorMain { //question 3
	public static void main(String[] args) {
		TextEditor text=new TextEditor();
		
		//checking insert function with right function
		text.insert('J');
		text.print();
		text.right();
		text.insert('o');
		text.print();
		text.right();
		text.insert('h');
		text.print();
		text.right();
		text.insert('n');
		text.print();
		text.right();
		text.insert('s');
		text.print();
		text.right();
		text.insert('o');
		text.print();
		text.right();
		text.insert('n');
		text.print();
		text.right();
		text.insert(' ');
		text.print();
		text.right();
		text.insert('V');
		text.print();
		text.right();
		text.insert('u');
		text.print();
		text.right();
		
		//checking left function with delete function
		for(int i=0; i<10;i++) {
			text.left();
			text.delete();
			text.print();
		}
	}

}
