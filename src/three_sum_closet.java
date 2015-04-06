import java.util.Arrays;

/**
 * 
 * Given an array S of n integers, find three integers in S
 *  such that the sum is closest to a given number, target. 
 *  Return the sum of the three integers.
 *   You may assume that each input would have exactly one solution. 
 *   For example, given array S = {-1 2 1 -4}, and target = 1.
 *    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * @author henry-yan
 *
 */
public class three_sum_closet {
	public int threeSumClosest(int[] num, int target) {
		int min = Integer.MAX_VALUE;
		int result = 0;
 
		Arrays.sort(num);
 //  pointer order   i ,   j(i+1)     k (starting from end)
		for (int i = 0; i < num.length; i++) {
			int j = i + 1;
			int k = num.length - 1;
			while (i < k-1) {
				int sum = num[i] + num[j] + num[k];
				int diff = Math.abs(sum - target);
 
				if(diff == 0) return 0;
 
				if (diff < min) {
					min = diff;
					result = sum;
				}
				if (sum >= target) {
					k--;
				} else {
					j++;
				}
			}
		}
 
		return result;
	}
	
}
