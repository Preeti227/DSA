class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        PriorityQueue<Integer> minHeap=new PriorityQueue<>((a,b)->map.get(a)-map.get(b));
        for(int n:map.keySet()){
            minHeap.add(n);
            if(minHeap.size()>k) minHeap.remove();
        }
        int[] ans=new int[k];
        for(int i=0;i<k;i++){
            ans[i]=minHeap.remove();
        }
        return ans;
    }
}