class Solution {
    public int maxProduct(int[] nums) {
        int largest=0,s_largest=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>largest){
                s_largest=largest;
                largest=nums[i];
            }
            else if(nums[i]>s_largest){
                s_largest=nums[i];
            }
        }
        return (largest-1)*(s_largest-1);
    }
}