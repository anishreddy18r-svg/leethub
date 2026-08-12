class Solution {
    int maxSide=0;
    public int f(int i,int j,char[][]matrix,int[][]dp){
        if(i<0||j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int top=f(i-1,j,matrix,dp);
        int left=f(i,j-1,matrix,dp);
        int diag=f(i-1,j-1,matrix,dp);
        if(matrix[i][j]=='1'){
            dp[i][j]=1+Math.min(top,Math.min(left,diag));
            maxSide =Math.max(maxSide,dp[i][j]);
            return dp[i][j];
        }
        else{
            return dp[i][j]=0;
        }
    }
    public int maximalSquare(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int [][]dp=new int[m][n];
        for(int i=0;i<m;i++) Arrays.fill(dp[i],-1);
        f(m-1,n-1,matrix,dp);
        return maxSide*maxSide;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna