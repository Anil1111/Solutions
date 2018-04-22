public class Solution {
    public int[] ShortestToChar(string S, char C) {
        int[] dp = new int[S.Length];
        for(int i=0;i<S.Length;i++) dp[i] = S.Length;
        
        for(int i=0;i<S.Length;i++){
            if (S[i]==C){
                for(int j=0;j<S.Length;j++){
                    int d = Math.Abs(i-j);
                    if (dp[j] > d) dp[j]=d;
                }
            }
        }
        
        return dp;
    }
}
