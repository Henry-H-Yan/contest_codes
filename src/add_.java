
public class add_ {
	
	 int add(int x, int y)
	{
	    if (y == 0)
	        return x;
	    else
	        return add( x ^ y, (x & y) << 1);
	}
	
	static void main(String[] args){
		add_ a = new add_();
		
		System.out.println("asdfadf");
		
	}

}
