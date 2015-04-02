package interviewQ;

public class bitClass {

	
	
	
	public static boolean getBit(int num, int i){
		int result=num &(1<< i);
		
		if(result==0)
			return false;
		return true;
	}
	/**
	 * return the number of bits needed to be changed to  turn x to y in bit 
	 * @param x
	 * @param y
	 * @return
	 */
	public static int findNum(int x, int y){
		int count=0;
		int z=x ^y;
		
		
		///   check how many ones in z
		while(z!=0){
			count+= z & 1;
			z= z>>1;
		}
		return count;
	}
	/**  IMPORTANT
	 * 
	 * divide funciton wihtout using divide operator  LOG(N)
	 * 
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static int divide(int a, int b)
    {
        if(a < b)
            return 0;
        int div = b;
        int k = 1;
        while((div<<1) <= a)
        {
            div = div<<1;
            k = k<<1;
        }
        return k + (div == a ? 0 : divide(a-div,b));
    }
	
	
	public static void main(String [] a){
		
		System.out.println( divide( 100,10)                );
		System.out.println(  1001<< 4
                );
		System.out.println(  8 >> 1
				                    );
		
		System.out.println(    getBit(10,1)     );
	}
}
