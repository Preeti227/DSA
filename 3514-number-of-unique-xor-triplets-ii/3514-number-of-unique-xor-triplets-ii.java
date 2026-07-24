class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int limit = 2048;

        boolean[] pairXor = new boolean[limit];
        boolean[] tripletXor = new boolean[limit];

        // Find all possible XOR values of two elements
        for (int first : nums) {
            for (int second : nums) {
                pairXor[first ^ second] = true;
            }
        }

        // Add the third element
        for (int value : nums) {
            for (int xor = 0; xor < limit; xor++) {
                if (pairXor[xor]) {
                    tripletXor[xor ^ value] = true;
                }
            }
        }

        int count = 0;

        for (boolean present : tripletXor) {
            if (present) {
                count++;
            }
        }

        return count;
    }
}