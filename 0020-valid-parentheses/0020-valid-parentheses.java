class Solution {
    public boolean isValid(String s) {
       int n=s.length();
        if(n%2==1) return false;
        Stack<Character> st=new Stack<>();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(c=='('||c=='['|| c=='{') st.push(c);
            else{
                if(st.size()==0) return false;
                char top=st.peek();
                if(sameStyle(top,c)) st.pop();
                else return false;
            }
        }
        return (st.size()==0);
    }
    static boolean sameStyle(char a,char b){
        if(a=='('&& b==')') return true;
        if(a=='{'&& b=='}') return true;
        if(a=='['&& b==']') return true;
        return false; 
    }
}