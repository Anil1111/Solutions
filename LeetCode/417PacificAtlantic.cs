public class Solution {
    public IList<int[]> PacificAtlantic(int[,] matrix) {
        int m = matrix.GetLength(1), n = matrix.GetLength(0);
        
        HashSet<int> pset = new HashSet<int>(), aset = new HashSet<int>();
        Stack<int> stack = new Stack<int>();
        for(int i=0;i<m;i++){
            pset.Add(i);
            stack.Push(i);
        }
        for(int i=1;i<n;i++){
            pset.Add(i*m);
            stack.Push(i*m);
        }
        Visit(stack, pset, matrix);
        stack = new Stack<int>();
        for(int i=0;i<m;i++){
            aset.Add(m*(n-1)+i);
            stack.Push(m*(n-1)+i);
        }
        for(int i=0;i<n-1;i++){
            aset.Add(i*m+m-1);
            stack.Push(i*m+m-1);
        }
        Visit(stack, aset, matrix);
        //Console.WriteLine(string.Join(",", pset.Select(i=>$"[{i/m},{i%m}]")));
        //Console.WriteLine(string.Join(",", aset.Select(i=>$"[{i/m},{i%m}]")));
        
        IList<int[]> ret = new List<int[]>();
        foreach(int i in pset){
            if (aset.Contains(i)){
                int x = i%m;
                int y = i/m;            
                ret.Add(new int[]{y,x});
            }
        }
        return ret;
    }
    public void Visit(Stack<int> stack, HashSet<int> set, int[,] matrix){
        int m = matrix.GetLength(1), n = matrix.GetLength(0);
        while(stack.Count()>0){
            int i = stack.Pop();
            int x = i%m;
            int y = i/m;            
            if (x>0&&!set.Contains(i-1)&&matrix[y,x]<=matrix[y,x-1]){
                set.Add(i-1);
                stack.Push(i-1);
            }
            if (x<m-1&&!set.Contains(i+1)&&matrix[y,x]<=matrix[y,x+1]){
                set.Add(i+1);
                stack.Push(i+1);
            }
            if (y>0&&!set.Contains(i-m)&&matrix[y,x]<=matrix[y-1,x]){
                set.Add(i-m);
                stack.Push(i-m);
            }
            if (y<n-1&&!set.Contains(i+m)&&matrix[y,x]<=matrix[y+1,x]){
                set.Add(i+m);
                stack.Push(i+m);
            }
        }
    }
}
