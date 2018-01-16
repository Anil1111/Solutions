public class Solution {
    public IList<IList<int>> Subsets(int[] S) {
        Array.Sort(S);

        IList<IList<int>> ret = new List<IList<int>>();
        ret.Add(new List<int>());

        foreach(int i in S) {
            IList<IList<int>> tmp = new List<IList<int>>();
            foreach(IList<int> sub in ret) {
                IList<int> a = new List<int>(sub);
                a.Add(i);
                tmp.Add(a);
            }
            foreach(IList<int> t in tmp) ret.Add(t);
        }

        return ret;
    }
}
