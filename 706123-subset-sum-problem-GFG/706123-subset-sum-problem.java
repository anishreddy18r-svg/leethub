class Solution {
    static boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n=arr.length;
        boolean[] dp=new boolean[sum+1];
        dp[0]=true;
        if(arr[0]<=sum) dp[arr[0]]=true;
        for(int i=1;i<n;i++){
            for(int k=sum;k>=arr[i];k--){
                boolean nonpick=dp[k];
                boolean pick=dp[k-arr[i]];
                dp[k]=pick||nonpick;
            }
        }
        return dp[sum];
        
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna