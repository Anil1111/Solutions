/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     bool IsInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     int GetInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     IList<NestedInteger> GetList();
 * }
 */
public class NestedIterator {
    IList<int> flat = new List<int>();
    int offset = 0;
    public NestedIterator(IList<NestedInteger> nestedList) {
        var list = new List<NestedInteger>();
        foreach(var nested in nestedList){
            list.Add(nested);
        }
        while(list.Count > 0){
            var first = list.First();
            list.RemoveAt(0);
            if (first.IsInteger()){
                flat.Add(first.GetInteger());                
            }
            else{                
                var list1 = first.GetList();
                for(int i=list1.Count-1;i>=0;i--){
                    list.Insert(0, list1[i]);
                }
            }            
        }
    }

    public bool HasNext() {
        return offset < flat.Count;
    }

    public int Next() {
        var ret = flat[offset];
        offset++;
        return ret;
    }
}

/**
 * Your NestedIterator will be called like this:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.HasNext()) v[f()] = i.Next();
 */
