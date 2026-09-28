class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // i -> day
        // buy -> 0 or 1
        // cap -> 0, 1, 2 transactions remaining
        int[][][] dp = new int[n][2][3];

        for (int i = 0; i < n; i++) {
            for (int buy = 0; buy < 2; buy++) {
                Arrays.fill(dp[i][buy], -1);
            }
        }
        return helper(0, 1, 2, prices, dp);
    }

    private int helper(int i, int buy, int cap,
                       int[] prices, int[][][] dp) {

        if (i == prices.length || cap == 0) {
            return 0;
        }
        if (dp[i][buy][cap] != -1) {
            return dp[i][buy][cap];
        }

        int profit;

        if (buy == 1) {
            int buyStock = -prices[i] + helper(i + 1, 0, cap, prices, dp);

            int skip =
                helper(i + 1, 1, cap, prices, dp);

            profit = Math.max(buyStock, skip);

        } else {

            int sell =
                prices[i] + helper(i + 1, 1, cap - 1, prices, dp);
            int hold =
                helper(i + 1, 0, cap, prices, dp);

            profit = Math.max(sell, hold);
        }
        return dp[i][buy][cap] = profit;
    }
}