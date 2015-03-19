public class Solution {
    public bool SearchMatrix(int[,] matrix, int target) {
        int m = matrix.GetLength(1), n = matrix.GetLength(0);
        int l=0,r=n*m-1;
        
        while(l<r){
            int mid = (l+r)/2;
            int my=mid/m, mx=mid%m;
            if (matrix[my,mx]==target) return true;
            if (matrix[my,mx]>target){
                r=mid;
            }
            else{
                l=mid+1;
            }
        }
        
        return matrix[l/m,l%m]==target;
    }
}
