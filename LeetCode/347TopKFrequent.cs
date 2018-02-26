public class Solution {
    public IList<int> TopKFrequent(int[] nums, int k) {
        var dict = new Dictionary<int,int>();
        foreach(var num in nums){
            int val;
            dict.TryGetValue(num, out val);
            dict[num] = val+1;
        }
        var countDict = new Dictionary<int,List<int>>();
        int count;
        foreach(var num in dict.Keys){
            count = dict[num];
            List<int> list;
            if (!countDict.ContainsKey(count)) list = new List<int>();
            else list = countDict[count];
            list.Add(num);
            countDict[count] = list;            
        }
        var sorted = countDict.Keys.ToList().OrderByDescending(key => key);
        count = 0;
        var ret = new List<int>();
        foreach(var val in sorted){
            var list = countDict[val];
            foreach(var num in list){
                count++;
                if (count>k) return ret;
                ret.Add(num);
            }
        }
        return ret;
    }
}
