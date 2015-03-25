
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


/**
 * 
 * 
 * 
 * 
 *   static dynamic
 * 
 * 
 * 
 * @author hy
 *
 */
public class Solution {
	public static void main(String args[] ) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */

		Scanner in = new Scanner(System.in); 
		if(in.nextLine()==null) { System.out.println("_");}

		String s= in.nextLine();

		// fast solution: sort first?
		char [] data= s.toCharArray();
		
	    Arrays.sort(data);

	    
	    
	    
		ArrayList<String> perm= new ArrayList<String> ();
		Arrays.sort(arr);
		findPerm(s, s.length(), perm);

		ArrayList<String> final_result= new ArrayList<String> ();
		int len=s.length();
		for(String cur:perm){
			for ( int i=0;i<= len-2;i++ ){
				if(   isAlaphbetical(   cur.substring(i, i+2) )    )
					continue;
				if(i== len-2 ) final_result.add(cur);

			}

		}
		
		
	//	set ( {''. join(p) for p in permutations (string ) })
		for(String str:final_result){
			System.out.println(str);
		}

	}


	// takes in 2 gram see if it's alphabetical

	public static boolean isAlaphbetical(String a){
		return ( (int) a.charAt(0) ) <= ( (int) a.charAt(1) );

	}

	public static boolean isValid(String s){
		int i=1;  int count=0;
		while(i<s.length()){

			if( s.charAt(i)==s.charAt(i-1)) { count++;}
			if(count==2) return false;
		}

		return true;
	}

	private static void findPerm(String str, int index, ArrayList<String> perm ){
		StringBuffer strBuf = new StringBuffer(str);
		if(index <= 0)
			perm.add(str);            
		else { 
			findPerm(str, index-1, perm);
			int currPos = str.length()-index;
			for (int i = currPos+1; i < str.length(); i++) {
				swap(strBuf,currPos, i);
				findPerm(str, index-1, perm);
				swap(strBuf,i, currPos);
			}
		}
	}

	private  static void swap(StringBuffer str, int pos1, int pos2){
		char t1 = str.charAt(pos1);
		str.setCharAt(pos1, str.charAt(pos2));
		str.setCharAt(pos2, t1);
	} 
}   









