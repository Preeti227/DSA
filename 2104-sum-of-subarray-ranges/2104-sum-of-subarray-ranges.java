class Solution {
    public long subArrayRanges(int[] nums) {
        return sumMax(nums) - sumMin(nums);
    }

    // Sum of subarray minimums
    public long sumMin(int[] arr) {
        int n = arr.length;
        int[] pse = previousSmaller(arr);
        int[] nse = nextSmaller(arr);

        long ans = 0;

        for (int i = 0; i < n; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;

            ans += (long) arr[i] * left * right;
        }

        return ans;
    }

    // Sum of subarray maximums
    public long sumMax(int[] arr) {
        int n = arr.length;
        int[] pge = previousGreater(arr);
        int[] nge = nextGreater(arr);

        long ans = 0;

        for (int i = 0; i < n; i++) {
            long left = i - pge[i];
            long right = nge[i] - i;

            ans += (long) arr[i] * left * right;
        }

        return ans;
    }

    public int[] previousSmaller(int[] arr) {
        int n = arr.length;
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return pse;
    }

    public int[] nextSmaller(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return nse;
    }

    public int[] previousGreater(int[] arr) {
        int n = arr.length;
        int[] pge = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }

            pge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return pge;
    }

    public int[] nextGreater(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }

            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return nge;
    }
}