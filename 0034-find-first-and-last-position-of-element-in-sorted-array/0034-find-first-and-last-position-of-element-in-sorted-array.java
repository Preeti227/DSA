class Solution {
    public int[] searchRange(int[] nums, int target) {

        int[] ans = {-1, -1};

        int low = 0;
        int high = nums.length - 1;

        // First occurrence
        int first = -1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] > target) high = mid - 1;
            else if(nums[mid] < target) low = mid + 1;
            else {
                first = mid;
                high = mid - 1;
            }
        }

        // Last occurrence
        //Reset low and high 
        low = 0;
        high = nums.length - 1;

        int last = -1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] > target) high = mid - 1;
            else if(nums[mid] < target) low = mid + 1;
            else {
                last = mid;
                low = mid + 1;
            }
        }

        ans[0] = first;
        ans[1] = last;

        return ans;
    }
}