class Solution {
    
    public int f(int i,int target, int[]coins,int[][]dp){
        if(target==0) return 0;
        if(i<0||target<0) return Integer.MAX_VALUE;
        if(dp[i][target]!=-1) return dp[i][target];
        int take=f(i,target-coins[i],coins,dp);
        if(take!=Integer.MAX_VALUE) take+=1;
        int skip=f(i-1,target,coins,dp);
        return dp[i][target]=Math.min(take,skip);
    }
    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        int n=coins.length;
        int[][]dp=new int[n][amount+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        int ans=f(n-1,amount,coins,dp);
        if(ans==Integer.MAX_VALUE) return -1;
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna