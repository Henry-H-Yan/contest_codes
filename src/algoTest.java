import java.util.ArrayList;
import java.util.Arrays;



public class algoTest {



	/**
	 * Given int array, get the element that appears more than n/2 times (majority)
	 * Runtime complexity: O (n) linear scan
	 */

	@SuppressWarnings("null")
	public static Object majorityElement(int [] in){
		int cur=in[0];
		int freq=1;
		for(int pos=1;pos<in.length;pos++){
			if (in[pos]==cur) freq++;

			// not same
			if(freq>=1) freq--;
			else{
				cur=in[pos]; freq=0;
			}

		}
		//System.out.println(freq);
		if(freq<1) {System.out.print("illegal arguments, no such elements exist"); return null; 
		}
		return cur;
	}

	/**
	 * 
	 *  
	 * @param num
	 * @return  all lists of size 3 that sum to 0
	 * 
	 * Run time: O (n ^2), (essentially double for loop)
	 */

	public static ArrayList<ArrayList<Integer>> threeSumList(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if (num.length < 3){
			throw new IllegalArgumentException("size can't be < 3");
		}

		// sort array
		Arrays.sort(num);

		for (int i = 0; i < num.length - 2; i++) {

			
			if (i == 0 || num[i] > num[i - 1]) {

				int negate = -num[i];

				
				// see if the rest of array has two int summing to -num[i]
				int start = i + 1;
				int end = num.length - 1;

				while (start < end) {
					//case 1
					if (num[start] + num[end] == negate) {
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(num[i]); temp.add(num[start]);  temp.add(num[end]);
						result.add(temp);
						start++;
						end--;
						//to skip duplicate soln
						while (start < end && num[start] == num[start - 1])	start++;
						
						while (start < end && num[end] == num[end + 1])		end--;

					
					} else if (num[start] + num[end] < negate) {
					 //too small
						start++;
						
					} else {
						//too big
						end--;
					}
				}

			}
		}

		return result;
	}


	public static void main(String args[] ) throws Exception {
		int[] arr={1,2,2,3,3,3,2};
		System.out.println(majorityElement(arr));
		
		 int[] arr1= {-1, 0, 1, 2,-1, -4, 5,3,-8,2,-4};
		 System.out.println(  threeSumList  ( arr1));

	}

}
