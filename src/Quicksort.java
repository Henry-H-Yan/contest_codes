
public class Quicksort {
	
	
	static int partition(int arr[], int left, int right)
	{
	      int i = left;
	      int j = right;
	      int tmp;
	      int pivot = arr[(left + right) / 2];
	     
	      while(i<=j){
	    	  while(arr[i]<pivot) i++;
	    	  while(arr[j]>pivot) j--;
	    	  if(i<=j){  
	    		  swap(arr,i , j);
	    		   i++;
	    		   j--;
	    	  }
	      }

	     
	      return i;
	}
	
	static void swap(int[] arr, int i, int j){
		int temp= arr[j];
		arr[j]=arr[i];
		arr[i]=temp;
	}
	 
	static void quickSort(int arr[]){
		quickSortHelper(arr,0,arr.length-1);
	}
	
	static void printArr(int arr[]){
		for(int i:arr)
			System.out.print(i+" ");
		System.out.println();
		System.out.println("______________");
	}
	
	static void quickSortHelper(int arr[], int left, int right) {
	      int index = partition(arr, left, right);
	      if (left < index - 1)
	            quickSortHelper(arr, left, index - 1);
	      if (index < right)
	            quickSortHelper(arr, index, right);
	}
	
	public static void main(String args[]) {
		int[] test1={3,2,55,1,-2,3,5,3,66,102};
		quickSort(test1);
		printArr(test1);
		
		
		
	}

}
