class Solution {
    public int f(int i,int buy,int[]prices,int[][]dp){
        if(i>=prices.length) return 0;
        if(dp[i][buy]!=-1) return dp[i][buy];
        if(buy==1){
            int buyToday=-prices[i]+f(i+1,0,prices,dp);
            int skipToday=f(i+1,1,prices,dp);
            return dp[i][buy]=Math.max(buyToday,skipToday);
        }
        else{
            int sellToday=prices[i]+f(i+2,1,prices,dp);
            int skipToday=f(i+1,0,prices,dp);
            return dp[i][buy]=Math.max(sellToday,skipToday);
        }
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp[][]=new int[n][2];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return f(0,1,prices,dp);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna