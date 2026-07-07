class Solution {
    public boolean isPalindrome(int x) {
        //x=Math.abs(x);
        int n=x;
        int r=0,p=0;
        while(x>0){
            r=x%10;
            p=p*10+r;
            x=x/10;
        }
        if(n==p) return true;
        else return false;
    }
}