public class longestCommonStringDP {

	public static void main(String[] args) {
		String str="xxx3 3";
		String s2= "ECHOSIGN xxxxxxxx6744 CA xx8.80 USD @ xx0878";
		str = str.replaceAll("\\w*^xxx+\\w*", "");
		//str = str.replaceAll("\w*xxx+\w*", "")
		System.out.println(str);
		
		System.out.println(s2);
		//s2= s2.replaceAll("\\w^*xx+\\w*", "");
		s2= s2.replaceAll("\\w^*xx+.*", "");
		System.out.println(s2);
		s2= s2.replaceAll("\\d","");
	
		System.out.println(s2);
		
		
		String x = "1122334455";
		String y ="12345";
		int M = x.length();
		int N = y.length();

		int[][] opt = new int[M+1][N+1];

		// compute length of LCS and all subproblems via dynamic programming
		for (int i = M-1; i >= 0; i--) {
			for (int j = N-1; j >= 0; j--) {
				if (x.charAt(i) == y.charAt(j))
					opt[i][j] = opt[i+1][j+1] + 1;
				else 
					opt[i][j] = Math.max(opt[i+1][j], opt[i][j+1]);
			}
		}
		System.out.println("LCS length is "+ opt[0][0]);

		// recover LCS itself and print it to standard output
		int i = 0, j = 0;
		while(i < M && j < N) {
			if (x.charAt(i) == y.charAt(j)) {
				System.out.print(x.charAt(i));
				i++;
				j++;
			}
			else if (opt[i+1][j] >= opt[i][j+1]) i++;
			else                                 j++;
		}
		System.out.println();

	}

}
