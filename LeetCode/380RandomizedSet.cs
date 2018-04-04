public class RandomizedSet {
    HashSet<int> hashSet = new HashSet<int>();
    Random rand = new Random();
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public bool Insert(int val) {
        if (!hashSet.Contains(val)){
            hashSet.Add(val);
            return true;
        } 
        else return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public bool Remove(int val) {
        return hashSet.Remove(val);
    }
    
    /** Get a random element from the set. */
    public int GetRandom() {
        int n  = rand.Next(hashSet.Count);
        return hashSet.ElementAt(n);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * bool param_1 = obj.Insert(val);
 * bool param_2 = obj.Remove(val);
 * int param_3 = obj.GetRandom();
 */
