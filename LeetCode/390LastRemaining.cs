public class Solution {
    public int LastRemaining(int n) {
        return n == 1 ? 1 : 2 * (1 + n / 2 - LastRemaining(n / 2));
    }
}
