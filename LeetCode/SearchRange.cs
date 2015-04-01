public class Solution {
    public int[] SearchRange(int[] A, int target) {
        int[] ret = new int[]{-1, -1};
        int left = 0, right = A.Length - 1;
        while(left <= right){
            if(A[left]==target&&A[right]==target){
                ret[0]=left;
                ret[1]=right;
                return ret;
            }
            
            int mid = (left + right)/2;
            if (A[mid]<target) left = mid + 1;
            else if (A[mid]>target) right = mid - 1;
            else{
                if (A[right] == target) left++;
                else right--; 
            }
        }

        
        return ret;
    }
}
