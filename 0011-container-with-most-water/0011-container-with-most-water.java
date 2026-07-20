class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;

        while (left < right) {
            int width = right - left;
            int containerHeight = Math.min(height[left], height[right]);

            int currentArea = width * containerHeight;
            maxWater = Math.max(maxWater, currentArea);

            // Move the shorter line because it limits the water level
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}