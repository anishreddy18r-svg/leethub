class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer>hs=new HashSet<>();
        for(int num:nums)   hs.add(num);
        
        int max=0;
        for(int num:hs){
            if(!hs.contains(num-1)){
                int count=1;
                while(hs.contains(num+1)){
                    count++;
                    num++;
                }
                max=Math.max(count,max);
            }
        }
        return max;

    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna