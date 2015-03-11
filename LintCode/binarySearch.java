class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
        int mid;
        int left = 0;
        int right = nums.length - 1;
        
        while(left < right){
            mid = (left + right) / 2;
            
            if (nums[mid] == target){
                while(mid > 0 && nums[mid-1]==target) mid--;
                
                return mid;
            }
            else if (nums[mid] < target){ 
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        
        return -1;
    }
}
