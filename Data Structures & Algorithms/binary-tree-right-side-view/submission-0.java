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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int s = q.size();
            TreeNode rightnode = null;
            for(int i = 0; i < s; i++){
                TreeNode cur = q.poll();
                if(cur != null){
                    rightnode = cur;
                    q.add(cur.left);
                    q.add(cur.right);
                }
            }
            if(rightnode != null) {
                res.add(rightnode.val);
            }
        }
        return res;
    }
}
