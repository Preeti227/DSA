class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1,high=0;
        int ans=-1;
        for(int n:nums){
            high=Math.max(n,high);
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(requiredDivisor(nums,mid)<=threshold) {
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
    long requiredDivisor(int[] nums,int div){
        long t=0;
        for(int n:nums){
            if(n%div==0) t=t+n/div;
            else{
               t=t+(n/div)+1; 
            }
        }
        return t;
    }
}