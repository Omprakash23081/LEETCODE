/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int max = Integer.MIN_VALUE;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        dfs(root , 0);
        return LCA(root , 0);
    }

    private void dfs(TreeNode root , int level){
        if(root==null) return ;
        max = Math.max(max , level);
        dfs(root.left , level+1);
        dfs(root.right , level+1);
    }

    private TreeNode LCA(TreeNode root , int level){
        if(root==null) return null;
        if(level == max) return root;
        TreeNode left  = LCA(root.left , level+1);
        TreeNode right = LCA(root.right , level+1);

        if(left != null && right != null) return root;

        return left == null ? right : left;
    }
}