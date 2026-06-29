class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left=m-1;
        int right=0;
        while(left>=0 && right<n){
            if(nums1[left]>nums2[right]){
                swap(nums1,nums2,left,right);
                left--;
                right++;
            }
            else break;
            
        }
        Arrays.sort(nums1,0,m);
        Arrays.sort(nums2);
        for(int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        return;
    }
        void swap(int[] nums1,int[] nums2,int a,int b){
            int temp;
            temp=nums1[a];
            nums1[a]=nums2[b];
            nums2[b]=temp;
        }
}