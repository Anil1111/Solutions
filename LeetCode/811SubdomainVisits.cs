public class Solution {
    public IList<string> SubdomainVisits(string[] cpdomains) {
        var dict = new Dictionary<string, int>();
        foreach(var cpdomain in cpdomains){
            string[] vals = cpdomain.Split(' ');
            int count = int.Parse(vals[0]);
            string temp = vals[1];
            int start = temp.IndexOf('.');            
            while(start >= 0){
                if (dict.ContainsKey(temp)){
                    dict[temp] = dict[temp] + count;
                }
                else dict[temp] = count;
                
                temp = temp.Substring(start+1);
                start = temp.IndexOf('.');
            }
            
            if (dict.ContainsKey(temp)){
                dict[temp] = dict[temp] + count;
            }
            else dict[temp] = count;
        }
        
        IList<string> ret = new List<string>();
        foreach(var key in dict.Keys){
            ret.Add(dict[key]+" "+key);
        }
        
        return ret;
    }
}
