class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        boolean[][] dp = new boolean[n][n];
        for(int gap = 0; gap < n; gap++){
            for(int si = 0, ei = gap; ei < n; si++,ei++){
                if(si == ei && s.charAt(si)==s.charAt(ei)){
                    dp[si][ei] = true;
                    count++;
                }else if(si + 1 == ei && s.charAt(si) == s.charAt(ei)){
                    dp[si][ei] = true;
                    count++;
                }else{
                    if(dp[si+1][ei-1] && s.charAt(si) == s.charAt(ei)){
                        dp[si][ei] = true;
                        count++;
                    }
                }
                
            }
        }
        return count;
    }
}
