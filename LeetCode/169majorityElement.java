public class Solution {
    public int majorityElement(int[] num) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int half = num.length / 2;
        for(int n:num){
            Integer val = map.get(n);
            if (val == null) val = 1;
            else val ++;
            
            if (val > half) return n;
            
            map.put(n, val);
        }
        return 0;
    }
}
