class Solution {
    public int coinChange(int[] coins, int sum) {
        int[] dp = new int[sum + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // Base case
        dp[0] = 0;
        for(int amount = 1; amount <= sum; amount++) {
            for(int coin : coins) {
                if(coin <= amount && dp[amount - coin] != Integer.MAX_VALUE) {
                    dp[amount] =Math.min(dp[amount],1 + dp[amount - coin]);
                }
            }
        }
        return dp[sum] == Integer.MAX_VALUE ? -1 : dp[sum];
    }
}