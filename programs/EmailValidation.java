//Write a program to search the email id entered by user
package deepic;

import java.util.Scanner;

public class EmailSearch {

	public static void main(String[] args) {
		String[] strarr= {"abc@gmail.com",
				          "bcd@gmail.com",
				          "cde@gmail.com",
				          "def@gmail.com",
				          "efg@gmail.com",
				          "fgh@gmail.com",
				          "ghi@gmail.com",
				          "hij@gmail.com",
				          "ijk@gmail.com",
				          "jkl@gmail.com",
				          "klm@gmail.com"
		};
		String s;
		int c=0;//counter
		Scanner sin=new Scanner(System.in);
		System.out.println("Enter user email:");
		s=sin.nextLine();//input given by user
		sin.close();
		for(int i=0;i<strarr.length;i++) {
			boolean b=strarr[i].equalsIgnoreCase(s);//It will Ignore the case.Accept uppercase and lowercase 
			if(b==true)
			{
				System.out.println("Email search found...");
				c=1;
				break;
			}
		}
		if(c==0) {
			System.out.println("Email search not found...");
		}

	}

}
