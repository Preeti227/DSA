class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {

        int n = nums.length;

        Arrays.sort(nums);

        int[] dp = new int[n];
        int[] parent = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);

        int maxLength = 1;
        int startIndex = n - 1;

        // LDS-style: right to left
        for (int i = n - 1; i >= 0; i--) {

            for (int j = i + 1; j < n; j++) {

                if (nums[j] % nums[i] == 0) {

                    if (dp[j] + 1 > dp[i]) {

                        dp[i] = dp[j] + 1;
                        parent[i] = j;
                    }
                }
            }

            if (dp[i] > maxLength) {
                maxLength = dp[i];
                startIndex = i;
            }
        }
        List<Integer> result = new ArrayList<>();

        while (startIndex != -1) {

            result.add(nums[startIndex]);

            startIndex = parent[startIndex];
        }

        return result;
    }
}