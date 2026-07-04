class Solution {
    public int findMiddleIndex(int[] nums) {
        int total=0;
        for(int n:nums){
            total+=n;
        }
        int left=0;
        for(int i=0;i<nums.length;i++){
            int rightSide=total-left-nums[i];
            if(left==rightSide) return i;
            left+=nums[i];
        }
        return -1;
    }
}