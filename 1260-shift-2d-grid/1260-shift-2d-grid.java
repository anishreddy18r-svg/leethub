class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m=grid.length,n=grid[0].length;
        k%=(m*n);
        List<List<Integer>>ans=new ArrayList<>(); 
        
        List<Integer>l=new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) l.add(grid[i][j]);
        }

        List<Integer>q=new ArrayList<>();
        for(int i=m*n-k;i<m*n;i++) q.add(l.get(i));
        for(int i=0;i<m*n-k;i++) q.add(l.get(i));
        
        int w=0;
        for(int i=0;i<m;i++){
            List<Integer>o=new ArrayList<>();
            for(int j=0;j<n;j++){
                o.add(q.get(w));
                w++;
            }
            ans.add(o);
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna