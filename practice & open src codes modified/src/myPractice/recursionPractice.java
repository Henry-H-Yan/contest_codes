package myPractice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class recursionPractice {

	public static boolean groupSum(int start, int[] nums, int target) {

		if (start >= nums.length) 
			return (target == 0);
		else if (groupSum(start + 1, nums, target - nums[start])) 
			return true;

		else if (groupSum(start + 1, nums, target)) 
			return true;

		else return false;
	}

	public static void count(int i, int n){
		if(i<n){
			System.out.print(i+" ");
			count(i+1,n);
		}
		System.out.print(i+" ");
	}


	public String toString(String[] a){ 
		String out="";
		for(String s:a){
			out=out+a+" ";}
		System.out.println("reached toString");
		return out;
	}


	public static void main(String [ ] args){
		recursionPractice my=new recursionPractice();
		/*int[] myI={3,4,32};
		if( groupSum(0,myI,12)) System.out.println("true!");
		int i,j,n=9;
		for(i=1;i<=n;i++){
			for(j=n;j>i;j--){
				System.out.print(" ");
			}
			count(1,i);
			System.out.println();

		}
		for(i=0;i<9;i+=2){
			System.out.println("Value of i is "+ i);
		}*/
		PriorityQueue<Integer> ex= new PriorityQueue<Integer>();
		System.out.println("Enter your username: ");
		// scanner example
		
		Scanner scanner = new Scanner(System.in);
		String username = scanner.nextLine();
		System.out.println("Your username is " + username);

		
		Queue<String> queue = new LinkedList<String>();  
		queue.offer("Hello");  
		queue.offer("World!");  
		queue.offer("ni hao a !");  
		System.out.println("queue size is "+ queue.size());  
		String str;  
		while((str=queue.poll())!=null){  
			System.out.println(".poll is "+str);  
		}  
		System.out.println();  
		System.out.println("quese size final is "+queue.size());  
	}  

}




