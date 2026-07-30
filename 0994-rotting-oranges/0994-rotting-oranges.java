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
        int fresh=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    fresh++;
                }
                else if(grid[i][j]==2){
                    Pair p=new Pair(i,j,0);
                    q.offer(p);
                }
                
            }
        }
        
        int[]dr={1,0,-1,0};
        int[]dc={0,1,0,-1};
        int max=0;
        while(!q.isEmpty()){
            Pair p=q.poll();
            int r=p.a;
            int c=p.b;
            int t=p.tm;
            max=Math.max(max,t);
            
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1){
                    grid[nr][nc]=2;
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