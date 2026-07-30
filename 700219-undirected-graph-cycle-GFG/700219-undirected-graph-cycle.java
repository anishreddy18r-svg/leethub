class Solution {
    class Pair{
        int node;
        int parent;
        public Pair(int node, int parent){
            this.node=node;
            this.parent=parent;
        }
    }
    public boolean checkCycle(int st, List<List<Integer>>adj, int[]vis){
        Queue<Pair>q=new LinkedList<>();
        
        q.offer(new Pair(st,-1));
        vis[st]=1;
        
        while(!q.isEmpty()){
            Pair p=q.poll();
            int node=p.node;
            int parent=p.parent;
            
            for(int i:adj.get(node)){
                if(vis[i]==0){
                    vis[i]=1;
                    q.offer(new Pair(i,node));
                }
                else if(vis[i]==1 && i!=parent) return true;
            }
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        int[]vis=new int[V];
        
        for(int i=0;i<V;i++){
            if(vis[i]==0) if(checkCycle(i,adj,vis)) return true;
        }
        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna