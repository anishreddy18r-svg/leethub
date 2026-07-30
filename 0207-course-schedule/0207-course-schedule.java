class Solution {
    public boolean dfs(int st,List<List<Integer>>adj,int[]vis){
        vis[st]=1;
        for(int i:adj.get(st)){
            if(vis[i]==0){ if(dfs(i,adj,vis)) return true;}
            else if(vis[i]==1){
                return true;
            }
        }
        vis[st]=2;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n=numCourses;
        int m=prerequisites.length;
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<m;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int[]vis=new int[n];
        for(int i=0;i<n;i++){
            if(vis[i]==0) if(dfs(i,adj,vis)) return false;
        }
        return true;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna