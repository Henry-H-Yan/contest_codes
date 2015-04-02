package interviewQ;
public class Combinations {
	private StringBuilder output = new StringBuilder();
	private final String inputstring;
	
	//constructor?
	public Combinations( final String str ){
		inputstring = str;
		System.out.println("constructor" );	
		System.out.println(" The input string  is  : " + inputstring);
	}


	public static void main (String args[])
	{
		
	

		Combinations obj= new Combinations("1234");
		
		
		
		System.out.println("********************************");
		System.out.println("All possible combinations are :  ");
		obj.combine();
	}

	public void combine() { 
		combine( 0 ); }
	// call helper

	private void combine(int start ){
		//System.out.println("start is "+start);
		for( int i = start; i < inputstring.length(); ++i ){
			output.append( inputstring.charAt(i) );
			System.out.println( output );
			if ( i < inputstring.length() ){
				
			
				combine( i + 1); 
				
			}
			
			output.setLength( output.length() - 1 );
			System.out.println("output len: "+output.length());
		}
	}
} 