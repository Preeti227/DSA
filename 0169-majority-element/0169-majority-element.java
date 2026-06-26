class Solution {
    public int majorityElement(int[] nums) {
        int l=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
            if(map.get(n)>l/2){
            return n;
        }
        }        
        return -1;
    }
}