class Solution {
    public int longestConsecutive(int[] arr) {
        Arrays.sort(arr);
        int longest=1,count=0,lastSmaller=Integer.MIN_VALUE;
        if(arr.length==0) return 0;
        for(int i=0;i<arr.length;i++){
            if((arr[i]-1)==lastSmaller){
                count++;
                lastSmaller=arr[i];
            }
            else if(arr[i]!=lastSmaller){
                count=1;
                lastSmaller=arr[i];
            }
            longest=Math.max(count,longest);
        }
        return longest;
    }
}