class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
           char c=s.charAt(i);
           map.put(c,map.getOrDefault(c,0)+1);
        }
        List<Character> list=new ArrayList<>(map.keySet());
        list.sort((a,b)->map.get(b)-map.get(a));
        StringBuilder t=new StringBuilder();
        for(char c:list){
            while(map.get(c)>0){
                 t.append(c);
                 map.put(c,map.get(c)-1);
            }           
        }
        return t.toString();
    }
}