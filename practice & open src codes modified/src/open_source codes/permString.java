package interviewQ;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Java Program to find all permutations of a String
 *
 */
public class permString {
	public static Set<String> permutationFinder(String str) {
		Set<String> perm = new HashSet<String>();  //renewed every call
		// Handeling error scenarios
		if (str == null) {
			return null;
		} 
		
		else if (str.length() == 0) {
			perm.add("");
			return perm;
		}


		else{ 
			char initial = str.charAt(0); // first character
			String rem = str.substring(1); // string without 1st character
			Set<String> words = permutationFinder(rem);  //

			for (String strNew : words) {
				for (int i = 0;i<=strNew.length();i++){
					perm.add(charInsert(strNew, initial, i));
				}
			}
			return perm;
		}
	}
	/**
	 *  Insert char c at pos position in Str
	 */
	public static String charInsert(String str, char c, int pos) {
		String begin = str.substring(0, pos);
		String end = str.substring(pos);
		return begin + c + end;
	}


	public static int whoWins(ArrayList<Integer>  piles){
		for(int i=0;i<piles.size();i++){
			int val=piles.get(i);
			if(val>=1){
				piles.set(i, val-1);  // take one
				int result= whoWins(piles);
				piles.set(i, val);
				if(result==2) return 1;
			}

			if(val>=2){
				piles.set(i,val-2);
				int result=whoWins(piles);
				piles.set(i,val);
				if(result==2) return 1;
			}
		}
		return 2;

	}



	public static void main(String[] args) {
		int[] arr1= {1,2,2,1};
		ArrayList<Integer> test1= new ArrayList<Integer>();
		for(int i: arr1){
			test1.add(i);
		}

		System.out.println("winner is "+ whoWins(test1));
		String s1 = "1234";
		String s2 = "ABC";
		String s3 = "ABCD";
		System.out.println("\nPermutations for " + s1 + " are: \n" + permutationFinder(s1));
		System.out.println("\nPermutations for " + s2 + " are: \n" + permutationFinder(s2));
		System.out.println("\nPermutations for " + s3 + " are: \n" + permutationFinder(s3));
	}
	
}