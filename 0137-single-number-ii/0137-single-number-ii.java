class Solution {
    public int singleNumber(int[] nums) {
        int ans=0;
        int n=nums.length;
        for(int i=0;i<32;i++){
            int curr=0;
            for(int j=0;j<n;j++){
                curr+=(nums[j]>>i)&1;
            }
            if(curr%3!=0) ans=ans|(1<<i);
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna