class Solution {
    public int integerBreak(int n) {
        if(n <= 2){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        for(int i = 4; i <= n; i++){
            int num = i;
            for(int j = 1; j <= i/2; j++){
                int x = j;
                int y = num - x;
                
                int best = Math.max(x * y, dp[x] * y);
                best = Math.max(best, x * dp[y]);
                best = Math.max(best, dp[x] * dp[y]);

                dp[i] = Math.max(dp[i], best);

            }
        }
        return dp[n];
    }
}