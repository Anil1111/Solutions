public class Solution {
    public int[] AnagramMappings(int[] A, int[] B) {
        var list = new List<int>();
        var dict = new Dictionary<int, List<int>>();
        for(int i=0;i<B.Length;i++){ 
            List<int> pos;
            if (!dict.TryGetValue(B[i], out pos)){
                pos = new List<int>();
            }
            pos.Add(i);
            dict[B[i]]=pos;
        }
        for(int i=0;i<A.Length;i++){
            var pos = dict[A[i]];
            var val = pos[0];
            pos.Remove(val);
            list.Add(val);  
        } 
        return list.ToArray();
    }
}
