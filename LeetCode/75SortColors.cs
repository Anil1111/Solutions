public class Solution {
    public void SortColors(int[] A) {
        int[] counts = new int[]{0,0,0};
        
        for(int i=0;i<A.Length;i++){
            counts[A[i]] ++;
        }
        for(int i=0;i<A.Length;i++){
            if (i<counts[0]) A[i]=0;
            else if (i<counts[0]+counts[1]) A[i]=1;
            else A[i]=2;
        }
    }
}
