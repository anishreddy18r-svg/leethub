class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int num:nums) sum+=num;
        if(sum%2!=0) return false;
        int req=sum/2;
        
        boolean[] dp=new boolean[req+1];
        dp[0]=true;
        for(int num:nums){
            for(int k=req;k>=num;k--){
                dp[k]=dp[k]||dp[k-num];
            }
            if(dp[req]) return true;
        }
        return dp[req];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna