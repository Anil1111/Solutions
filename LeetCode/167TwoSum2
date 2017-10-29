public class Solution {
    public int[] TwoSum(int[] numbers, int target) {
        int left = 0, right = numbers.Length - 1;
        while(left<right){
            var sum = numbers[left]+numbers[right];
            if (sum > target) {
                right--;
            }
            else if (sum < target){
                left ++;
            }
            else{
                break;
            }
        }
        
        return new int[]{left+1, right+1};
    }
}
