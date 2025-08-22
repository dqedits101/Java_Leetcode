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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ll = new ArrayList<>();
        if (root == null) return ll;
        if (root.left != null) {
            ll.addAll(inorderTraversal(root.left));
        }
        ll.add(root.val);
        if (root.right != null) {
            ll.addAll(inorderTraversal(root.right));
        }
        return ll;
    }
}
