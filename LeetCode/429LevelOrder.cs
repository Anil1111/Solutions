/*
// Definition for a Node.
public class Node {
    public int val;
    public IList<Node> children;

    public Node(){}
    public Node(int _val,IList<Node> _children) {
        val = _val;
        children = _children;
}
*/
public class Solution {
    public IList<IList<int>> LevelOrder(Node root) {
        IList<IList<int>> ret = new List<IList<int>>();
        IList<Node> tovisit = new List<Node>();
        if (root != null) tovisit.Add(root);
        
        while(tovisit.Count > 0){
            IList<Node> next = new List<Node>();
            IList<int> sub = new List<int>();
            foreach(Node node in tovisit){
                sub.Add(node.val);
                if (node.children != null){
                    foreach(Node child in node.children){
                        next.Add(child);
                    }
                }
            }
            
            ret.Add(sub);
            tovisit = next;
        }
        
        return ret;
    }
}
