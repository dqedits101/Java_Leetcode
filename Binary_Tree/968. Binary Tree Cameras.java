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
    int camera = 0;

    public int minCameraCover(TreeNode root) {
        int c = minCamera(root);
        if (c == -1) camera++; // root ko camera chahiye tha
        return camera;
    }

    // return:
    //  1 -> is node par camera hai
    //  0 -> node covered hai (child ke camera se)
    // -1 -> node ko camera chahiye
    public int minCamera(TreeNode root){
        if (root == null) return 0; // null ko covered maan lo

        int left  = minCamera(root.left);
        int right = minCamera(root.right);

        if (left == -1 || right == -1) { // kisi child ko camera chahiye
            camera++;                    // yaha camera lagao
            return 1;                    // is node par camera hai
        } else if (left == 1 || right == 1) { // koi child par camera hai
            return 0;                          // yeh node covered hai
        } else {
            return -1; // dono child covered the, to is node ko camera chahiye
        }
    }
}
