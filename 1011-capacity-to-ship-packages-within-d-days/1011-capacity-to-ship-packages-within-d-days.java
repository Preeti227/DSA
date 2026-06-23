class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=0,high=0;
        for(int w:weights){
            low=Math.max(w,low);//finding the low (will be the max weight)
            high=high+w;//will be the sum of all the weights
        }
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(requiredDays(weights,mid)<=days){//if the days required is less than the given days then search the smaller capacity
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
    int requiredDays(int[] weights,int capacity){
        int days=1;
        int load=0;
        for(int w:weights){
            if(load+w <=capacity){
                load+=w;
            }
            else{
                days++;
                load=w;
            }
        }
        return days;
    }
}