/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root==p||root==q) return root;
        boolean pInLeft=exists(root.left,p);
        boolean qInLeft=exists(root.left,q);
        if(pInLeft && qInLeft) return lowestCommonAncestor(root.left,p,q);
        else if(!pInLeft && !qInLeft) return lowestCommonAncestor(root.right,p,q);
        else return root;
    }
    boolean exists(TreeNode root,TreeNode a){
        if(root==null) return false;
        if(root==a) return true;
        return exists(root.left,a)||exists(root.right,a);
    }
}