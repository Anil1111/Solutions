public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        int size = v1.length > v2.length? v1.length : v2.length;
        for(int i=0;i<size;i++){
            int val1 = 0;
            if (i < v1.length) val1 = Integer.parseInt(v1[i]);
            int val2 = 0;
            if (i < v2.length) val2 = Integer.parseInt(v2[i]);
            if (val1 > val2) return 1;
            if (val2 > val1) return -1;
        }
        
        return 0;
    }
}
