class Solution {
    public String reverseWords(String s) {
        String[] words=s.split("\\s+");
        StringBuilder t=new StringBuilder();
        for(int i=words.length-1;i>=0;i--){
            if(words[i].length()==0) continue;
            if(t.length()>0) t.append(" ");
            t.append(words[i]);
        }
        return t.toString();
    }
}