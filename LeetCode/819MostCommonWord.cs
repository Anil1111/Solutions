public class Solution {
    public string MostCommonWord(string paragraph, string[] banned) {
        var words = paragraph.Split(new char[]{' ',',','.',':','?','!','-','\'','.',';'},StringSplitOptions.RemoveEmptyEntries);
        var bannedSet = new HashSet<string>(banned);
        var dict = new Dictionary<string, int>();
        int max = 0;
        string ret= "";
        foreach(var word in words){
            var lower = word.ToLower();
            if (banned.Contains(lower)) continue;
            
            int count = 0;
            if (dict.ContainsKey(lower)) count = dict[lower];
            count ++;
            dict[lower]=count;
            //Console.WriteLine(lower+" "+count+" max "+max);
            
            if (count>max){
                max = count;
                ret = lower;
            }
        }
        
        return ret;
    }
}
