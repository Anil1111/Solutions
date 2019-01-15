public class Solution {
    public int PoorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int pigs = 0;
        int level = minutesToTest / minutesToDie + 1;
        while (Math.Pow(level, pigs) < buckets){
            pigs ++;
        }
        return pigs;
    }
}
