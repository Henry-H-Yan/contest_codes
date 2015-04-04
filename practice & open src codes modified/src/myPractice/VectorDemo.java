package myPractice;
//java.util.Vector and java.util.Enumeration;

import java.util.*;
public class VectorDemo{
	
	private static final int sizeOfIntInHalfBytes = 8;
	  private static final int numberOfBitsInAHalfByte = 4;
	  private static final int halfByte = 0x0F; //15
	  private static final char[] hexDigits = { 
	    '0', '1', '2', '3', '4', '5', '6', '7', 
	    '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
	  };

	  public static String decToHex(int dec) {
	    StringBuilder hexBuilder = new StringBuilder(sizeOfIntInHalfBytes);
	    hexBuilder.setLength(sizeOfIntInHalfBytes);
	    for (int i = sizeOfIntInHalfBytes - 1; i >= 0; --i)
	    {
	      int j = dec & halfByte;
	      hexBuilder.setCharAt(i, hexDigits[j]);
	      dec >>= numberOfBitsInAHalfByte;
	    }
	    return hexBuilder.toString(); 
	  }

	
	    
	
	
	public static void main(String[] args){
		 System.out.println(halfByte);
		 int dec = 305445566;
	     String hex = decToHex(dec);
	     System.out.println(hex);       
	  
//	
//		Vector<Object> vector = new Vector<Object>();
//		int primitiveType = 10;
//		
//		/// must be turned to wrapper (object) to fit Vector<Object>
//		Integer wrapperType = new Integer(20);
//		String str = "tapan joshi";
//		vector.add(primitiveType);
//		vector.add(wrapperType);
//		vector.add(str);
//		
//		vector.add(2, new Integer(30)); // push string to next
//		System.out.println("the elements of vector: " + vector);
//		System.out.println("The size of vector are: " + vector.size());
//		System.out.println("The elements at position 2 is: " 
//				+ vector.elementAt(2));
//		System.out.println("The first element of vector is: " 
//				+ vector.firstElement());
//		System.out.println("The last element of vector is: " 
//				+ vector.lastElement());
//		vector.removeElementAt(2);
//		Enumeration e=vector.elements();
//		// does enumeration follow order?
//		
//		System.out.println("The elements of vector: " + vector);
//		while(e.hasMoreElements()){
//			System.out.println("The elements are: " + e.nextElement());
		}  
	}


