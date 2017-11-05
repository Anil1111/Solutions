public class Solution {
    public bool IsPowerOfThree(int n) {
        while(n>1){
            var r = n % 3;
            if (r > 0) return false;
            n = n / 3;
        }
        return n==1;
    }
}
