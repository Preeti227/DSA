class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap <>();
        int prefixSum=0;
        int count=0;
        map.put(0,1);//this ensure where s-k is done 0 is recieved in the map indicating sum=k
        for(int i=0;i<nums.length;i++){
            prefixSum+=nums[i];
            int remove=prefixSum-k;
            count+=map.getOrDefault(remove,0);
            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
        }
        return count;
    }
}