package neetcode250._01_arrays_hashing;

public class _15_BestTimeToBuyAndSellStockII_122 {
    // TODO - Given a prices array we have to return the max profit that we can get by buying and selling a stock
    // We are allowed to do any number of transactions (ie buy and sell as many times as we want)
    // But we can hold only 1 stock at a time (you cannot buy again before selling)

    // constraints - 1 <= prices.length <= 30000
    // 0 <= prices[i] <= 10000
    // * So we'll be needing to solve this problem in O(nlogn) or O(n) time

    // ? Approach - Whenever the element at sell idx is greater than our element at buy idx we sell the stock, and we have the option to buy it again at its selling price

    public static int bestTime(int[] prices) {
        // track the global profit
        int profit = 0;
        // the index of the day on which we're buying the stock
        int buyIdx = 0;
        int n = prices.length;
        for (int sellIdx = 1; sellIdx < n; sellIdx++) {
            // if the selling price is higher we decide to sell
            if (prices[sellIdx] > prices[buyIdx]) {
                int sellingPrice = prices[sellIdx] - prices[buyIdx];
                // we add the selling price to our profit
                profit += sellingPrice;
            }
            // ? this covers 2 things -
            // ? 1. if the price at the sellIdx is smaller than our buyIdx price it means that its more profitable for us to buy at the sellIdx price
            // ? 2. We can sell and then buy again at the same price

            // ? ex. [7,1,5,9,10,4,3]
            // * buy at 1 sell at 5, profit = 4
            // * buy at 5 sell at 9, profit = 4
            // * buy at 9 sell at 10, profit = 1
            // * tot profit = 9
            buyIdx = sellIdx;
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(bestTime(new int[]{7,6,4,3,1}));
    }
}
