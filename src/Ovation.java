

import java.util.Scanner;

public class Ovation {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());


		int needed;    
		int total;
		for (int i = 0; i<=n; i++) {
			needed=0; total=0;
			String	cur= in.nextLine();


			for (int pos=0;pos<cur.length();pos++){

				if(pos>= total){needed+= (pos-total);}
				//System.out.println(" total "+ total+ " needed "+ needed+" pos "+ pos);
				total+=Character.getNumericValue( cur.charAt(pos))+(pos-total);

			} 
			System.out.println("Case#"+(i+1)+":"+ needed);

		}

	}

}
