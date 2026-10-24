package neetcode250._03_sliding_window;

public class _0121_BestTimeToBuyAndSellStock {
    // Given a prices array we have to buy a stock at x position (buy) and y position (sell)
    // Note that y needs to be after x

    // ? Approach 1 - Let's try to find the min element as well as its position because we'll use the position to find the max element after said position

    // this is an O(n2) approach
    public static int bestTime(int[] arr) {
        int profit = 0;
        int n = arr.length;
        for (int buy = 0; buy < n; buy++) {
            for (int sell = buy + 1; sell < n; sell++) {
                int sellingPrice = arr[sell] - arr[buy];
                if (sellingPrice > profit) {
                    profit = sellingPrice;
                }
            }
        }
        return profit;
    }

    public static int bestTimeOpt(int[] prices) {
        int n = prices.length;
        // Buying a stock on the first day
        int buyDay = 0;
        // keep track of the possible profit, we need to return 0 if we can't make a profit
        int profit = 0;
        // We start selling on the second day
        for (int sellDay = 1; sellDay < n; sellDay++) {
            // ? if on a sellDay I encounter a stock price which is lesser than my current buyDay price then I choose to buy the stock on the sellDay, updating the buyDay with the sellDay
            if (prices[buyDay] > prices[sellDay]) {
                buyDay = sellDay;
            } else {
                // ? if i encounter a higher stock price on a sellday than my buyday, it means that I can sell my stock and make a profit
                // ? So i sell the stock, record the profit
                int currSellPrice = prices[sellDay] - prices[buyDay];
                // ? If i made more profit with this trade than my old one then I update my profit with the current trade profit
                profit = Math.max(profit, currSellPrice);
            }
        }
        // ? return the profit
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(bestTimeOpt(new int[]{4, 5, 2, 5, 2, 1, 9}));
    }
}
