import java.util.*;
import java.io.Console;
import java.lang.*;

class main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		//Scanner in = new Scanner(System.in);
		Console in=System.console();

		int n=int.parseInt( in.readLine() );
		float start, low, high;
		float high_outcome, low_outcome;
		for(int i=0;i<n;i++){
		//	String line = in.nextLine();
			String line = in.readLine();
			String[] s=line.split(" ");

			start=	Float.parseFloat(s[0]);
			low=	Float.parseFloat(s[1]);
			high=	Float.parseFloat(s[2]);

			high_outcome= (float) (1.5* start);
			low_outcome=  (float) ( (2/3)  * start);


			if(high_outcome>high || low_outcome<low ){
				System.out.println("Player ruin");
			}
			if(high_outcome<high && low_outcome>low){
				System.out.println("Player fortune");
			}	
			else{
				System.out.println("A fair game");

			}

		}

	}


}