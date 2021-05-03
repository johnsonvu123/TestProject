package finals;

public class PrimeMain {
	public static void main(String[] args) {
		//case 1
		PrimeFind prime=new PrimeFind(15);
		prime.findPrimes();
		prime.printPrimes();
		
		//case2
		PrimeFind prime2=new PrimeFind();
		prime2.findPrimes();
		prime2.printPrimes();
		
		
		prime2.checkPrime(5, 10);
		prime2.checkPrime(10, 100);
	}

}
