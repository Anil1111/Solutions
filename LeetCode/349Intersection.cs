public class Solution {
    public int[] Intersection(int[] nums1, int[] nums2) {
        var set = new HashSet<int>();
        var ret = new HashSet<int>();
        foreach(var num in nums1) {
            if (!set.Contains(num)) set.Add(num);
        }
        foreach(var num in nums2){
            if (!ret.Contains(num) && set.Contains(num)){
                ret.Add(num);
            }
        }
        return ret.ToArray();
    }
}
