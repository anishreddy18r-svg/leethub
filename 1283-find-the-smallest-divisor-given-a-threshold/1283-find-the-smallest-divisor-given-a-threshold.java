class Solution {
    public boolean isPossible(int[]nums,int threshold,int mid){
        int cnt=0;
        for(int num:nums){
            cnt+=(num+mid-1)/mid;
        }
        return cnt<=threshold;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1,high=0;
        for(int num:nums) high=Math.max(high,num);
        int ans=low;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isPossible(nums,threshold,mid)){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna