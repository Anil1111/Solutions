public class Solution {
    public int Fib(int N) {
        int ret = 0, last = 1;
        for(int i=0;i<N;i++){
            int temp = last;
            last += ret;
            ret = temp;
        }
        return ret;
    }
}
