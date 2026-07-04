class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int prefixSum=0,count=0;
        map.put(0,1);
        for(int n:nums){
         prefixSum+=n;
         int remove=prefixSum-k;
         count+=map.getOrDefault(remove,0);
         map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);   
        }
        return count;
    }
}