class Solution {
    public int maxProfit(int[] prices) {
        int min=prices[0];
        int max=0;
        for(int i=1;i<prices.length;i++){ //taking i from 1 because on taking i=0 cost will always be 0
            int cost=prices[i]-min;
            min=Math.min(min,prices[i]);
            max=Math.max(max,cost);
        }
        return max;
    }
}