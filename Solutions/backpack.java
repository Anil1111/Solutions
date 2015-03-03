public class Solution{
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        boolean[][] dp = new boolean[m+1][A.length];
        for(int i=0;i<=m;i++){
            for(int j=0;j<A.length;j++){
                dp[i][j] = false;
            }
        }
        
        return backPack1(m, m, A, dp);
    }
    
    public int backPack1(int m, int r, int[] A, boolean[][] dp) {
        int max = 0;
        
        for (int i=0;i<A.length;i++){
            if (A[i]==0) continue;
            
            int sum = m-r+A[i];
            if (r-A[i] >= 0 && !dp[sum][i]){
                int current = A[i];
                A[i] = 0;
                for(int j=0;j<A.length;j++){
                    if (dp[m-r][j]) dp[sum][j] = dp[m-r][j];
                }
                dp[sum][i] = true;
                
                int total = backPack1(m, r-current, A, dp) + current;
                if (total > max) max = total;
                A[i] = current;
            }
        }
        return max;
    }
}
