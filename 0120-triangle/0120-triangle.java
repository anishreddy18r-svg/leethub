class Solution {
    public int f(int i,int j,List<List<Integer>> triangle,Integer[][]dp){
        if(i==triangle.size()-1) return triangle.get(i).get(j);
        if(dp[i][j]!=null) return dp[i][j];
        dp[i][j]=triangle.get(i).get(j)+Math.min(f(i+1,j,triangle,dp),f(i+1,j+1,triangle,dp));
        return dp[i][j];
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        Integer[][]dp=new Integer[n][n];
        return f(0,0,triangle,dp);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna