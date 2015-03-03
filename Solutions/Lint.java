public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        boolean[][] dp = new boolean[m][A.length];
        for(int i=0;i<m;i++){
            for(int j=0;j<A.length;j++)
                dp[i]][j] = false;
        }
        
        return backPack1(m, A, dp);
    }
    
    public int backPack1(int m, int[] A, boolean[][] dp) {
        int max = 0;
        
        // write your code here
        for (int i=0;i<A.length;i++){
            if (A[i]==0) continue;
            
            if (m-A[i] >= 0){
                int current = A[i];
                A[i] = 0;
                int sum = backPack1(m-current, A) + current;
                if (sum > max) max = sum;
                A[i] = current;
            }
        }
        return max;
    }
}
