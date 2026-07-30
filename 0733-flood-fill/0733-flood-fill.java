class Solution {
    public void dfs(int[][]image,int i , int j, int color,int init){
        int m=image.length;
        int n=image[0].length;
        if(i<0||i>=m||j<0||j>=n||image[i][j]!=init) return;
        image[i][j]=color;
        dfs(image,i-1,j,color,init);
        dfs(image,i+1,j,color,init);
        dfs(image,i,j-1,color,init);
        dfs(image,i,j+1,color,init);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int init=image[sr][sc];
        if(init==color) return image;
        dfs(image,sr,sc,color,init);
        return image;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna