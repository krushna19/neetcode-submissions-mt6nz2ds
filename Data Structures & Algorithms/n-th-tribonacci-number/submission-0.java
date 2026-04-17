class Solution {
    public int tribonacci(int n) {
        if(n == 2 || n == 1){
           return 1;
        }
        if(n <= 0){
            return 0;
        }
        int curr = 0;
        int curr1 = 1;
        int curr2 = 1;
        int ans = 0;
        for(int i = 3; i <=n; i++){
           ans = curr + curr1 + curr2;
           curr = curr1;
           curr1 = curr2;
           curr2 = ans;
        }
        return ans;
    }
}