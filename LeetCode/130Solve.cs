public class Solution {
    class Point{
        public int x;
        public int y;
        public Point(int i, int j){
            x = i;
            y = j;
        }
    }
    public void Solve(char[,] board) {
        var list = new List<Point>();
        var lx = board.GetLength(0);
        var ly = board.GetLength(1);
        for(int i=0;i<lx;i++){
            if (Valid(board,i,0)){
                list.Add(new Point(i, 0));
            }
            if (Valid(board,i,ly-1)){
                list.Add(new Point(i, ly-1));
            }
        }
        for(int i=0;i<ly;i++){
            if (Valid(board,0,i)){
                list.Add(new Point(0, i));
            }
            if (Valid(board,lx-1,i)){
                list.Add(new Point(lx-1, i));
            }
        }
        while(list.Count > 0){
            var newList = new List<Point>();
            foreach(var p in list){
                if (Valid(board, p.x, p.y)){
                    board[p.x, p.y]='-';
                    if (Valid(board, p.x-1, p.y)) newList.Add(new Point(p.x-1, p.y));
                    if (Valid(board, p.x+1, p.y)) newList.Add(new Point(p.x+1, p.y));
                    if (Valid(board, p.x, p.y-1)) newList.Add(new Point(p.x, p.y-1));
                    if (Valid(board, p.x, p.y+1)) newList.Add(new Point(p.x, p.y+1));
                }
            }
            list = newList;
        }
        for(int i=0;i<lx;i++){
            for(int j=0;j<ly;j++){
                if (board[i,j]=='O') board[i,j]='X';
                if (board[i,j]=='-') board[i,j]='O';
            }
        }
    }
    
    bool Valid(char[,] board, int i, int j){
        return i>=0 && j>=0 && i<board.GetLength(0) && j<board.GetLength(1) && board[i,j]=='O';
    }
}
