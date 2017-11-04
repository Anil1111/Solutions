public class Solution {
    public int AddDigits(int num) {
        if (num == 0){
            return 0;
        }
        var n = num % 9;
        if (n == 0) return 9;
        else return n;
    }
}
