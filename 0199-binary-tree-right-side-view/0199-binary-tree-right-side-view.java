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
    List<List<Integer>> list = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> li = new ArrayList<>();
        if(root==null)return li;
        bfs(root , 0);
        for(List<Integer> temp : list){
            li.add(temp.get(temp.size()-1));
        }
        return li;
    }
    private void bfs(TreeNode root ,int level){
        if(list.size()==level){
            list.add(new ArrayList<>());
        }
        list.get(level).add(root.val);
        if(root.left != null) bfs(root.left , level+1);
        if(root.right !=null) bfs(root.right , level+1);
    }
}