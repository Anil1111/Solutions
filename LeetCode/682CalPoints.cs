public class Solution {
    public int CalPoints(string[] ops) {
        var list = new List<int>();
        
        foreach(var op in ops){
            switch(op){
                case "+":
                    int t=0;
                    if (list.Count>0){
                        t += list[list.Count-1];
                        if (list.Count > 1) t+=list[list.Count-2];
                        list.Add(t);                        
                    }
                    break;
                case "C":
                    if (list.Count>0) list.Remove(list[list.Count-1]);
                    break;
                case "D":
                    if (list.Count>0) list.Add(list[list.Count-1]*2);
                    break;
                default:
                    var v = int.Parse(op);
                    list.Add(v);
                    break;
            }
        }
        
        int ret = 0;
        foreach(var v in list) ret += v;
        
        return ret;
    }
}
