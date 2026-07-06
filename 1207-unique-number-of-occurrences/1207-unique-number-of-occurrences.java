class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int n:arr){
            map.put(n,map.getOrDefault(n,0)+1);            
        }
       HashSet<Integer> set = new HashSet<>();

        for (int freq : map.values()) {
            if (set.contains(freq)) {
                return false;
            }
            set.add(freq);
        }

        return true;
    }
}