class Solution {
    public String longestPalindrome(String s) {
       int osp = -1;
       int oep = -1;
       int len = 0;
       int n  = s.length();
       boolean[][] dp = new boolean[n][n];
       for(int gap = 0; gap < n; gap++){
          for(int sp = 0,ep = gap; ep < n; sp++,ep++){
             if(sp == ep){
                dp[sp][ep] = true;
             }else if(sp + 1 == ep){
                dp[sp][ep] = s.charAt(sp) == s.charAt(ep);
             }else{
                dp[sp][ep] = s.charAt(sp) == s.charAt(ep) && dp[sp+1][ep-1];
             }
             if(dp[sp][ep] == true){
                len = ep - sp + 1;
                osp = sp;
                oep = ep;
             }
          }
       }
       return s.substring(osp,oep+1);
    }
}
