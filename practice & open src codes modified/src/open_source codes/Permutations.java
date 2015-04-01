package interviewQ;

public class Permutations {

	/**
	 *  print N! permutation 
	 *  *** in ascending Order!!!!
	 */
	
	public  static void perm1(String s) { perm1("", s); }
	private static void perm1(String prefix, String s) {
		System.out.println("prefix : "+ prefix);
		int N = s.length();
		if (N == 0) System.out.println(prefix);
		else {
			for (int i = 0; i < N; i++)
				//*****************************************************************
				
				perm1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, N));
		}

	}
  
	public static void main(String[] args){
		String s= "1234";
		perm1(s);
	}
}
