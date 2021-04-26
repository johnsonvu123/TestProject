package exam2;

public class CapitalMain {  //question 2
	public static void main(String[] args) {
		Capital cap=new Capital();
		
		//checking buy function
		cap.buy(100, 20);
		cap.buy(20, 24);
		cap.buy(200, 36);
		
		//checking the stocks in queue
		System.out.println();
		cap.print();
		
		//checking sell function / checking gain
		System.out.println("Total Gain/Loss: $"+cap.sell(150, 30));
		
		//checking the stocks after sell function
		System.out.println();
		cap.print();
		
		//buying more stocks
		cap.buy(50, 25);
		cap.buy(40, 17);
		cap.buy(39, 40);
		
		//checking stocks
		System.out.println();
		cap.print();
		
		//selling stocks / checking loss
		System.out.println("Total Gain/Loss: $"+cap.sell(250, 30));
		
		//checking stocks after sold
		System.out.println();
		cap.print();
	}

}
