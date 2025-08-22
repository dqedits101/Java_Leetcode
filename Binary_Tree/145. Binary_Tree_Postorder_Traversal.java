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
    public List<Integer> postorderTraversal(TreeNode root) {
       List<Integer> ll = new ArrayList<>();
        if (root == null) return ll;
        if (root.left != null) {
            ll.addAll(postorderTraversal(root.left));
        }
        if (root.right != null) {
            ll.addAll(postorderTraversal(root.right));
        }
        ll.add(root.val);
        
        return ll; 
    }
}
