public class Solution {   
    public int IntegerReplacement(int n) {
        long N = n;
        long small,big;
        int cnt = 0;
        while( N != 1){
        	if( (N & 1) == 0){
        		N >>= 1;
        	}
        	else {
                small = (N  & ( N - 1));
                big = ( N & (N + 1));
                if ( (small & (small-1)) <= (big & (big-1))){
                    N = N - 1;
                }
                else{
                    N = N + 1;
                }
            }
        	cnt++;
        }
        return cnt;
    }
}
