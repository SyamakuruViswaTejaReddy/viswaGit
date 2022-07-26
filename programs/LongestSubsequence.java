//write a program to find the longest increasing subsequence.
package DsArrLists;

import java.util.Scanner;

public class LongestSubsequence {

	public static void main(String[] args) {
	    int n,c=1;
		Scanner sin=new Scanner(System.in);
		 System.out.println("Enter array Size:");
		 n=sin.nextInt();
		 int[] arr=new int[n];
		 System.out.println("Enter array values:");
		 for (int i=0; i<n;i++) {
				System.out.print("arr["+i+"]:");
				arr[i]=sin.nextInt();
			}
		 System.out.println("Array values are:");
		 for (int i=0; i<arr.length;i++) {
				System.out.print(arr[i]+ " ");
			}
		 if(n!=0) {
			 for (int i=0,j=1; i<arr.length-1;i++,j++) {
				 
				 if(arr[i]<arr[j]) {	
					 c=c+1;
				 }
			}
		 }
		 else{
			 c=0; 
		 }
		 System.out.println("\nLongest Increasing subsequence:"+c);
	}

}
