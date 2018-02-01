public class Solution {
    public void GameOfLife(int[,] board) {
        for(int i=0;i<board.GetLength(0);i++){
            for(int j=0;j<board.GetLength(1);j++){
                var count = Count(board,i,j);
                if (IsAlive(board,i,j)){
                    if (count < 2) board[i,j] = 2; //to die
                    if (count > 3) board[i,j] = 2;
                }
                else if (count == 3) board[i,j] = -1; //to live
            }
        }
        for(int i=0;i<board.GetLength(0);i++){
            for(int j=0;j<board.GetLength(1);j++){
                if (board[i,j] == 2) board[i,j] = 0;
                if (board[i,j] == -1) board[i,j] = 1;
            }
        }
    }
    
    int Count(int[,] board, int x, int y){
        int count = 0;
        for(int i=-1;i<=1;i+=2){
            if (IsAlive(board,x+i,y)) count++;
            if (IsAlive(board,x,y+i)) count++;
            for(int j=-1;j<=1;j+=2){
                    if (IsAlive(board,x+i,y+j)) count++;
            }
        }
        return count;
    }
    
    bool IsAlive(int[,] board, int x, int y){
        if (x>=0 && x<board.GetLength(0) && y>=0 && y<board.GetLength(1)){
            return board[x,y] > 0;
        }
        return false;
    }
}
