import java.util.Vector;


public class PalidromePartition {
	public  Vector<Vector<String>> partition(String s) {
		Vector<Vector<String>> result= new Vector<Vector<String>>() ;
		Vector<String> solution=new Vector<String>();
		partition(s, 0, solution, result);
		return result;
	}

	void partition( String s, int index, Vector<String> solution,
			Vector<Vector<String>> result){
		if(index >= s.length()){
			result.add(solution);
			return;
		}
		for(int i = index; i < s.length(); ++i){
			if(!valid(s, index, i)) continue;
			solution.add(s.substring(index, i-index+1));
			partition(s, i+1, solution, result);
		//	solution.removeLast();
		}
	}

	boolean valid( String str, int s, int e){
		while(s<e){
			if(str.charAt(s) != str.charAt(e)) return false;
			else{
				++s;--e;
			}
		}
		return true;
	}
};

