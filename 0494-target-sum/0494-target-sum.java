class Solution {
    static int sumAbs;
    public int findTargetSumWays(int[] nums, int target) {
        sumAbs=0;
        for(int ele:nums) sumAbs+=Math.abs(ele);
        int[][] dp=new int[nums.length][2*sumAbs+1];
         for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(0,0,target,nums,dp);
    }
    int helper(int i, int sum,int target, int[]nums, int[][] dp){
        if(i==nums.length){
            if(sum==target) return 1;
            else return 0;
        }
        int index = sum + sumAbs;
        if (dp[i][index] != -1) return dp[i][index];

        int add = helper(i + 1,sum + nums[i],target,nums,dp);

        int subtract = helper(i + 1,sum - nums[i],target,nums,dp);

        return dp[i][index] = add + subtract;
    }
}