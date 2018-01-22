public class Solution {
    public bool IsToeplitzMatrix(int[,] matrix) {
        if (matrix == null) return false;
        
        int r = matrix.GetLength(0), c = matrix.GetLength(1);
        if (r < 1 || c < 1) return false;
        
        int v = matrix[0,0];
        for(int i=1;i<r&&i<c;i++){
            if (matrix[i, i] != v) return false;
        }
        
        return true;
    }
}
