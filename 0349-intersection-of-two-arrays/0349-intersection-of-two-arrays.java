class Solution {
    public int[] intersection(int[] arr1, int[] arr2) {
        int[] ans=new int[arr1.length];
        int i=0;
        int j=0;
        int k=0;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]>arr2[j]){
                j++;
            }
            else if(arr2[j]>arr1[i]) i++;
            else{
                if (k == 0 || ans[k - 1] != arr1[i]) {
                ans[k++]=arr1[i];
                }
                i++;
                j++;

            }
        }
        return Arrays.copyOf(ans, k);
    }
}