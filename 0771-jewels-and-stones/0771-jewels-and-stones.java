class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        boolean[] isJewel = new boolean[128];

        for (int i = 0; i < jewels.length(); i++) {
            char ch = jewels.charAt(i);
            isJewel[ch] = true;
        }
        int count = 0;
        for (int i = 0; i < stones.length(); i++) {
            char ch = stones.charAt(i);

            if (isJewel[ch]==true) {
                count++;
            }
        }

        return count;
    }
}