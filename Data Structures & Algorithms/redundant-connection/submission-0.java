class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[edges.length+1];
        for(int i = 0; i <= edges.length; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            indegree[u]++;
            indegree[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= edges.length; i++){
            if(indegree[i] == 1){
               q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int node = q.poll();
            indegree[node]--;
            for(int nei : adj.get(node)){
                indegree[nei]--;
                if(indegree[nei] == 1){
                    q.offer(nei);
                }
            }
        }
        for(int i = edges.length-1; i >= 0; i--){
            int u = edges[i][0];
            int v = edges[i][1];
            if(indegree[u] == 2 && indegree[v] > 0){
                return new int[]{u,v};
            }
        }
        return new int[0];
    }
}
