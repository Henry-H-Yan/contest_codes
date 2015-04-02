package interviewQ;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Java program to calculate and print Fibonacci number using both recursion and Iteration.
 * Fibonacci number is sum of previous two Fibonacci numbers fn= fn-1+ fn-2
 * first 10 Fibonacci numbers are 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
 * @author
 */
public class FibonacciCalculator {
	// instance variable
	public static HashMap<Integer,Integer> memo= new HashMap<Integer, Integer>();

	public static void main(String args[]) {

		System.out.println("mm Enter number upto which Fibonacci series to print: ");
		int number = new Scanner(System.in).nextInt();

		System.out.println("Fibonacci series upto " + number +" numbers : ");

		for(int i=1; i<=number; i++){
			System.out.print(memoFibo(i) +" ");
		}


	} 

	public static int memoFibo(int n){
		if(n==1||n==2)
			return 1;
		if(memo.containsKey(n))
			return memo.get(n);
		int ans=memoFibo(n-1)+memoFibo(n-2);
		memo.put(n, ans);
		return ans;
	}

	public static int fibonacci(int number){
		if(number == 1 || number == 2){
			return 1;
		}

		return fibonacci(number-1) + fibonacci(number -2); //tail recursion
	}

	/*
	 * Java program to calculate Fibonacci number using loop or Iteration.
	 * @return Fibonacci number
	 */
	public static int fibonacci2(int number){
		if(number == 1 || number == 2){
			return 1;
		}
		int fibo1=1, fibo2=1, fibonacci=1;
		for(int i= 3; i<= number; i++){
			fibonacci = fibo1 + fibo2; //Fibonacci number is sum of previous two Fibonacci number
			fibo1 = fibo2;
			fibo2 = fibonacci;

		}
		return fibonacci; //Fibonacci number

	}   

}