public class Solution {
    public int NumSquares(int n) {
        int[] dp = new int[n + 1];
        for(int i=0;i<n;i++) dp[i] = int.MaxValue;
        dp[0] = 0;
        for(int i = 1; i <= n; ++i) {
            int min = int.MaxValue;
            int j = 1;
            while(i - j*j >= 0) {
                min = (int)Math.Min(min, dp[i - j*j] + 1);
                j++;
            }
            dp[i] = min;
        }		
        return dp[n];
    }
}
