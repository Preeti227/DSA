class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        int negativeIndex=1,posIndex=0;
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                ans[posIndex]=nums[i];
                posIndex+=2;
            }
            else{
                ans[negativeIndex]=nums[i];
                negativeIndex+=2;
            }
        }
        return ans;
    }
}