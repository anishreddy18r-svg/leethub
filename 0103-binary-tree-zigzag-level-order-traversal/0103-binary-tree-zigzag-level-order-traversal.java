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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode>q=new LinkedList<>();
        q.offer(root);
        boolean boom=true;
        while(!q.isEmpty()){
            int si=q.size();
            List<Integer>l=new ArrayList<>();
            for(int i=0;i<si;i++){
                TreeNode node=q.poll();
                l.add(node.val);
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
            if(boom) ans.add(l);
            
            else {Collections.reverse(l);ans.add(l);}
            boom=!boom;
        }
        return ans;


    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna