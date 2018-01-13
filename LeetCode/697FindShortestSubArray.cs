public class Solution {
    public class SubItem{
        public int Item1;
        public int Item2;
        public int Item3;
    }
    
    public int FindShortestSubArray(int[] nums) {
        var dict = new Dictionary<int, SubItem>();
        int max = 0;
        for(int i=0;i<nums.Length;i++){
            SubItem t;
            if (!dict.TryGetValue(nums[i], out t)){
                t = new SubItem();
                t.Item1 = 0;
                t.Item2 = i;
                t.Item3 = i;
            }
            t.Item1++;
            t.Item3=i;
            dict[nums[i]] = t;
            if (t.Item1 > max) max = t.Item1;
        }
        
        var selected = dict.Values.Where(t => t.Item1 == max);
        int min = int.MaxValue;
        foreach(var t in selected){
            var len = t.Item3 - t.Item2 + 1;
            if (len < min) min = len;
        }
        return min;
    }
}
