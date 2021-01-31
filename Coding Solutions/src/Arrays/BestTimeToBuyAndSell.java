package Arrays;

public class BestTimeToBuyAndSell {
	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] { 7,6,5,4,3,2,9}));
		System.out.println(maxProfit(new int[] { 7,1,5,3,6,4}));
		System.out.println(maxProfit(new int[] { 6,1,3,2,4,7}));
	}

	public static int maxProfit(int[] prices) {
		int maxProfit = 0;
		int buy = -1;
		
		if(prices.length == 1) {
			return 0;
		}
		
		if(prices.length == 2) {
			if(prices[1] - prices[0] > -1) {
				return prices[1] - prices[0];
			} else {
				return 0;
			}
		}
		
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1])
				maxProfit += prices[i] - prices[i - 1];
		}

		return maxProfit;
	}

}
