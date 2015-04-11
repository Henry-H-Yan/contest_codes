/**
 * 
 * Given an int array, is it possible to split them into two non-empty 
 * ones with samw sum, given condition that the multiples of 5 and 
 * multiples of 3 are in distinct arrays? 
 * 
 * @author henry-yan
 *
 */
public class split53 {

	public boolean run(int[] nums) {
		  return helper53(0,nums,0,0);
	}
public boolean helper53(int start, int[] nums, int sum1, int sum2){
	if (start==nums.length) return sum1==sum2;
	int cur=nums[start];
	if(cur%5==0) return helper53(start+1,nums,sum1+cur,sum2);
	if(cur%3==0) return helper53(start+1,nums,sum1,sum2+cur);
			
	else return helper53(start+1,nums,sum1,sum2+cur) ||
			    helper53(start+1,nums,sum1+cur,sum2);
	
}
}
