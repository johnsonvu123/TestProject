package default_package;

public class Lab1_data {
	public static void main(String[] args){
		/*
		int count=0;
		for(int i=50;i<640;i++){
			
			for(int j=2;j<10;j++) {
				System.out.println("y");
				count++;
			}
			count++;
		}
		
		System.out.println(count);
		*/
		
		int [] nums1= {1,2,3,4,5,6,7}; //first array
		int [] nums2= {7,2,0,10}; //second array
		int [] arr1 = new int [10]; //third array for intersection
		int count=0; //this is for arr1 to use as sort of a counter
		
		int length1=nums1.length;
		int length2=nums2.length;
		
		int x;
		int y;
		
		for(int i=0; i<length1;i++) {
			x=nums1[i]; //this initializes an element of the first array to x
			for(int j=0; j<length2;j++) {
				y=nums2[j]; //this initializes an element of the second array to y
				
				if(x==y) { //this is used to compare/find intersections
					arr1[count]=x; // this initializes said intersection to an element in the third array
					count++;
				}
					
			}
		}
		System.out.print("(");
		for(int a=0;a<length1;a++) {
			if(a==length1-1) 
				System.out.print(nums1[a]);
			
			else
				System.out.print(nums1[a]+",");
		}
		System.out.println(")");
		
		System.out.print("(");
		for(int a=0;a<length2;a++) {
			if(a==length2-1) 
				System.out.print(nums2[a]);
			
			else
				System.out.print(nums2[a]+",");
		}
		System.out.println(")");
		
		System.out.print("(");
		for(int a=0;a<count;a++) {
			if(a==count-1) 
				System.out.print(arr1[a]);
			
			else
				System.out.print(arr1[a]+",");
		}
		System.out.println(")");
	}

}
