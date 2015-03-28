

/**
 * Write a function that takes an int and returns the excel 
 
string representation of it
        ex. 1 = a, 2 = b, 3 = c
        26 = z, 27 = aa, 28 = ab, 29 = ac
        52 = az, 53 = ba, 54 = bb, 55 = bc
        702 = zz, 703 = aaa
       */
       
public class excel {

	public static String turn_to_base(int in, int base){
		return Integer.toString(in, 36);
	}
	
	public static String Int_To_ExcelFormat(int in){
		if(in<1){ System.out.println("Error- number must be positive");return null;}
		String s=Integer.toString(in,26); // turn to base 26 number

		StringBuilder sb=new StringBuilder(s.length());
		for(int i=0;i<s.length();i++){
			int temp= Character.getNumericValue(s.charAt(i));
	
			sb.append((char) (96+ temp) );
		}
		return sb.toString();
	}
	
	
	public static void main(String[] args){

		String result=Int_To_ExcelFormat(703);
	System.out.print(result);
				
	}
}
