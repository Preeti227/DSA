class Solution {
    public long countCommas(long n) {

        long ans = 0;

        long start = 1000;
        long commaCount = 1;

        while (start <= n) {

            long end = start * 1000 - 1;

            if (end > n) {
                end = n;
            }
            long numbers = end - start + 1;
            ans += numbers * commaCount;
            start *= 1000;
            commaCount++;
        }
        return ans;
    }
}