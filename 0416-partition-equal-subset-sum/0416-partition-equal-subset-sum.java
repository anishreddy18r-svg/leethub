class Solution {
    public boolean f(int i,int target,int []nums,Boolean[][]dp){
        if(i<0||target<0) return false;
        if(target==0) return true;
        if(nums[i]==target) return true;
        if(dp[i][target]!=null) return dp[i][target];
        boolean take=f(i-1,target-nums[i],nums,dp);
        boolean notTake=f(i-1,target,nums,dp);
        return dp[i][target]=take||notTake;
    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int num:nums) sum+=num;
        if(sum%2!=0) return false;
        int target=sum/2;
        int n=nums.length;
        Boolean dp[][]=new Boolean[n][target+1];

        return f(n-1,target,nums,dp);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna