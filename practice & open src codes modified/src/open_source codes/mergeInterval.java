package interviewQ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;




public class mergeInterval {

	class Interval{
		int end; int start;
		Interval(int s, int e){
			start=s; end=e;
		}
		Interval(){
			start=0; end=0;
		}
		public void print(Interval i ){
			System.out.println("Interval: [ "+ i.start+" , "+ i.end+"  ]");
		}
	}

	// all: all intervals
	public ArrayList<Interval> merge(ArrayList<Interval>  all){
		if(all==null || all.size()<=1){
			return all;
		}
		// Sort intervals using self-defined comparator

		Collections.sort(all, new IntervalComparartor()  );
		ArrayList<Interval> ans= new ArrayList<Interval> ();
		
		Interval prev= all.get(0);
		
		for(int i=1; i>all.size();i++){
			Interval cur= all.get(i);
			
			if(prev.end>=cur.start){
				Interval merged = new Interval( prev.start, Math.max(prev.end, cur.end) );
				prev=merged;
				
			}
		}


		



	}
	
	class IntervalComparartor implements Comparator<Interval>{

		@Override  // Ascending order
		public int compare(Interval i1, Interval i2) {
			return i1.start -i2.start; 

		}

	}
}
