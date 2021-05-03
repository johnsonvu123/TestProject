package finals;

public class PrimeFind {
	public boolean[] array;
	int size;
	
	//initializes boolean array and fills all cells with true
	PrimeFind(){
		array=new boolean[101];
		for(int i=0; i<array.length;i++) {
			array[i]=true;
		}
		this.size=array.length;
	}
	
	//initializes boolean array with given size and fills all cells with true
	PrimeFind(int m){
		this.size=m+1;
		array=new boolean[this.size];
		for(int i=0; i<array.length;i++) {
			array[i]=true;
		}
	}
	
	//checks the given index/number as prime or not
	public void checkPrime(int m, int M) {
		System.out.println("All Prime Numbers from "+m+" to "+M);
		for(int i=m;i<=M;i++) {
			if(array[i]==true) {
				System.out.print(i+" ");
			}
		}
		System.out.println();
	}
	
	//finds all non prime numbers and changes their cells to false
	public void findPrimes() {
		array[0]=false;
		array[1]=false;
		
		int n=(int) Math.sqrt(size);
		
		for(int i=2; i<=n; i++) {
			if(array[i]==true) {
				for(int j=2;i*j<this.size;j++) {
					array[i*j]=false;
				}
			}
		}
	}
	
	//prints all the primes in the array
	public void printPrimes() {
		for(int i=0; i<this.size;i++) {
			if(array[i]==true) {
				System.out.print(i+" ");
			} else {
				//System.out.print("Not Prime ");
			}
		}
		System.out.println();
	}

}
