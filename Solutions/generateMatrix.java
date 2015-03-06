public class HelloWorld{

     public static void main(String []args){
        System.out.println("Hello World");
        
        int[][] ret = generateMatrix(5);
        for(int[] r:ret){
            for(int r1:r) System.out.printf("%d ",r1);
            System.out.println();
        }
     }
     
     public static int[][] generateMatrix(int n) {
        if (n<1) return new int[0][0];
        
        int total = n*n;
        int val = 1;
        int stride = n-1;
        int startx = 0, starty = 0;
        int[][] ret = new int[n][n];
        
        while(val < total){
            for(int i=0;i<stride;i++){
                ret[starty][startx]=val;
                val++;
                startx ++;
            }
            for(int i=0;i<stride;i++){
                ret[starty][startx]=val;
                val++;
                starty ++;
            }
            for(int i=0;i<stride;i++){
                ret[starty][startx]=val;
                val++;
                startx --;
            }
            for(int i=0;i<stride;i++){
                ret[starty][startx]=val;
                val++;
                starty --;
            }
            stride-=2;
            starty++;
            startx++;
        }
        if (ret[starty][startx]==0) ret[starty][startx] = val;
        
        return ret;
    }
}
