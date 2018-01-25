public class MapSum {
    Dictionary<string, int> dict = new Dictionary<string, int>();
    
    /** Initialize your data structure here. */
    public MapSum() {
        
    }
    
    public void Insert(string key, int val) {
        dict[key] = val;
    }
    
    public int Sum(string prefix) {
        int sum = 0;
        foreach(var key in dict.Keys){
            if (key.StartsWith(prefix)) sum += dict[key];
        }
        return sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.Insert(key,val);
 * int param_2 = obj.Sum(prefix);
 */
