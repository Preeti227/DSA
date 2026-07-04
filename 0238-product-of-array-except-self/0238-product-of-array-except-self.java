class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        // Step 1: store left product in ans
        int left = 1;
        for (int i = 0; i < n; i++) {
            ans[i] = left;
            left = left * nums[i];
        }

        // Step 2: multiply right product
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = ans[i] * right;
            right = right * nums[i];
        }

        return ans;
    }
}