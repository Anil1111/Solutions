public class Solution {
    public int[] CountBits(int num) {        
        int[] answer = new int[num+1];
        int offset = 1;
        for(int i = 1; i < answer.Length; i++){
            if(offset * 2 == i) offset *= 2;
            answer[i] = 1 + answer[i - offset];
        }
        return answer;
    }
}
