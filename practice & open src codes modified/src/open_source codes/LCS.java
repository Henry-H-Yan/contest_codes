package interviewQ;



/*************************************************************************
 *  Compilation:  javac LCS
 *  Execution:    java LCS < example10.txt
 *  Dependencies: StdIn.java
 *  
 *  Reads in two strings from stdin and computes their longest
 *  common subsequence.
 *
 *************************************************************************/

public class LCS {

	public static void main(String[] args) {
		String x = "21";
		String y = "21";
	
		myDynamicLCS(x,y);
	}

	public static void myDynamicLCS(String x, String y){
		int max=0;
		int cur=0;
		if(x==null ||y==null||x.length()==0||y.length()==0){
			throw new NullPointerException("must have two valid strings!");
		}

		int row = x.length();
		int col = y.length();

		// opt[i][j] = length of LCS of x[i..M] and y[j..N]
		
		//increase dimension!!
		int[][] opt = new int[row+1][col+1]; 
		for(int[] arr:opt){
			java.util.Arrays.fill(arr, 0);
		}
		
		

		// compute length of LCS and all subproblems via dynamic programming
		for (int r = 0; r < row; r++) {
			for (int c = 0; c<col; c++) {
				if (x.charAt(r) == y.charAt(c))
					cur = opt[r][c]+1;
				System.out.println("cur is "+cur);
					opt[r+1][c+1] = cur;
		            max=Math.max(cur,max);
				//else 
				//	opt[r][c] = Math.max(opt[i+1][j], opt[i][j+1]);
			}
		}
		System.out.println("Longest length is "+ max );
        print(opt);
	
	}
	public static void print(int[][] opt){
		for(int r=0;r<opt.length;r++){
			for(int c=0;c<opt[0].length;c++){
			     String cur= ""+opt[r][c];
			      int len=cur.length();
				System.out.print(cur);
				for(int i=0;i<4-len;i++)
					System.out.print(" ");
			}

			System.out.println();
		}
	}

}
