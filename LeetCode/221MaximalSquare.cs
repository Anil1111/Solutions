public class Solution {
    public int MaximalSquare(char[,] matrix) {
        if (matrix == null) return 0;

        int max = 0, n = matrix.GetLength(0), m = matrix.GetLength(1);
        if (n == 0 || m == 0) return 0;

        // dp(i, j) represents the length of the square 
        // whose lower-right corner is located at (i, j)
        // dp(i, j) = min{ dp(i-1, j-1), dp(i-1, j), dp(i, j-1) }
        int[,] dp = new int[n + 1,m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
              if (matrix[i - 1,j - 1] == '1') {
                dp[i,j] = Math.Min(dp[i - 1, j - 1], Math.Min(dp[i - 1,j], dp[i,j - 1])) + 1;
                max = Math.Max(max, dp[i, j]);
              }
            }
        }

        // return the area
        return max * max;        
    }
}
