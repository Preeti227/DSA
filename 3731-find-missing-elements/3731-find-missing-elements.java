class Solution {
    public List<Integer> findMissingElements(int[] arr) {
        ArrayList<Integer> ans=new ArrayList<>();
        HashSet<Integer> set=new HashSet<>();
        int low=arr[0];
        int high=arr[0];
        for(int n:arr) {
            set.add(n);
            low=Math.min(low,n);
            high=Math.max(high,n);
        }
        for(int i=low;i<=high;i++){
            if(!set.contains(i)) ans.add(i);
        }
        return ans;
    }
}