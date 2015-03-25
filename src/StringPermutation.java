import java.util.HashSet;
import java.util.Set;
 
public class StringPermutation {
 
    Set<String> result = new HashSet<String>();
 
    public String[] permutation(String str) {
        String[] strings = {};
        permutation("", str);
        return result.toArray(strings);
    }
 
    private void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) {
            for (int i = 1; i < prefix.length(); i++) {
                String substring = prefix.substring(i - 1, i + 1);
                char[] chars = substring.toCharArray();
                if ((chars[0] + 1) == chars[1] || chars[0] == chars[1] || (chars[0] - 1) == chars[1] ) {
                    if (prefix.indexOf(substring) != prefix.lastIndexOf(substring)) {
                        return;
                    }
                }
            }
            result.add(prefix);
        } else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }
 
   static int factorial(){
	   
	   
	   
	   
   }
    	
    static int add(int x, int y)
    {
        if (y == 0)
            return x;
        else
            return add( x ^ y, (x & y) << 1);
    }
    
    public static void main(String args[]) {
        String[] strings = new StringPermutation().permutation(args.length > 0 ? args[0] : "aaabbbc");

        System.out.println( add ( 3, 4));
        //        if (strings.length == 0) {
//            System.out.println("_");
//        }
//        for (String string: strings) {
//            System.out.println(string);
//        }
    }
}