public class Solution {
    public int IntegerBreak(int n) {
        int[] dp = new int[n+1];
        return IntegerBreak(n, dp);
    }
    
    int IntegerBreak(int n, int[] dp){
        if (n == 1) return 1;
        
        int max = 1;
        for(int i=1;i<n;i++){
            if (dp[i] == 0){
                int j = IntegerBreak(i, dp);
                dp[i] = i > j ? i : j;
            }
            if (dp[n-i] == 0) {
                int j = IntegerBreak(n-i, dp);
                dp[n-i] = n-i > j ? n-i : j;
            }
            if (dp[i]*dp[n-i]>max) max=dp[i]*dp[n-i];
        }
        
        return max;
    }
}
