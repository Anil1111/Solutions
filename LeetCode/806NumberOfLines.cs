public class Solution {
    public int[] NumberOfLines(int[] widths, string S) {
        int count = 0, line = 0;
        foreach(char c in S){
            int width = widths[c - 'a'];
            if (count + width > 100){
                line++;
                count = width;
            }
            else count += width;
        }
        return new int[]{line+(count > 0 ? 1 : 0), count};
    }
}
