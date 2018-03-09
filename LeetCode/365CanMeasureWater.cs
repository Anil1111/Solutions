public class Solution {
    public bool CanMeasureWater(int x, int y, int z) {
        if (z < 0 || z > x + y) return false;
        HashSet<int> set = new HashSet<int>();
        List<int> q = new List<int>();
        q.Add(0);
        while (q.Count > 0) {
            int n = q.First();
            if (n == z) return true;
            q.RemoveAt(0);
            
            if (n + x <= x + y && set.Add(n + x)) {
                q.Add(n + x);
            } 
            if (n + y <= x + y && set.Add(n + y)) {
                q.Add(n + y);
            } 
            if (n - x >= 0 && set.Add(n - x)) {
                q.Add(n - x);
            } 
            if (n - y >= 0 && set.Add(n - y)) {
                q.Add(n - y);
            }
        }
        return false;
    }
}
