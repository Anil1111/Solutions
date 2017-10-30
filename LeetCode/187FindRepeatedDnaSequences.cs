public class Solution {
    public IList<string> FindRepeatedDnaSequences(string s) {
        var ret = new List<string>();
        var dict = new Dictionary<string, int>();      
        for(int i=0;i<s.Length - 9;i++){
            var sub = s.Substring(i, 10);
            
            if (!dict.ContainsKey(sub)) dict[sub] = 0;
            
            dict[sub] = dict[sub] + 1;
        }
        
        foreach(var key in dict.Keys){
            if(dict[key] > 1) ret.Add(key);
        }
        
        return ret;
    }
}
