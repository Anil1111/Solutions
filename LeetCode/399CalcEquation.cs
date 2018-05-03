public class Solution {
    public double[] CalcEquation(string[,] equations, double[] values, string[,] queries) {
        Dictionary<string, Dictionary<string, double>> dict = new Dictionary<string, Dictionary<string, double>>();
        for(int i=0;i<equations.GetLength(0);i++){
            Dictionary<string, double> rd;
            rd = dict.TryGetValue(equations[i,0], out rd) ? rd : new Dictionary<string, double>();            
            rd[equations[i,1]] = values[i];
            dict[equations[i,0]]=rd;
            
            rd = dict.TryGetValue(equations[i,1], out rd) ? rd : new Dictionary<string, double>();
            rd[equations[i,0]] = 1.0/values[i];
            dict[equations[i,1]]=rd;
        }
        
        double[] ret = new double[queries.GetLength(0)];
        for(int i=0;i<queries.GetLength(0);i++){
            if (queries[i,0]==queries[i,1]){
                if (dict.ContainsKey(queries[i,0])) ret[i]=1;
                else ret[i]=-1;
            }
            else if (!dict.ContainsKey(queries[i,0])){
                ret[i]=-1;
            }
            else{
                ret[i] = Find(dict, queries[i,0], queries[i,1]);
            }
        }
        return ret;
    }
        
        double Find(Dictionary<string, Dictionary<string, double>> dict, string start, string end){
            HashSet<string> visited = new HashSet<string>();
            Stack<Tuple<string, double>> tovisit = new Stack<Tuple<string,double>>();
            tovisit.Push(new Tuple<string, double>(start, 1.0));
            while(tovisit.Count > 0){
                var first = tovisit.Pop();
                Dictionary<string, double> rd = dict[first.Item1];
                foreach(var key in rd.Keys){
                    if (key==end){
                        return first.Item2*rd[key];
                    }
                    if (!visited.Contains(key)){
                        visited.Add(key);                        
                        tovisit.Push(new Tuple<string, double>(key, first.Item2*rd[key]));
                        //TODO: add to dict
                    }
                }
            }
            
            return -1.0;
        }
}
