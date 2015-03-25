import java.util.HashMap;
import java.util.Scanner;


public class jj { 

	public static void main(String[] args){

int a = 0x1B;
	System.out.println( a<1);
	int b=0xA;
	System.out.println(" b is "+ b);
	
		Scanner in = new Scanner(System.in);
		
		int n=in.nextInt();
		int res=0;

		HashMap<String, Integer> map1= new 	HashMap<String, Integer>();
		for(int i=0;i<n;i++){
			String cur= in.nextLine();
			if(map1.containsKey(cur) ) {
				map1.put( cur, map1.get(cur)+1);
			}else{ map1.put(cur, 1); }	  
		}




		for(int i=0;i<n;i++){
			String cur= in.nextLine(); // from next group
		
			if(map1.containsKey(cur) && map1.get(cur)>=1 ) {
				res++; map1.put(cur, map1.get(cur)-1);
				
				
			}
		}



		System.out.println(res);



	}

}
