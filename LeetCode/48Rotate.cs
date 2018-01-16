public class Solution {
    public void Rotate(int[,] matrix) {
        RotateN(matrix, 0, 0, matrix.GetLength(0)-1);
    }
    
    public void RotateN(int [,] matrix, int x, int y, int n){
        if (n<1) return;
        
        for(int i=0;i<n;i++){
            int val = matrix[y,x+i];
            matrix[y,x+i]=matrix[y+n-i,x];
            matrix[y+n-i,x]=matrix[y+n,x+n-i];
            matrix[y+n,x+n-i]=matrix[y+i,x+n];
            matrix[y+i,x+n]=val;
        }
        
        RotateN(matrix, x+1, y+1, n-2);
    }
}
