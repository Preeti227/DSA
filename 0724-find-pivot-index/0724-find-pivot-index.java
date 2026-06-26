class Solution {
    public int pivotIndex(int[] nums) {
        int left=0;
        int total=0,right=0;
        for(int n:nums){
            total+=n;
        }
        for(int i=0;i<nums.length;i++){
            right=total-left-nums[i];
            if(left==right) return i;
            left+=nums[i];
        }
        return -1;
    }
}