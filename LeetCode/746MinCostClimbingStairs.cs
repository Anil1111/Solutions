public class Solution {
    public int MinCostClimbingStairs(int[] cost) {        
        int[] newcost = new int[cost.Length];
        int last = 0;
        if (cost.Length > 2){
            newcost[cost.Length-2] = cost[cost.Length-2];
        }
        int curr = 0;
        if (cost.Length > 1){
            newcost[cost.Length-1] = cost[cost.Length-1];
        }
        for(int i=cost.Length-3;i>=0;i--){
            newcost[i] = newcost[i+1] < newcost[i+2] ? cost[i] + newcost[i+1] : cost[i] + newcost[i+2];
        }
        if (newcost.Length>2){
            return newcost[0]<newcost[1] ? newcost[0] : newcost[1];
        }
        else if (newcost.Length>1){
            return newcost[0];
        }
        else return 0;
    }
}
