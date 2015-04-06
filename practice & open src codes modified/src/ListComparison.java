
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class ListComparison {

	public enum ListType{
		LINKED, ARRAY;
	}

	public List<Integer> makeList(int numElements, ListType type){

		List<Integer> list;

		//  create a kind of list
		switch(type){
			case LINKED:
				list = new LinkedList<Integer>();
				break;
			case ARRAY:
				list = new ArrayList<Integer>();
				break;
			default:
				list = new ArrayList<Integer>();
		}

		for(int i = 0; i < numElements; i++){
			list.add(i);
		}

		return list;

	}
	
	public void removeElements(List<Integer> list){
		for(int i = 0; i < list.size(); i++){
			list.remove(list.size()/2);
		}
	}

	public static void main(String[] args){
		ListComparison compare = new ListComparison();
		int size = 400000;
		System.out.println("Add " + size + "elements to a list");
		System.out.println("Compare ArrayList vs. LinkedList with " + size + " elements.");
		double start = System.currentTimeMillis();
		List<Integer> linked = compare.makeList(size, ListType.LINKED);
		double end = System.currentTimeMillis();
		System.out.printf("LinkedList (add)    : total time = %f\n", (end - start) / 1000);
		
		start = System.currentTimeMillis();
		List<Integer> array = compare.makeList(size, ListType.ARRAY);
		end = System.currentTimeMillis();
		System.out.printf("ArrayList (add)     : total time = %f\n", (end - start) / 1000);
		
		start = System.currentTimeMillis();
		compare.removeElements(linked);
		end = System.currentTimeMillis();
		System.out.printf("LinkedList (remove) : total time = %f\n", (end - start) / 1000);

		start = System.currentTimeMillis();
		compare.removeElements(array);
		end = System.currentTimeMillis();
		System.out.printf("ArrayList (remove)  : total time = %f\n", (end - start) / 1000);

	}
}