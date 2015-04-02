public class AllWordLadders {
	//	public static void main(String[] args){
	//	 WordLadder w = new WordLadder();
	//	 String[] words = {"abc", "bpc"};
	//	 String from = "apc";
	//	 String to = "bpd";
	//	 System.out.println(w.ladderExists(words, from, to));
	//	}
	//
	//	public String toString(String[] arr){
	//	 String r = "";
	//	 for (String s: arr){
	//	 r += s;
	//	 }
	//	 return r;
	//	}
	public String ladderExists(String[] words, String from, String to) {
		System.out.println();
		for (int i= 0; i< words.length; i++){
			//	 System.out.println("Words[] = " + toString(words) + "// from = " + from + "//  to =" +to);
			if(words[i].equals("   ")) continue;
			if ((isLadder(words[i],from)) && !(isLadder(words[i], to))){
				from = new String(words[i]);
				words[i] = "   ";
				return ladderExists(words, from, to);
			}
			else if (isLadder(words[i], to)){
				//System.out.println("Reached. 2");
				return "ladder";
			}
		}
		return "none";
	}


	public boolean isLadder (String s1, String s2){
		int count = 0;
		for (int i = 0; i< s1.length(); i++){
			if (s1.charAt(i) != s2.charAt(i)){
				count++;
			}
		}
		if (count == 1){
			return true;
		}
		return false;
	}
}



//import java.util.Arrays;
//
//public class WordLadder {
//	public String ladderExists(String[] words, String from, String to) {
//
//		if(isLadder(from,to)) {
//			return "ladder";
//		}
//		else if(words.length==1){
//			String pick=words[0];
//			if(isLadder(from,pick) && isLadder(pick,to)){
//				return "ladder";}
//			else return "none";
//		} 
//		else{ 
//			String pick=words[0];
//			if(isLadder(from, pick)){
//				return ladderExists( Arrays.copyOfRange(words,1,words.length-1),  pick,to);
//			}
//			else
//				return ladderExists( Arrays.copyOfRange(words,1,words.length-1), from,to);
//		}
//
//	}
//
//
//	public boolean isLadder(String s1, String s2){
//		String a , b=null;  int n=0;
//		for(int i=0;i<s1.length();i++){
//			a=s1.substring(i,i+1); b=s2.substring(i,i+1);
//
//			if(!a.equals(b)){
//				n++;}
//			continue;
//		}
//		if(n==1) {return true;}
//		return false;
//	}
//	public static void main(String[] args){
//		WordLadder q= new WordLadder();
//		String[] list={"bo","bc"}; String a ="ab";  String b="bc";
//		boolean ans= q.isLadder(a, b); 
//		System.out.println(a +" and "+ b +" is "+ ans);
//		q.ladderExists(list,a,b);
//
//	}
//
//}