public class Solution {
    public int BinaryGap(int N) {
        int max = -1;
        int count = 0;
        int one = 0;
        while(N!=0){
            if ((N&1)==1){
                if (one > 0 && count > max) max = count;
                count = 0;
                one++;
            }
            else{
                count++;
            }
            N = N >> 1;
        }
        return max+1;
    }
}
