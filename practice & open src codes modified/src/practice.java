
import java.math.BigInteger;
import java.util.Map;
import java.util.TreeMap;
import java.io.*;
public class  practice{
	// Note: a treemap is used to store the fibonacci numbers that have already been calculated, .
	static Map<Integer, BigInteger> memo = new TreeMap<Integer, BigInteger>();

	public static void main (String[] args) throws IOException{
		practice c=new practice();

		int[] arr={23,4,3,5,0,1,-2,4};
		c.sort(arr);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+ "_");
		}
		System.out.println();
		System.out.println("GroupSum:");

		int start =2; int[] nums= {0,4,5,10}; int t= 15;
		boolean b= c.groupSum(start, nums, t);
		System.out.println("ans is "+ b);
	}


// bubble sort
	public void sort(int[] a) {
		int temp = 0;
		for (int i = a.length - 1; i > 0; --i) {
			for (int j = 0; j < i; ++j) {
				if (a[j + 1] < a[j]) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}


	static int fibonacci(int n) {
		if (n <= 1) {
			return 1;
		}	
		else {
			return fibonacci(n-1) + fibonacci(n-2);

		}
	}

	static BigInteger memoizedFibonacci(int n)
	{
		if (n <= 1) return BigInteger.ONE;
		if (memo.get(n) == null)
		{
			memo.put(n, memoizedFibonacci(n-1).add(memoizedFibonacci(n-2)));
		}
		return memo.get(n); 
	}

	public boolean groupSum(int start, int[] nums, int target) {
		if (start >= nums.length) return (target == 0);
		if (groupSum(start + 1, nums, target - nums[start])) {

			return true;
		}
		if (groupSum(start + 1, nums, target)){ 
			return true;
		}
		return false;

	}


}

