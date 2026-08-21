class Solution {
    public boolean canMake(int[] bloomDay, int m, int k,int mid){
        int cnt=0;
        int ans=0;
        for(int i:bloomDay){
            if(i<=mid) cnt++;
            if(i>mid) cnt=0;
            if(cnt==k) {ans++;cnt=0;}
        }
        return ans>=m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        if((long)m*k>n) return -1;
        int low=1,high=0;
        int ans=-1;
        for(int i:bloomDay) high=Math.max(high,i);
        while(low<=high){
            int mid=(low)+(high-low)/2;
            if(canMake(bloomDay,m,k,mid)){
                ans=mid;high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna