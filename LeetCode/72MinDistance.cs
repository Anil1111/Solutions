public class Solution {
    public int MinDistance(string word1, string word2) {
        int l1 = word1.Length;
        int l2 = word2.Length;

        int[] dp = new int[l2+1];
        for (int j = 1; j <= l2; ++j) dp[j] = j;

        for (int i = 1; i <= l1; ++i)
        {
            int prev = i;
            for (int j = 1; j <= l2; ++j)
            {
                int cur;
                if (word1[i-1] == word2[j-1]) {
                    cur = dp[j-1];
                } else {
                    cur = Math.Min(Math.Min(dp[j-1], prev), dp[j]) + 1;
                }

                dp[j-1] = prev;
                prev = cur;
            }
            dp[l2] = prev;
        }
        return dp[l2];
    }
}
