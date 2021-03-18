package default_package;

import java.util.Scanner;

public class DSLab_1 {
	public static void main(String[] args){
		
		//Problem 1
		
	//	printLeapYear();
		
		//Problem 2
		
		//iterativeFib();
		
		//System.out.println();
		
		printRecursive();
		
		//Comment on fibonacci
		
		/* (Same answer will be in the C++ source code too)
		 * The iterative method is more efficient than the recursive method because it requires less stack space which means less memory used.
		 */
		
	}
	
	//Problem 1 function
	public static boolean isLeapYear(int x) {
		boolean leap=false;
		if(x % 4==0) {
			if(x%100==0){
				if(x%400==0) {
					leap=true;
				}
				else
					leap=false;
			
			}
			else
				leap=true;
		}
		return leap;
			
		
	}
		
	public static void printLeapYear() {
		int year=2000, year2=1900, year3=2001, year4=2004, userYear;
		
		System.out.println(year+": "+isLeapYear(year));
		System.out.println(year2+": "+isLeapYear(year2));
		System.out.println(year3+": "+isLeapYear(year3));
		System.out.println(year4+": "+isLeapYear(year4));
		
		System.out.println("Enter a year: ");
		
		Scanner scan=new Scanner(System.in);
		
		userYear=scan.nextInt();
		
		System.out.println("User Year: "+userYear+": "+isLeapYear(userYear)+"\n");
	}
		
	//Problem 2 functions
	
	//fibonacci through recursive method
	public static int recursiveFib(int y)
	{
		if (y<=1)
			return y;
		else
			return recursiveFib(y-1)+recursiveFib(y-2);
	}
	
	//printing recursive fibonacci
	public static void printRecursive() {
		int count2;
		
		System.out.print("\nEnter an input: ");
		
		Scanner scan=new Scanner(System.in);
		
		count2=scan.nextInt();
		
		for(int i=0; i<count2+1;i++) {
			System.out.print("\nfib("+i+") is "+recursiveFib(i));
		}
	}
	
	// fibonacci through iterative method
	public static void iterativeFib() {
		int n=0, n2=1, n3, count;
		
		Scanner scan=new Scanner(System.in);
		
		System.out.print("Enter an input: ");
		
		count=scan.nextInt();
		
		if(count>=0)
			System.out.print("\nfib(0) is "+n);
		
		if(count>=1)
			System.out.print("\nfib(1) is "+n2);
		
		if (count>=2) {
			for(int i=2; i<count+1;i++){
				n3=n2+n;
				System.out.print("\nfib("+i+") is "+n3);
				n=n2;
				n2=n3;
			}
		}
	}

}
