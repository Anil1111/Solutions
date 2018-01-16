public class Solution {
    public IList<IList<int>> SubsetsWithDup(int[] S) {
        Array.Sort(S);

        IList<IList<int>> ret = new List<IList<int>>();
        ret.Add(new List<int>());

        for(int i=0;i<S.Length;i++) {
            IList<IList<int>> tmp = new List<IList<int>>();
            foreach(IList<int> sub in ret) {
                IList<int> a = new List<int>(sub);
                a.Add(S[i]);
                if (!contains(ret, a)) tmp.Add(a);
            }
            foreach(IList<int> t in tmp) ret.Add(t);
        }

        return ret;
    }
    
    public bool contains(IList<IList<int>> lists, IList<int> list){
        foreach(IList<int> compare in lists){
            if (compare.Count == list.Count){
                bool flag = true;
                for(int i=0;i<compare.Count;i++){
                    if (compare[i]!=list[i]){
                        flag = false;
                    }
                }
                if (flag) return true;
            }
        }
        return false;
    }
}
