class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] matrix = new boolean[numCourses][numCourses];
        for(int i = 0; i < prerequisites.length; i++){
            int s = prerequisites[i][0];
            int d = prerequisites[i][1];
            matrix[s][d] = true;
        }
        for(int k = 0; k < numCourses; k++){
            for(int s = 0; s < numCourses; s++){
                for(int d = 0; d < numCourses; d++){
                    matrix[s][d] = matrix[s][d] || (matrix[s][k] && matrix[k][d]);
                }
            }
        }
        List<Boolean> ans  = new ArrayList<>();
        for(int i = 0; i < queries.length; i++){
            int s = queries[i][0];
            int d = queries[i][1];
            ans.add(matrix[s][d]);
        }
        return ans;
    }
}