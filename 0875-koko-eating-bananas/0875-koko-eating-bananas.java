class Solution {
    public int minEatingSpeed(int[] piles, int k) {
        int low=1,high=0;
        int ans=-1;
        for(int p:piles){
            high=Math.max(p,high);//finding the high 
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(hours(piles,mid)<=k){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
    long hours(int[] piles,int speed){
        long h=0;
        for(int p:piles){
            if(p % speed==0) h=h+p/speed;
            else{
                h=h+(p/speed)+1;
            }
        }
        return h;
    }
}