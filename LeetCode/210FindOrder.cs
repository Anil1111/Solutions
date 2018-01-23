public class Solution {
    public int[] FindOrder(int numCourses, int[,] prerequisites) {
        var dict = new Dictionary<int, HashSet<int>>();
        for(int i=0;i<prerequisites.GetLength(0);i++){
            int n = prerequisites[i, 0];
            int pre = prerequisites[i, 1];
            HashSet<int> preset;
            if (!dict.TryGetValue(n, out preset)){
                preset = new HashSet<int>();
            }
            preset.Add(pre);
            dict[n] = preset;
        }
        
        var nopreset = new HashSet<int>();
        var all = new List<int>();
        for(int i=0;i<numCourses;i++){
            all.Add(i);
            if(!dict.ContainsKey(i)) nopreset.Add(i);
        }
        
        var ret = new List<int>(nopreset);
        if (nopreset.Count > 0){
            while(nopreset.Count < numCourses){
                bool changed = false;
                for(int n=0;n<numCourses;n++) {
                    if (nopreset.Contains(n)) continue;
                    
                    var preset = dict[n];
                    if (preset.All(p => nopreset.Contains(p))){
                        nopreset.Add(n);
                        ret.Add(n);
                        changed = true;
                    }
                }
                
                if (!changed) break;
            }
            
            if (nopreset.Count == numCourses){
                return ret.ToArray();
            }
            else{
                return new int[0];
            }
        }
        else{
            return new int[0];
        }        
    }
}
