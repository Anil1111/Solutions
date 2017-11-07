public class Solution {
    public int[] Intersect(int[] nums1, int[] nums2) {
        var dict = new Dictionary<int, int>();
        var ret = new List<int>();
        foreach(var num in nums1) {
            if (!dict.ContainsKey(num)) dict[num]=1;
            else dict[num] = dict[num]+1;
        }
        foreach(var num in nums2){
            if (dict.ContainsKey(num)){
                ret.Add(num);
                var n = dict[num] - 1;
                if (n == 0) dict.Remove(num);
                else dict[num] = n;
            }
        }
        return ret.ToArray();
    }
}
