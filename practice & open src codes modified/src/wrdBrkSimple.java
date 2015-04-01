import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class wrdBrkSimple {
	// bad method
	public  boolean wordBreak(String s, Set<String> dict){
		return helper(s,dict,0);
	}

	public  boolean helper(String s, Set<String> dict, int start){  
		if(start==s.length()) return true;

		for(String a:dict){
			int len=a.length();
			int end=start+len;

			if(end>s.length())
				continue;   // to next word in dict
			if(s.substring(start,end).equals(a)){
				return helper(s,dict,end);
			}
		}
		return false;
	}

	public static void main(String[] args){
		wrdBrkSimple test=new wrdBrkSimple();
		String s="abcd"; 
		 String elements[] = { "a", "b", "cd" };
		 Set<String> set = new HashSet<String>(Arrays.asList(elements));

		System.out.println("ans is "+test.wordBreak(s,set));
	
		
	}
}

