
/**
 * The famous longest common substring problem
 * 
 * sovlved with:
 * 
 * 1. Recursion
 * 
 * 2. Dynamic programming, much better & efficient
 * 
 * @author henry-yan
 *
 */
public class LCS {

	public static String lcs_recurse(String a, String b){
		int aLen = a.length();      int bLen = b.length();
		if(aLen == 0 || bLen == 0){
			return "";
		}else if(a.charAt(aLen-1) == b.charAt(bLen-1)){
			return lcs_recurse(a.substring(0,aLen-1),b.substring(0,bLen-1))
					+ a.charAt(aLen-1);
		}else{
			// remove either's last character
			String result1 = lcs_recurse(a, b.substring(0,bLen-1));
			String result2 = lcs_recurse(a.substring(0,aLen-1), b);
			return (result1 .length() > result2.length()) ? result1 : result2;
		}
	}

	public static String lcs(String a, String b) {
		// dp table, augmented by 1
		int[][] dp = new int[a.length()+1][b.length()+1];

		// row 0 and column 0  initialized to 0 already

		for (int i = 0; i < a.length(); i++)
			for (int j = 0; j < b.length(); j++)
				if (a.charAt(i) == b.charAt(j)){
					dp[i+1][j+1] = dp[i][j] + 1;
				}
				else{
					dp[i+1][j+1] =
							Math.max(dp[i+1][j], dp[i][j+1]);
				}


		// print dp table

		for(int r=0;r< dp.length; r++){
			for(int c=0;r< dp[0].length; c++){
				System.out.print( dp[r][c]+"  ");
			}
			System.out.println();
		}
		// recover string
		StringBuffer sb = new StringBuffer();

		// starting  from the right down corner
		for (int x = a.length(), y = b.length();
				x != 0 && y != 0; ) {
			if (dp[x][y] == dp[x-1][y])
				x--;
			else if (dp[x][y] == dp[x][y-1])
				y--;
			else {
				sb.append(a.charAt(x-1));
				x--;y--;
			}
		}

		return ( sb.reverse() ).toString();
	}
}
