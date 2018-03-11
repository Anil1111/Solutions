public class Solution {
    public IList<IList<int>> AllPathsSourceTarget(int[][] graph) {
        IList<IList<int>> todo = new List<IList<int>>();
        IList<IList<int>> ret = new List<IList<int>>();
        IList<int> list = new List<int>();
        list.Add(0);
        todo.Add(list);
        while(todo.Count > 0){
            list = todo.First();
            todo.RemoveAt(0);
            var last = list.Last();
            var next = graph[last];
            if (next.Length > 0){
                foreach(var n in next){
                    var list1 = new List<int>(list);
                    list1.Add(n);
                    if (n == graph.Length-1) ret.Add(list1);
                    else todo.Add(list1);
                }
            }
        }
        
        return ret;
    }
}
