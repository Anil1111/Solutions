public class replaceBlank {
    /**
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public int replaceBlank(char[] string, int length) {
        // Write your code 
        int count = 0, last = length - 1;
        for(int i=0;i<length;i++){
            if (string[i]==' ') count ++;
        }

        int ret = count * 2 + length;
        for(int i=length - 1;i>=0;i--){
            if (string[i]==' '){
                int offset = count * 2;
                for(int j=last;j>i;j--){
                    string[j+offset] = string[j];
                }
                last = i - 1;
                offset -=2;
                string[i+offset]='%';
                string[i+1+offset]='2';
                string[i+2+offset]='0';
                count --;
            }
        }
        return ret;
    }
}
