class Solution {
    public int majorityElement(int[] nums) {
        // int n=nums.length;
        // HashMap<Integer,Integer>hm=new HashMap<>();
        // for(int i=0;i<n;i++){
        //     int l=nums[i];
        //     hm.put(l,hm.getOrDefault(l,0)+1);
        // }
        // for(int i:hm.keySet()){
        //     if(hm.get(i)>n/2) return i;
        // }
        // return -1;
        // Arrays.sort(nums);
        // int n=nums.length/2;
        // return nums[n];

        int cand=0;
        int count=0;
        for(int num:nums){
            if(count==0) cand=num;
            if(cand==num) count++;
            else count--;
        }
        return cand;
        
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna