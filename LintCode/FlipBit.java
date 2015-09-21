/**
 * Created by huw on 9/21/2015.
 */
public class FlipBit {
    /**
     *@param a, b: Two integer
     *return: An integer
     */
    public static int bitSwapRequired(int a, int b) {
        // write your code here
        int ret = 0;
        while(a != 0 || b !=0){
            if ((a & 1) != (b & 1)) ret ++;
            a = a >>> 1;
            b = b >>> 1;
            System.out.printf("%d %d %d\r\n", a, b, ret);
        }

        return ret;
    }
}
