class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer>stack=new Stack<>();
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int num:nums2){
            while(!stack.isEmpty()&&num>stack.peek()){
                hm.put(stack.pop(),num);
            }
            stack.push(num);
        }
        while(!stack.isEmpty()) hm.put(stack.pop(),-1);
        int[]arr=new int[nums1.length];
        // int i=0;
        for(int i=0;i<nums1.length;i++){
            arr[i]=hm.get(nums1[i]);
            
        }
        return arr;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna