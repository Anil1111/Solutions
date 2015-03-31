public class Solution {
    public int UniquePathsWithObstacles(int[,] obstacleGrid) {
        int m = obstacleGrid.GetLength(0), n = obstacleGrid.GetLength(1);
        int[,] dp = new int[m,n];
        bool flag = true;
        for(int i=0;i<m;i++) {
            if (obstacleGrid[i,0] == 1) flag = false;
            if (flag) dp[i,0]=1;
            else dp[i,0]=0;
        }
        flag = true;
        for(int i=0;i<n;i++) {
            if (obstacleGrid[0,i] == 1) flag = false;
            if (flag) dp[0,i]=1;
            else dp[0,i]=0;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if (obstacleGrid[i,j] == 1) dp[i,j]=0;
                else dp[i,j]=dp[i-1,j]+dp[i,j-1];
            }
        }
        return dp[m-1,n-1];
    }
}
