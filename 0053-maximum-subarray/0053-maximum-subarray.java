class Solution {
    public int maxSubArray(int[] nums) {
        int cur=nums[0],max=nums[0];
        for(int i=1;i<nums.length;i++){
            cur=Math.max(nums[i],nums[i]+cur);
            max=Math.max(cur,max);
        }
        return max;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna