public class Solution {
    public int HammingDistance(int x, int y) {
        long diff = x ^ y;
        int count = 0;
        while(diff != 0){
            if ((diff & 1) != 0) count++;
            diff = diff >> 1;
        }
        return count;
    }
}
