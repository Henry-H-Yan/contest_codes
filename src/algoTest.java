

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
	public static void main(String args[] ) throws Exception {
	int[] arr={1,2,2,3,3,3,2};
	 System.out.println(majorityElement(arr));
	
	}

}
