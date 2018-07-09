public class Solution {
    public int[][] Transpose(int[][] A) {
        int m = A.Length;
        int n = A[0].Length;
        int[][] ret = new int[n][];
        for(int i=0;i<n;i++){
            ret[i] = new int[m];
            for(int j=0;j<m;j++){
                ret[i][j] = A[j][i];
            }
        }
        return ret;
    }
}
