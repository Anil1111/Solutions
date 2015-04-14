public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n+1];
        //for(int i=0;i<=n;i++) dp[i]=0;
        
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=i;j++){
                dp[j]=triangle.get(i).get(j)+Math.min(dp[j], dp[j+1]);
            }
        }
        return dp[0];
    }
}
