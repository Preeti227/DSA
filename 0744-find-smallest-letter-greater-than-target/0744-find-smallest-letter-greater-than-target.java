class Solution {
    public char nextGreatestLetter(char[] arr, char target) {

        int low = 0;
        int high = arr.length - 1;

        char ans =arr[0]; // for case 3 given 

        while(low <= high) {

            int mid = low + (high - low) / 2;

            if(arr[mid] > target) {
                ans = arr[mid];
                high = mid - 1;
            }
            else {//arr[mid]<target
                low = mid + 1;
            }
        }

        return ans;
    }
}