//Given an array of ints, is it possible to choose a group of
//some of the ints, beginning at the start index, such that the 
//group sums to the given target? However, with the additional 
//		constraint that all 6's must be chosen. (No loops needed.) 
//
//groupSum6(0, {5, 6, 2}, 8)  true
//groupSum6(0, {5, 6, 2}, 9)  false
//groupSum6(0, {5, 6, 2}, 7)  false

// Must choose all 6

public class groupSum6{
	public boolean groupSum6(int start, int[] nums, int target) {
		if(start>=nums.length|| target<0) return false;
		if(target==0) return true;
		if(nums[start]==6){
	
			return groupSum6(start++,nums,target-6);
		}else{
			return groupSum6(start++,nums,target)  // doesn't include first
					|| groupSum6(start++,nums,target-nums[start]);

		}

	}

	
	/**
	 * possible  to split array to two with same sums?
	 * recursive solution
	 * @param nums
	 * @return
	 */
	public boolean splitArray(int[] nums) {
		int end=nums.length-1;
	 return helper1(nums,0,0,0,end);
	}
	public boolean helper1(int[] nums, int sum1, int sum2, int start,int end){
		if(start>end) return sum1==sum2;
		return helper1(nums,sum1+nums[start], sum2, start+1,end)
				|| helper1(nums,sum1, sum2+nums[start], start+1,end);
		
	}
	

	
	
	public boolean splitArray2(int[] nums) {
	    return helper(0, nums, 0, 0);
	}
	 
   private boolean helper(int start, int[] nums, int sum1, int sum2){
	   if(start>=nums.length) return sum1==sum2;  // End condition
	   return helper(start+1,nums,sum1+nums[start], sum2)
			   || helper(start+1,nums,sum1, sum2+nums[start]);
	   
   }

}