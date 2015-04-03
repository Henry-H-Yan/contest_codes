package interviewQ;

import java.util.Arrays;

public class MergeSort {



	public static void sort(int[] array){
		// recursive method
		if(array.length<=1){
			return;  
		}

		int[] fronthalf= Arrays.copyOfRange(array , 0, array.length/2);
		int[] backhalf= Arrays.copyOfRange(array , array.length/2, array.length);

		sort(fronthalf); 

		sort(backhalf);

		merge2(array,fronthalf,backhalf);

	}



	private static void merge2(int[] array, int[] a1, int[] a2){
		int it1 =0,               it2=0;   
		int len1= a1.length,    len2= a2.length;
		for( int i=0; i<array.length;i++){
			if(  (len2==it2) ||(   (len1> it1) && (a1[it1]< a2[it2]))     ){  //
				array[i]=a1[it1];
				it1++;
			}else{
				array[i]=a2[it2];
				it2++;
			}

		}
	}


	private static void merge(int[] array, int[] a1, int[] a2){

		int len1=a1.length; int len2=a2.length;
		int it1=0; int it2=0; 
		//iterator

		for( int i=0; i<array.length;i++){
			if(  (len2==it2) ||(   (len1> it1) && (a1[it1]< a2[it2]))     ){  //
				array[i]=a1[it1];
				it1++;
			}else{
				array[i]=a2[it2];
				it2++;
			}

		}
	}


	public static void main(String[] args){





		int[] array1= {3,2,555,3,31,65,7};
		sort(array1);
		for (int i:array1){
			System.out.print(i+ " ");
		}
	}
}
