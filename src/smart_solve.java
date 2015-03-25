import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/* @author Henry Hao Yan- Duke University
 *
 */
public class smart_solve {

	public static void main(String args[] ) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
		smart_solve test= new smart_solve();
		test.go();
	}


	/**
	 *  Scan through string see if requirement is met
	 *  Time complexity:  O(k)  k is the length of string
	 *  Space Complexity: constant
	 * @param s
	 * @return
	 */
	public static boolean isValid(String s){
		int i=1;  int count=0;
		while(i<s.length()){

			if( s.charAt(i)>=s.charAt(i-1)) { count++;}
			i++;
		}

		return count<=1;
	}




	/***
	 *  If there is a character appearing >= three times
	 *   or >=3 characters appearing >=2 times, it's impossible to 
	 *   get legitmate permutations =)
	 *    (pre check can be very efficient )
	 * @param s
	 * @return
	 */
	public static boolean fail(String s){
		HashMap<Character, Integer> map= new   HashMap<Character, Integer>();
		int count=0; // count the # of characters appearing more than twice
		for(int i=0;i<s.length(); i++){
			char cur=s.charAt(i);
			if(!map.containsKey(cur)){ map.put(cur, 1); }
			else if(map.get(cur)==2) { 
				System.out.println("fail test"); return true; }  // fail the test
			else {  map.put(cur, map.get(cur)+1  ) ;   }

		}
		for(char cur:map.keySet()){
			if(map.get(cur)>=2){
				if(count==2) { 
					System.out.println("fail test");
					return false;} // there are at least 3 chars appearing > 2 times
				count++;
			}

		}
		return false;  // pass the test
	}

	
	
	/**
	 *   Core part
	 */

	public void go(){

		int counter=1;   //number of results

		Scanner in = new Scanner(System.in);
		String s=in.nextLine();


		// 2-same char, such as aa, bb, zz, output directly
		if(s==null||  ( s.length()==2 && s.charAt(0)==s.charAt(1))) { System.out.println(s); return;}

		//  like: abcdeeee, e appears 4 times so the permutation can never pass the check
		if(fail(s))  {   System.out.println("_"); return;   }



		HashSet<String> results= new HashSet<String>();
		Character[] data = new Character[s.length()];
		for (int i = 0; i < data.length; i++){
			data[i] = s.charAt(i);
		}


		Arrays.sort(data, new Comparator<Character>() {
			public int compare(Character c1, Character c2) {
				int cmp = 
						Character.toLowerCase(c2.charValue())-
						Character.toLowerCase(c1.charValue())
						;
				if (cmp != 0) return cmp;
				return c2.charValue() -  c1.charValue();
			}
		});

		//		System.out.print("sorted data:  ");
		//		for(char c: data) System.out.print(c+" ");
		//		System.out.println();



		// rebuild a string
		StringBuilder sb = new StringBuilder(data.length);
		for (char c : data) sb.append(c);
		s = sb.toString();
		if(isValid(s))  {  results.add(s);  } // add the sorted if it's valid

		HashSet<Character> used1 = new HashSet<Character>(); // record used1 letters for forward run
		String temp=""; // initialize to null
		int ptr=0;
		//	StringBuilder new_sb = new StringBuilder(s.length());

		/**
		 *  FORWARD RUN, maintain two pointers, 
		 *  i points to the character to insert
		 *  ptr points to the position where distinct char is found and insert position is pinpointed
		 */

		for(int i=0; i< s.length();i++){
			char cur= s.charAt(i);
			if(!used1.contains(cur)){
				ptr=i;


				while( ptr<s.length()-1  ){
					ptr++;
					if(s.charAt(ptr) != cur ) {
						// carefully build the string
						temp=	s.substring( 0,i) + s.substring( i+1, ptr+1) + cur + s.substring(ptr+1);
						//System.out.println("temp  " +temp + " is " + isValid(temp));

						//System.out.println(results.add(temp));
						if(isValid(temp))  {  results.add(temp); }

						//	System.out.println(" Number "+counter + " is " + temp);
						counter++;
					}
				}


				used1.add(cur);
			}

		}
		/**
		 *  BACKWARD RUN, maintain two pointers, 
		 *  i points to the character to insert
		 *  ptr points to the position where distinct char is found and insert position is pinpointed
		 */


		HashSet<Character> used2 = new HashSet<Character>(); // record used1 letters
		for(int i=s.length()-1; i>0;i--){
			char cur= s.charAt(i);
			if(!used2.contains(cur)){
				ptr=i;
				while( ptr>0  ){
					ptr--;
					if(s.charAt(ptr) != cur ) {
						temp=	s.substring( 0,ptr) + cur + s.substring(ptr,i)+ s.substring(i+1);

						if(isValid(temp)){  
							results.add(temp); 
							//System.out.println(" Number "+counter + " is " + temp);
							//	System.out.println(results.add(temp));
						}
					}
					used2.add(cur);
				}
			}
		}
		counter=1;

		if(results.size()==0 ){ System.out.println("_");  return; } // no legitmate answers, return
		for(String res: results){  System.out.println("Number "+ counter+ " is "+ res); counter++; }
		return;


	}






}
