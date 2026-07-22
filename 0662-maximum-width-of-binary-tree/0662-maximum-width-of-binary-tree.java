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
    class Pair {
        TreeNode node;
        int index;
        Pair(TreeNode n, int i) {
            node = n;
            index = i;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int max=0;
        Queue<Pair>q=new LinkedList<>();
        q.offer(new Pair(root,1));
        while(!q.isEmpty()){
            int si=q.size();
            int l=0,r=0;
            for(int i=0;i<si;i++){
                Pair p=q.poll();
                TreeNode node =p.node;
                int currind=p.index;
                if(i==0) l=currind;
                if(i==si-1) r=currind;
                if(node.left!=null) q.offer(new Pair(node.left,2*currind));
                if(node.right!=null) q.offer(new Pair(node.right,2*currind+1));
            }
            max=Math.max(max,r-l+1);

        }
        return max;

    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna