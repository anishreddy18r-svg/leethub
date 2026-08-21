class Solution {
    public boolean isPossible(int[]arr,int k,int mid){
        int cnt=1;
        int last=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]-last>=mid){
                cnt++;
                last=arr[i];
            }
            
        }
        return cnt>=k;
    }
    public int aggressiveCows(int[] arr, int k) {
        // code here
        int low=1,high=0;
        Arrays.sort(arr);
        high=arr[arr.length-1]-arr[0];
        int ans=-1;
        while(low<=high){
            int mid=(low)+(high-low)/2;
            if(isPossible(arr,k,mid)){
                ans=Math.max(ans,mid);
                low=mid+1;
            }
            else high=mid-1;
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna