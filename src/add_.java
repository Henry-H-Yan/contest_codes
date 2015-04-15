
public class add_ {
	
	 int add(int x, int y)
	{
	    if (y == 0)
	        return x;
	    else
	        return add( x ^ y, (x & y) << 1);
	}
	 
	public static String to32(String s){
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<32-s.length();i++){
			sb.append("0");
		}
		return (sb.toString()+s);
	}
	public static void main(String[] args){
		// written for a cacheism assignment for computer architechture class, translate to machine bits
	int [] list={2,6, 9, 3, 20, 98, 19, 56, 8, 11,6, 43, 5,3, 9, 98};
	int [] list2={3,180,43,2,191,88,190,14,181,44,4,100,180,186,100,4,253};
	int[] list3 ={ 181, 44, 3, 192, 89, 191, 15, 182, 45, 181,186, 253,43,44,52,13,68, 101,52};
//		for(int i:list)System.out.println ( 
//				to32 (  Integer.toString(i,2) )
//				);
//		
//		for(int i:list)System.out.println ( 
//				to32 (  Integer.toString(i,2) ) .substring(0,20)
//				);
//		
//		for(int i:list)System.out.println ( 
//				to32 (  Integer.toString(i,2) ) .substring(21,31)
//				);
		for(int i:list)System.out.println ( 
				to32 (  Integer.toString(i,2) ) .substring(0,20)+"||" + 
						to32 (  Integer.toString(i,2) ) .substring(20,30)+ "|| "
				+to32 (  Integer.toString(i,2) ) .substring(30,32)
				);
		System.out.println("second part of instructions");
		for(int i:list2)System.out.println ( 
				to32 (  Integer.toString(i,2) ) .substring(0,20)+"||" + 
						to32 (  Integer.toString(i,2) ) .substring(20,30)+ "|| "
				+to32 (  Integer.toString(i,2) ) .substring(30,32)
				);
		System.out.println("3rd  part of instructions");
		for(int i:list3)System.out.println ( 
				to32 (  Integer.toString(i,2) ) .substring(0,20)+"||" + 
						to32 (  Integer.toString(i,2) ) .substring(20,30)+ "|| "
				+to32 (  Integer.toString(i,2) ) .substring(30,32)
				);
		
		
		
		add_ a = new add_();
		int size =32;
		String binaryString = String.format("%"+Integer.toString(size)+"s",Integer.toBinaryString(19)).replace(" ","0");
		String test="0000011000";
		System.out.println ( test.length());
	}

}
