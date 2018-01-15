public class Solution {
    public int CountPrimeSetBits(int L, int R) {
        int ret = 0;
        var prime = new HashSet<int>(new int[]{2,3,5,7,11,13,17,19,23,29,31});
        for(int i=L;i<=R;i++){
            int count = 0;
            int n = i;
            while(n>0){
                count += n&1;
                n = n >> 1;
            }
            if (prime.Contains(count)) ret++;
        }
        return ret;
    }
}
