package arrays;

import static java.lang.Math.max;

public class BestTimeToBuyAndSell {
    /*
    Example 1:
Input:
 prices = [7,1,5,3,6,4]
Output:
 5
Explanation:
 Buy on day 2 (price = 1) and
sell on day 5 (price = 6), profit = 6-1 = 5.

Note
: That buying on day 2 and selling on day 1
is not allowed because you must buy before
you sell.

Example 2:
Input:
 prices = [7,6,4,3,1]
Output:
 0
Explanation:
 In this case, no transactions are
done and the max profit = 0.
     */
    public int bestTimeToBuyAndSellStocks(int[] prices){
        int maxPro = 0;
        int minPrice = Integer.MAX_VALUE;
        
        for (int i = 0; i < prices.length; i++) {

            minPrice = Math.min(minPrice, prices[i]);

            maxPro = Math.max(maxPro, prices[i] - minPrice);
        }
        return maxPro;
    }
}
