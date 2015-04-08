
public class buy_sell_stock {

	/**
	 * 
	 * Design an algorithm to find the maximum profit. You may 
	 * complete as many transactions as you like (ie, buy one
	 *  and sell one share of the stock multiple times). 
	 *  However, you may not engage in multiple transactions
	 *   at the same time (ie, you must sell the stock before you 
	 *   buy again).
	 *   
	 *   given:  an array prices[] wiht price of stock for each day
	 */

//  finding all ascending sequences.
	
	public int maxProfit(int[] prices) {
	    int profit = 0;
	    for(int i=1; i<prices.length; i++){
	        int diff = prices[i]-prices[i-1];
	        if(diff > 0){
	            profit += diff;
	        }
	    }
	    return profit;
	}

}
