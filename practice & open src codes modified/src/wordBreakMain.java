import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class wordBreakMain {
	
	public static void main(String[] args){
		
		//wrdBrkSimple test=new wrdBrkSimple();
		
		wrdBrkBetter1 test= new wrdBrkBetter1();
		
		
		String s="abcdabcdabcd"; 
		 String elements[] = { "a", "b", "c","da" };
		 Set<String> set = new HashSet<String>(Arrays.asList(elements));

		System.out.println("ans is "+test.wordBreak(s,set));
		
	}
}
