public class Solution {
    public int MaxArea(IList<int> height) {
        int left = 0, right = height.Count - 1;
        int max = Math.Min(height[left], height[right]) * (right - left);
        while(left < right){
            if (height[left] < height[right]) left++;
            else right--;
            int val = Math.Min(height[left], height[right]) * (right - left);
            if (val > max) max = val;
        }
        return max;
    }
}
