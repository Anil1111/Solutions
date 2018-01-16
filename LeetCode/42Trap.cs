public class Solution {
    public int Trap(int[] A) {
        if (A==null || A.Length==0) return 0;
        
        int left = 0, right = A.Length - 1;
        int lmax=A[left], rmax=A[right], ret=0;
        while(left<right){
            if (A[left]<A[right]){
                if (A[left]>lmax) lmax=A[left];
                else ret+= lmax-A[left];
                left++;
            }
            else{
                if (A[right]>rmax) rmax=A[right];
                else ret+= rmax-A[right];
                right --;
            }
        }
        return ret;
    }
}
