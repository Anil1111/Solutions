public class Solution {
    public bool IncreasingTriplet(int[] nums) {
        int first = int.MaxValue, second = int.MaxValue;
        foreach(var num in nums){
            if (num <= first) first = num;
            else if (num <= second) second = num;
            else return true;
        }
        return false;
    }
}
