class Solution {
    public String defangIPaddr(String address) {
        StringBuilder t=new StringBuilder();
        for(int i=0;i<address.length();i++){
            char c=address.charAt(i);
            if(c=='.'){
                t.append("[.]");
            }
            else{
                t.append(c);
            }
        }
        return t.toString();
    }
}