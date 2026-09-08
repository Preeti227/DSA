class Solution {
    public int countCommas(int n) {

        int ans = 0;

        // 1 comma numbers: 1,000 to 999,999
        if (n >= 1000) {
            ans += Math.min(n, 999999) - 1000 + 1;
        }

        // 2 comma numbers: 1,000,000 to 999,999,999
        if (n >= 1000000) {
            ans += (Math.min(n, 999999999) - 1000000 + 1) * 2;
        }

        // 3 comma numbers: 1,000,000,000 onwards
        if (n >= 1000000000) {
            ans += (n - 1000000000 + 1) * 3;
        }

        return ans;
    }
}