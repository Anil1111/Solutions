import java.util.*;
public class HelloWorld{

    /**
     * {{2,3}}, {{7},{9},{6}}, {{1,2},{3,4}}, {{1,2,3},{4,5,6},{7,8,9}}
     **/
     public static void main(String []args){
        int[][] m0 = {{2,3}};
        System.out.println("Hello World {{2,3}}");
        spiralOrder(m0);
        int[][] m1 = {{7},{9},{6}};
        System.out.println("Hello World {{7},{9},{6}}");
        spiralOrder(m1);
        int[][] m2 = {{1,2},{3,4}};
        System.out.println("Hello World {{1,2},{3,4}}");
        spiralOrder(m2);
        int[][] m3 = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("Hello World {{1,2,3},{4,5,6},{7,8,9}}");
        spiralOrder(m3);
        int[][] m4 = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        System.out.println("Hello World {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}}");
        spiralOrder(m4);
     }
     
     public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) return ret;
        
        int[][] move = {{0,1},{1,0},{0,-1},{-1,0}};
        int[] hborder = {0, matrix[0].length-1};
        int[] vborder = {0, matrix.length-1};
        int[] pos = {0, 0};
        int direction = 0;
        int count = 0;
        int total = matrix.length * matrix[0].length;
        while(count < total){
            ret.add(matrix[pos[0]][pos[1]]);
            
            int new0=pos[0]+move[direction][0];
            int new1=pos[1]+move[direction][1];
            //System.out.printf("try %d %d direction %d border %d %d %d %d ", new0, new1, direction, hborder[0], hborder[1], vborder[0], vborder[1]);
            if (new0<vborder[0] || new0>vborder[1] || new1<hborder[0] || new1>hborder[1]){
                direction++;
                direction = direction % 4;

                switch(direction){
                    case 0:
                        hborder[0]++;
                        break;
                    case 1:
                        vborder[0]++;
                        break;
                    case 2:
                        hborder[1]--;
                        break;
                    case 3:
                        vborder[1]--;
                        break;
                }

                new0=pos[0]+move[direction][0];
                new1=pos[1]+move[direction][1];
            }
            //System.out.printf("new %d %d pos %d %d count %d\r\n", matrix[pos[0]][pos[1]], direction, new0, new1, count);
            pos[0]=new0;
            pos[1]=new1;
            
            count ++;
        }
        
        return ret;
    }
}
