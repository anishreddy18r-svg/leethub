class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n=adj.size();
        
        ArrayList<Integer>bfs=new ArrayList<>();
        
        Queue<Integer>q=new LinkedList<>();
        q.offer(0);
        
        boolean[]vis=new boolean[n+1];
        vis[0]=true;
        
        while(!q.isEmpty()){
            Integer node=q.poll();
            bfs.add(node);
            
            for(Integer i:adj.get(node)){
                if(vis[i]==false){
                    vis[i]=true;
                    q.offer(i);
                }
            }
        }
        return bfs;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna