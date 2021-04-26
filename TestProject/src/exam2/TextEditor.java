package exam2;

class DNode { //question 3 / double link list node
	public char value;
	public DNode next, prev;
	
	DNode(char value) { //constructor for a single value
		this.value =value;//1
		next = null; //1
		prev = null; //1
	}

}

public class TextEditor {
	DNode head, tail;
	DNode cursor;
	int length;
	
	TextEditor(){
		this.head=null;
		this.tail=head;
		this.cursor=head;
		this.length=0;
	}
	
	//moves the cursor to the left in the linked list
	public void left() {
		if(cursor.prev==null) { //if at the beginning do nothing
			return;
		} else {
			//System.out.println("Cursor moved left");
			cursor=cursor.prev;
		}
	}
	
	//moves the cursor to the right in the linked list
	public void right() {
		if(cursor.next==null) { //if at the end, do nothing
			return;
		} else {
			//System.out.println("Cursor moved right");
			cursor=cursor.next;
		}
	}
	
	//returns the size of the linked list
	public int size() {
		return this.length;
	}
	
	//inserts a character after the cursor
	public void insert(char c) {
		if(this.head==null) { //if empty, fill the head node
			DNode charAdded=new DNode(c);
			this.head=charAdded;
			this.tail=this.head;
			this.cursor=this.head;
			this.length++;
		} else {
			if(cursor.next==null) { //if at the end of list
				DNode charAdded=new DNode(c); //adding link with value in it
				this.cursor.next=charAdded; //sets the link next to the tail to the new link
				charAdded.prev=this.tail; //sets the link previous to the new link to the "old" tail
				this.tail=charAdded; //sets the tail to the new link
				this.length++;
				
			} else { //otherwise
				DNode charAdded=new DNode(c);
				DNode charAfter=this.cursor.next;
				this.cursor.next=charAdded;
				charAdded.prev=this.cursor;
				charAdded.next=charAfter;
				charAfter.prev=charAdded;
				this.length++;
			}
		}
	}
	
	//deletes the character after the cursor (if not at end)
	public char delete() {
		if(this.length==0) { //if there is no character in list
			System.out.println("No character after cursor to delete");
			return ' ';
		} else if(cursor.next==this.tail){ //if cursor is right before the tail node
			DNode charDeleted=this.tail;
			this.tail=charDeleted.prev;
			this.tail.next=null; //the next tail is set to null
			this.length--; //decrement the size
			char value=charDeleted.value; //temporary value set to the temp value
			return value; //returns the value popped
		} else if(cursor.prev==null&& cursor.next==null){ //if the cursor is at the head node
			DNode charDeleted=this.head;
			this.head=null;
			this.tail=this.head;
			cursor=this.head;
			this.length--;
			char value = charDeleted.value;
			return value;
		}else { //otherwise
			DNode charDeleted=cursor.next;
			cursor.next=charDeleted.next;
			cursor.next.prev=cursor;
			this.length--;
			char value=charDeleted.value;
			return value;
			
		}
	}
	
	//prints the list of characters
	public void print() {
		DNode curr=this.head;
		while(curr!=null) {
			if(curr==this.cursor) {
				System.out.print("["+curr.value+"]");
				curr=curr.next;
			} else {
				System.out.print(curr.value);
				curr=curr.next;
			}
		}
		System.out.println();
	}

}
