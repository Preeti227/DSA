class Solution {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }
    private int maxGain(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = Math.max(0, maxGain(root.left));
        int right = Math.max(0, maxGain(root.right));

        // Update the answer
        maxSum = Math.max(maxSum, root.val + left + right);

        // Return the best path that parent can use
        return root.val + Math.max(left, right);
    }
}