class Solution {
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            // Take the last bit of n
            int bit = n & 1;
            // Shift answer left to make space
            ans = (ans << 1) | bit;
            // Remove the last bit from n
            n = n >> 1;
        }
        return ans;
    }
}