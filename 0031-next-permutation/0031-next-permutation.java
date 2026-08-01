class Solution {
    public void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
    public void reverse(int[]nums,int l,int r){
        while(l<=r){
            int temp=nums[l];
            nums[l]=nums[r];
            nums[r]=temp;
            l++;r--;
        }
    }
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int i=n-2;
        while(i>=0&&nums[i]>=nums[i+1]){
            i--;
        }       
        if(i==-1){ reverse(nums,0,n-1);return;}
        int j=n-1;
        while(nums[j]<=nums[i]){
            j--;
        }
        swap(nums,i,j);
        reverse(nums,i+1,n-1);
        return;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna