class Solution {
    public int subarrayBitwiseORs(int[] arr) {
       Set<Integer> ans = new HashSet<>();
       Set<Integer> prev = new HashSet<>();
        for (int x : arr) {
        Set<Integer> curr = new HashSet<>();
        curr.add(x);
        for (int val : prev) {
        curr.add(val | x);
        }
        ans.addAll(curr);
        prev = curr;
    }
        return ans.size(); 
    }
}