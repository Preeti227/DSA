class Solution {
    public int reverse(int x) {
        int r=0,p=0,n=x;
        while(x!=0){
            r=x%10;
            if(p>Integer.MAX_VALUE/10 || p==Integer.MAX_VALUE/10 && r>7) return 0;
            if(p<Integer.MIN_VALUE/10 || p==Integer.MIN_VALUE/10 && r<-8) return 0;
            p=p*10+r;
            x=x/10;
        }
        return p;
    }
}