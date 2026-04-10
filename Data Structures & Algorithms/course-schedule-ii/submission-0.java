class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            graph.get(pre[1]).add(pre[0]);
            inDegree[pre[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }
        
        int[] order = new int[numCourses];
        int index = 0;

        
        while(!q.isEmpty()){
            int curr = q.poll();
            order[index++] = curr;
            for(int next : graph.get(curr)){
                inDegree[next]--;
                if(inDegree[next] == 0){
                    q.offer(next);
                }
            }
        }
        
        if (index != numCourses) {
            return new int[0];
        }

        return order;

    }
}
