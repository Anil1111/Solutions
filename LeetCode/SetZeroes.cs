public class Solution {
    public void SetZeroes(int[,] matrix) {
        int row=matrix.GetLength(1), col=matrix.GetLength(0);
        
        int[] rf = new int[row], cf = new int[col];
        for(int i=0;i<row;i++) rf[i]=1;
        for(int j=0;j<col;j++) cf[j]=1;
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if (matrix[j,i]==0){
                    rf[i]=0;
                    cf[j]=0;
                }
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if (rf[i]==0||cf[j]==0){
                    matrix[j,i]=0;
                }
            }
        }
        
    }
}
