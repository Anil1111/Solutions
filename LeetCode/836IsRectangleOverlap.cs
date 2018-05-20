public class Solution {
    public bool IsRectangleOverlap(int[] rec1, int[] rec2) {
        int l1 = rec1[0], u1 = rec1[1], r1 = rec1[2], d1 = rec1[3];
        int l2 = rec2[0], u2 = rec2[1], r2 = rec2[2], d2 = rec2[3];
        
        if (r1<=l2 || r2<=l1) return false;
        if (d1<=u2 || d2<=u1) return false;
        
        return true;
    }
}
