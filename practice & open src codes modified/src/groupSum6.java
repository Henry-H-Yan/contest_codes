
public class groupSum6 {
	int target;
	public boolean groupSum6(int start, int[] nums, int target) {
		if(start >= nums.length)
			return (target == 0);

		int diff = target - (6 * count6(start, nums));
		if(groupSum(start, nums, diff))
			return true;
		return false;

	}
	public int count6(int start, int [] nums)
	{
		int count = 0;
		if(nums[start] == 6)
		{
			count++;
			nums[start] = 0;
		}
		if(start + 1 < nums.length)
			count += count6(start + 1, nums);
		return count;
	}
	//this one (below) is the solution to groupSum but include it
	//in groupSum6
	public String printArr(int[] arr){
		StringBuilder s=new StringBuilder();
		for(int i:arr){
			s.append(""+ i+" ");
		}
		return s.toString();
	}
	public boolean groupSum(int start, int[] nums, int target) {
		if (start >= nums.length) return (target == 0);
		if (groupSum(start + 1, nums, target - nums[start])) return true;//has the  first
		if (groupSum(start + 1, nums, target)) return true;// doesn't have first
		return false;
	}
	public static void main(String[] args){
		groupSum6 test=new groupSum6();
		int x=4, start=0;               int target=208;
		int[] nums={1,2,5,9,100};
		System.out.println("start is " +start);
		System.out.println("num is: " +test.printArr(nums));
		System.out.println("target is " +target);
	
		
		System.out.println("groupSum is " +test.groupSum(start,nums, target));

		String ret = "There " + (x > 1 ?    ("are " + x 
				+ " cookies") : "is one cookie") +     " in the jar.";
		String ret2="there" +(x>1? ("are "+x+" cookies "): ("is 1 c") )  
			+"in he jar";
		
		
		System.out.println(ret);
		
		
	}
}
