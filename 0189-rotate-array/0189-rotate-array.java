class Solution {
    public void reverse(int[]nums,int l, int r){
        while(l<=r){
            int temp=nums[l];
            nums[l]=nums[r];
            nums[r]=temp;
            l++;r--;
        }
    }
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }
}
// int []arr=nums.clone();
        // k%=nums.length;
        // int l=nums.length-k;

        
        // for(int i=0;i<l;i++){
        //     nums[i+k]=arr[i];
        // }
       
        // for(int i=0;i<k;i++){
        //     nums[i]=arr[l+i];
        // }


// int[] arr=new int[nums.length];
//         for(int i=0;i<nums.length;i++){
//             arr[(i+k)%nums.length]=nums[i];
//             // System.out.print(arr[i]+" ");
//         }
//         int j=0;
//         for(int i:arr){
//             nums[j++]=i;
//         }

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna