class Solution {
    public long f(int i,int[][]questions,long[]dp){
        if(i>=questions.length) return 0;
        if(dp[i]!=-1) return dp[i];
        long take=questions[i][0]+f(i+questions[i][1]+1,questions,dp);
        long skip=f(i+1,questions,dp);
        return dp[i]=Math.max(take,skip);
    }
    public long mostPoints(int[][] questions) {
        int n=questions.length;
        long[]dp=new long[n];
        Arrays.fill(dp,-1);
        return f(0,questions,dp);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna