public class Solution {
    public int CountNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        
        int f1 = 10;
        int f2 = 9;
        int factor = 9;
        for(int i=1;i<n&&i<11;i++){
            f2 = f2*factor;
            f1 += f2;
            factor--;
        }
        return f1;
    }
}
