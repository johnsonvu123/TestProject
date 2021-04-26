package exam2;

public class Capital {
	GQueue queue=new GQueue();
	int dayCounter=0;
	
	//adds a stock into the queue with number of shares and dollar value
	public void buy(int share, int value) {
		Stock stock=new Stock(share, value);
		queue.enqueue(stock);
		stock.setDay(++dayCounter);
		System.out.println("Day "+this.dayCounter+": "
				+stock.getShares()+" shares bought at $"
				+stock.getValue()+" each.");
	}
	
	//sells based on given parameters and returns the capital gain or loss
	public int sell(int share, int value) {
		int gain=0; //total gain or loss
		int difference=0; //difference between given dollar value and stock value
		int stockGain=0; //individual stock gain or loss
		this.dayCounter++;
		System.out.println("Day "+this.dayCounter+": "
		+ share+" shares sold at $"
		+ value+" each.");
		if(share>0) { //if shares is greater than zero
			do { //do this execution before checking the while condition
				Stock stock=queue.peek();
				if(stock.getShares()<=share) { //if stock shares is less or equal to the given share
					difference=value-stock.getValue(); //calculate the difference
					stockGain=stock.getShares()*difference; //calculate the individual stock gain/loss
					gain+=stockGain; //add that into the total gain
					share-=stock.getShares(); //reduce the given share for the next loop
					queue.dequeue(); //remove the stock
				} else if(stock.getShares()>share) { //if stock shares is greater than the given share
					difference=value-stock.getValue(); //calculate the difference
					stock.setShares(stock.getShares()-share); //calculate the leftover stock share and update it
					stockGain=share*difference; //calculate the individual stock gain/loss
					gain+=stockGain; //add it into the total gain
					share=0; //set share to 0, ending the do while loop
				}
			} while(share>0); //continue while share is greater than 0
		} else { //if share is 0
			return 0;
		}
		return gain; //return the total gain/loss
	}
	
	//prints the remaining stocks in the queue as well as the day it was bought
	public void print() {
		if(queue.size()>queue.max()) { //prints the queue when the array is full and has links after the head link
			for(int i=0;i<5;i++) {
				System.out.print(queue.head.data[i].getShares()+" shares at $"
				+queue.head.data[i].getValue()+" each bought on day "
				+queue.head.data[i].getDay()+"\n");
			}
			StockNode currLink=queue.head.next;
			while(currLink!=null) {
				System.out.print(currLink.value.getShares()+" shares at $"
			+currLink.value.getValue()+" each bought on day "
			+currLink.value.getDay()+"\n");
				currLink=currLink.next;
			}
			System.out.println();
		} else { //otherwise print the array only
			for(int i=0;i<queue.size();i++) {
				System.out.print(queue.head.data[i].getShares()+" shares at $"
				+queue.head.data[i].getValue()+" each bought on day "
				+queue.head.data[i].getDay()+"\n");
			}
			System.out.println();
		}
	}

}
