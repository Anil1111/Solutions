public class Solution {
    public int MySqrt(int x) {
        int b = 0;
        int n = x;
        while(n > 0){
            b++;
            n = n >> 1;
        }
        n = x >> (b / 2);
        int product = n * n;
        if (product >= 0 && product < x){
            while(product < x && product >= 0){
                n++;
                product = n*n;
            }
        }
        else {
            while(product < 0 || product > x){
                n--;
                product = n*n;
            }
        }
        if (product > x) return n - 1;
        else return n;
    }
}
