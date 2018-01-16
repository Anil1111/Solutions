public class Solution {
    public int rob(int[] num) {
        int size = num.length;
        if (size==0) return 0;
        if (size==1) return num[0];
        
        int[] dp = new int[size];
        dp[0] = num[0];
        dp[1] = num[1]>num[0] ? num[1]:num[0];
        
        for(int i=2;i<size;i++){
            dp[i]=dp[i-2]+num[i];
            dp[i]=dp[i]>dp[i-1]?dp[i]:dp[i-1];
        }
        
        return dp[size-1];
    }
}
