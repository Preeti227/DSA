class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);

            while(st.size()>0 && k>0 && st.peek()>c){//when the top is greater than ith char
                st.pop();
                k--;
            }
            st.push(c);
        }
        while(st.size()>0 && k>0){//when the top is not greater but  k is remaining
                st.pop();
                k--;
            }
            StringBuilder t=new StringBuilder();
            while(st.size()>0){
                t.append(st.pop());
            }
            t.reverse();//reversing
            while(t.length()>0 && t.charAt(0)=='0'){
                t.deleteCharAt(0);//removing 0's from the front
            }

        if (t.length() == 0) return "0";//if the length of t=0 return 0

        return t.toString();
    }
}