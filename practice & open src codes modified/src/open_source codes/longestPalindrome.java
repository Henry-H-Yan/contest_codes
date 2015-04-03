package interviewQ;

public class longestPalindrome {
	/**
	 * Dynamic Programming
	 *  2-D array table[i][j]: 1 if substring(i, j) is palidromic
	 * @param s
	 * @return
	 */


	public static String longestPali(String s){
		if(s==null) return null;
		if(s.length()<=1) return s;

		int maxLen=0;
		String longestStr="";
		int len=s.length();
		int [][] table=new int[len][len];

		for(int i=0;i<len;i++) {
			table[i][i]=1;
		}
		System.out.println("check 1")	;
		printTable(table);

		for(int i =0;i<len-1;i++){
			if(s.charAt(i)==s.charAt(i+1)){
				table[i][i+1]=1;
				longestStr=s.substring(i,i+2); 
			}
		}

		System.out.println("check 2")	;
		printTable(table);
		
		
		
		

	}



	public static void printTable(int[][] table){
		for(int[] arr: table){
			for(int i:arr){
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}


	public static boolean isPali(String s){
		if(s.length()==1 ||s.length()==0)
			return true;
		if(! equalFrontEnd(s)){
			return false;
		}
		return isPali(s.substring(1,s.length()-1 ));
	}

	public static boolean equalFrontEnd(String s){
		return s.charAt(0)==s.charAt(s.length()-1);
	}

	public static void main(String[] args){

         
		String s1=""; System.out.println("s1 is "+  s1+" is "+ isPali(s1));
		String s2="1"; System.out.println("s2 is "+ s2+" is "+ isPali(s2));
		String s3="!@#$%^&^%$#@!"; System.out.println("s3 is "+ s3+" is "+ isPali(s3));

	}
}
