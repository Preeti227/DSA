class Solution {
    public int totalFruit(int[] fruits) {
      int left=0;
      int maxlen=0;
      HashMap <Integer,Integer> map=new HashMap<>();
      for(int right=0;right<fruits.length;right++){
        int fruit=fruits[right];//current fruit
        int freq=map.getOrDefault(fruit,0);//freq of current fruit
        freq++;
        map.put(fruit,freq);
        while(map.size()>2){
            map.put(fruits[left],map.get(fruits[left])-1);//reducing the count of the fruit in the left side 
            if(map.get(fruits[left])==0) map.remove(fruits[left]);
            left++;
        }
        maxlen=Math.max(maxlen,right-left+1);
      }
      return maxlen;   
    }
}