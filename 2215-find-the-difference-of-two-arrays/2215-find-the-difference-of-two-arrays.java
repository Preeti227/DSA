class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> n1=new HashSet<>();
        HashSet<Integer> n2=new HashSet<>();
        for(int i:nums1){
            n1.add(i);
        }
        for(int i:nums2){
            n2.add(i);
        }
        List<Integer> inNums1=new ArrayList<>();
        List<Integer> inNums2=new ArrayList<>();
        for(int i:n1){
            if(!n2.contains(i)) inNums1.add(i);
        }
        for(int i:n2){
            if(!n1.contains(i)) inNums2.add(i);
        }
        List<List<Integer>> ans=new ArrayList<>();
        ans.add(inNums1);
        ans.add(inNums2);
        return ans;
    }
}