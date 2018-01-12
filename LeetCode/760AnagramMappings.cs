public class Solution {
    public int[] AnagramMappings(int[] A, int[] B) {
        var list = new List<int>();
        var dict = new Dictionary<int, int>();
        for(int i=0;i<B.Length;i++) dict[B[i]] = i;
        for(int i=0;i<A.Length;i++) list.Add(dict[A[i]]);
        return list.ToArray();
    }
}
