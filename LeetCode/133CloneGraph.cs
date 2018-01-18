/**
 * Definition for undirected graph.
 * public class UndirectedGraphNode {
 *     public int label;
 *     public IList<UndirectedGraphNode> neighbors;
 *     public UndirectedGraphNode(int x) { label = x; neighbors = new List<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode CloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        
        var dict = new Dictionary<int, UndirectedGraphNode>();
        var list = new List<UndirectedGraphNode>();
        list.Add(node);
        var newroot = new UndirectedGraphNode(node.label);
        dict[node.label] = newroot;
        
        while(list.Count > 0) {
            var newlist = new List<UndirectedGraphNode>();
            foreach(var n in list){                
                var newneighbors = new List<UndirectedGraphNode>();
                UndirectedGraphNode newnode;
                foreach(var nn in n.neighbors){
                    if (!dict.TryGetValue(nn.label, out newnode)){
                        newnode = new UndirectedGraphNode(nn.label);
                        dict[nn.label] = newnode;
                        newlist.Add(nn);
                    }
                    newneighbors.Add(newnode);
                }
                newnode = dict[n.label];
                newnode.neighbors = newneighbors;
            }
            list = newlist;
        }
        
        return newroot;
    }
}
