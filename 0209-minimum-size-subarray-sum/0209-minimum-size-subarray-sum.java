class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min=Integer.MAX_VALUE;
        int sum=0;
        int l=0;
        for(int r=0;r<nums.length;r++){
            sum+=nums[r];
            while(sum>=target){
                min=Math.min(min,r-l+1);
                sum-=nums[l];
                l++;
            }
            
        }
        if(min==Integer.MAX_VALUE) return 0;
        return min;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna