package interviewQ;

import java.util.HashMap;
import java.util.HashSet;


/**
 * Find the number of pairs in an array whose difference is K
 *
 */
public class FindDifference {
	/******************************************************************
	 * way 1 Analysis
	 * Time complexity: O(N)
	 * Space complexity: O(N) (hashset created)
	 */

	public static int way1(int[] arr, int k){
		int count=0;
		HashSet<Integer> mySet = new HashSet<Integer>();
		for(int i:arr)  mySet.add(i);
		for(int n=0; n<arr.length;n++){
			int cur=arr[n];
			if( mySet.contains(cur)){
				count++;
			}

		}
		return count;
	}


	/*
	for(i=0;i<Arr.length;i++) {
		  Hashmap.add(Arr[i])
		}
		count=0;
		for(j=0;j<Arr.length;j++) {

		  if(Hashmap.containsKey(Arr[j]+k))
		     count++;

		}
		Time complexity: O(N) whereas your approach = O(NlogN)

		Edit:-

		Note:- My approach has extra space complexity of O(N) for Hash table whereas suggested approach is inplace.
	 */
}
