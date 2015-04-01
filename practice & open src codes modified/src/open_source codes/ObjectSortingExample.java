package interviewQ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * Java program to test Object sorting in Java. This Java program
 * test Comparable and Comparator implementation provided by Order
 * class by sorting list of Order object in ascending and descending order.
 * Both in natural order using Comparable and custom Order using Comparator in Java
 *
 * @author http://java67.blogspot.com
 */
public class ObjectSortingExample {

	public static void main(String args[]) {

		//Creating Order object to demonstrate Sorting of Object in Java
		Order ord1 = new Order(101,99000, "A");
		Order ord2 = new Order(102,4000, "B");
		Order ord3 = new Order(103,6000, "C");
		Order ord4 = new Order(105,7000, "D");
		Order ord5 = new Order(110,33000, "E");

		//putting Objects into Collection to sort


		List<Order> orders = new ArrayList<Order>();
		orders.add(ord5);orders.add(ord4);
		orders.add(ord2);		orders.add(ord3);
		orders.add(ord1);
		printResult(orders);

	}
	
	public static void printResult(List<Order> orders){
		System.out.println("Unsorted Collection : " + orders);

		
	/*	
		//Sorting Order Object on natural order - ascending
		Collections.sort(orders);


		System.out.println("List of Order object sorted in natural order : \n" + orders);

		// Sorting object in descending order in Java
		Collections.sort(orders, Collections.reverseOrder());
		System.out.println("List of object sorted in descending order : \n" + orders);

*/

		//Sorting object using Comparator in Java
		Collections.sort(orders, new Order.OrderByAmount());
		System.out.println("List of Order object sorted using Comparator - amount : \n" + orders);

		// Comparator sorting Example - Sorting based on customer
		Collections.sort(orders, new Order.OrderByCustomer());
		System.out.println("Collection of Orders sorted using Comparator - by customer :\n" + orders);
	}
	
	
}




/*
 * Order class is a domain object which implements
 * Comparable interface to provide sorting on natural order.
 * Order also provides copule of custom Comparators to
 * sort object based upon amount and customer
 */
class Order implements Comparable<Order> {

	private int orderId;
	private int amount;
	private String customer;

	/*
	 * Comparator implementation to Sort Order object based on Amount
	 */
	public static class OrderByAmount implements Comparator<Order> {

		@Override
		public int compare(Order o1, Order o2) {
			//return o1.amount > o2.amount ? 1 : (o1.amount < o2.amount ? -1 : 0);
		return o2.getAmount()-o1.getAmount();// from big to small
		}
	}

	/*
	 * Anohter implementation or Comparator interface to sort list of Order object
	 * based upon customer name.
	 */
	public static class OrderByCustomer implements Comparator<Order> {

		@Override
		public int compare(Order o1, Order o2) {
			// descending
			//return o2.customer.compareTo(o1.customer);
			
			//ascending:
			return o1.customer.compareTo(o2.customer);
		}
	}

	public Order(int orderId, int amount, String customer) {
		this.orderId = orderId;
		this.amount = amount;
		this.customer = customer;
	}


	public int getAmount() {return amount; }
	public void setAmount(int amount) {this.amount = amount;}

	public String getCustomer() {return customer;}
	public void setCustomer(String customer) {this.customer = customer;}

	public int getOrderId() {return orderId;}
	public void setOrderId(int orderId) {this.orderId = orderId;}

	/*
	 * Sorting on orderId is natural sorting for Order.
	 */
	@Override
	public int compareTo(Order o) {
		return this.orderId > o.orderId ? 1 : (this.orderId < o.orderId ? -1 : 0);
	}

	/*
	 * implementing toString method to print orderId of Order
	 */
	@Override
	public String toString(){
		return String.valueOf(orderId);
	}


	
}