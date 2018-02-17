public class Solution {
    int count = 0;
    public int CountArrangement(int N) {
        bool[] visited = new bool[N + 1];
        calculate(N, 1, visited);
        return count;
    }
    
    public void calculate(int N, int pos, bool[] visited) {
        if (pos > N)
            count++;
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
                visited[i] = true;
                calculate(N, pos + 1, visited);
                visited[i] = false;
            }
        }
    }
}
