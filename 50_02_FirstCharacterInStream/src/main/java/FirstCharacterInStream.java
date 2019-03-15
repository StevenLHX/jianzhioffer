/**
 * 字符流中第一个只出现一次的字符
 *
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是'g'。
 * 当从该字符流中读出前六个字符"google"时，第一个只出现一次的字符是'l'。
 */
public class FirstCharacterInStream {
    private int index;
    private int[] occurence;

    //在构造函数中初始化成员变量
    public FirstCharacterInStream(){
        index=0;
        occurence=new int[256];
        for (int i=0;i<256;i++){
            occurence[i]=-1;
        }
    }

    public void insert(char ch){
        if (occurence[ch]==-1){
            occurence[ch]=index;//第一次出现
        }else if (occurence[ch]>=0){
            occurence[ch]=-2;//已经出现过了
        }
        index++;
    }

    public char getIndex(){
        int minIndex=Integer.MAX_VALUE;//最大的integer
        char ch='#';
        for (int i=0;i<256;i++){
            if (occurence[i]>=0&&occurence[i]<minIndex){
                ch= (char) i;
                minIndex=occurence[i];
            }
        }
        return ch;
    }

    public static void main(String[] args) {
        String str="google";
        FirstCharacterInStream fc=new FirstCharacterInStream();
        for (int i=0;i<str.length();i++){
            fc.insert(str.charAt(i));
        }
        System.out.println(fc.getIndex());
    }
}
