public class Solution {
    public IList<IList<int>> CombinationSum3(int k, int n) {
        return CombinationSum3(k, n, 1);
    }
    
    public IList<IList<int>> CombinationSum3(int k, int n, int start) {
        var ret = new List<IList<int>>(); 
        if (n > k*9) return ret;
        
        if (k == 1 && n <= 9) {
            var sub = new List<int>();
            sub.Add(n);
            ret.Add(sub);
            return ret;
        }        
        
        for(int i=start;i<=n/2&&i<=9;i++){            
            var sub = CombinationSum3(k-1, n-i, start+1);
            foreach(var s in sub){
                if (s.All(j => j>i)){
                  s.Add(i);
                  ret.Add(s);  
                } 
            }
        }
        return ret;
    }
}
