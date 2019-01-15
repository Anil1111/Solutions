/*
// Definition for a QuadTree node.
public class Node {
    public bool val;
    public bool isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node(){}
    public Node(bool _val,bool _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
}
*/
public class Solution {
    public Node Construct(int[][] grid) {
        int x = grid[0].Length;
        int y = grid.Length;
        
        return Create(grid, 0, 0, x, y);
    }
    
    Node Create(int[][] grid, int x1, int y1, int x2, int y2){
        //Console.WriteLine(x1+" "+y1+" "+x2+" "+y2);
        
        int val = grid[y1][x1];
        bool flag = true;
        for(int i=y1;i<y2;i++){
            for(int j=x1;j<x2;j++){
                if (val != grid[i][j]){
                    flag = false;
                    break;
                }
            }
            if (!flag) break;
        }
        
        if (flag){
            return new Node(val==1, true, null, null, null, null);
        }
        else{
            return new Node(val==1, false, 
                            Create(grid, x1, y1, (x1+x2)/2, (y1+y2)/2),
                            Create(grid, (x1+x2)/2, y1, x2, (y1+y2)/2),
                            Create(grid, x1, (y1+y2)/2, (x1+x2)/2, y2),
                            Create(grid, (x1+x2)/2, (y1+y2)/2, x2, y2)
                           );
        }
    }
}
