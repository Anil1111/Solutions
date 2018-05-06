public class Solution {
    public int ConsecutiveNumbersSum(int N) {
        if (N==1) return 1;
        
        int count = 1 + N%2;
        for(int i=3;i<=N/2;i+=2){
            if (N%i==0) count++;
        }
        return count;
    }
}
