class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        if(n==1) return matrix[0][0];
        int prev[]=new int[n];
        for(int i=0;i<n;i++) prev[i]=matrix[0][i];
        for(int r=1;r<n;r++){
            int cur[]=new int[n];
            for(int c=0;c<n;c++){
                int up=prev[c];
                int leftdiag=(c>0)?prev[c-1]:Integer.MAX_VALUE;
                int rightdiag=(c<n-1)?prev[c+1]:Integer.MAX_VALUE;
                cur[c]=matrix[r][c]+Math.min(up,Math.min(leftdiag,rightdiag));
            }
            prev=cur;
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++) min=Math.min(min,prev[i]);
        return min;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna