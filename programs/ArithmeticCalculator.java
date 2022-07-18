package deepb;

import java.util.Scanner;

public class ArithmeticCalculator {

	public static void main(String[] args) {
		Scanner sin=new Scanner(System.in);
		int i;
		double a,b;
		System.out.println("The four basic Arithmetic operations");
		while(true) {
			System.out.println("1.Addition 2.Subtraction 3.Multiplication 4.Division 5.Exit");
			System.out.println("Enter a Choice(1/2/3/4/5):");
			i=sin.nextInt();
			if(i==1) {
				System.out.println("Addition Operation:");
				System.out.println("Enter a Value:");
				a=sin.nextDouble();
				System.out.println("Enter b Value:");
				b=sin.nextDouble();
				System.out.println("Addition:"+(a+b));
			}
			else if(i==2) {
				System.out.println("Subtraction Operation:");
				System.out.println("Enter a Value:");
				a=sin.nextDouble();
				System.out.println("Enter b Value:");
				b=sin.nextDouble();
				System.out.println("Subtraction:"+(a-b));
			}
			else if(i==3) {
				System.out.println("Multiplication Operation:");
				System.out.println("Enter a Value:");
				a=sin.nextDouble();
				System.out.println("Enter b Value:");
				b=sin.nextDouble();
				System.out.println("Multiplication:"+(a*b));
			}
			else if(i==4) {
				System.out.println("Division Operation:");
				System.out.println("Enter a Value:");
				a=sin.nextDouble();
				System.out.println("Enter b Value:");
				b=sin.nextDouble();
				try {
				if(b==0)
				System.out.println("Division:"+((int)a/(int)b));
				else
				System.out.println("Division:"+(a/b));
				}
				catch(ArithmeticException e) {
                System.out.println("Divide by zero causes Exception.Don't do that...");	
				}
				
			}
			else if(i==5) {
				System.out.println("Calculator closed.");
				sin.close();
				break;
			}
			else {
				System.out.println("oops you entered wrong choice...");
			}
		}
	}
}
