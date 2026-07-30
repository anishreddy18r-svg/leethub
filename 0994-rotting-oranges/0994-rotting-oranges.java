class Solution {
    class Pair{
        int a;
        int b;
        int tm;
        public Pair(int a ,int b,int tm){
            this.a=a;
            this.b=b;
            this.tm=tm;
        }
    };
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<Pair>q=new LinkedList<>();
        int[][]vis=new int[m][n];
        int fresh=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    vis[i][j]=0; 
                    fresh++;
                }
                else if(grid[i][j]==2){
                    Pair p=new Pair(i,j,0);
                    q.offer(p);
                    vis[i][j]=2;
                }
                else{
                    vis[i][j]=0;
                }
            }
        }
        
        int[]dr={1,0,-1,0};
        int[]dc={0,1,0,-1};
        int max=0;
        while(!q.isEmpty()){
            int r=q.peek().a;
            int c=q.peek().b;
            int t=q.peek().tm;
            max=Math.max(max,t);
            q.remove();
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1 && vis[nr][nc]==0){
                    vis[nr][nc]=2;
                    q.add(new Pair(nr,nc,t+1));
                    fresh--;
                }
            }
        }
        if(fresh>0) return -1;
        return max;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna