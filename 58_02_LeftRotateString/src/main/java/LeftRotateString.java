import javax.sound.midi.Soundbank;

/**
 * 左旋转字符串
 *
 *字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。
 * 比如输入字符串"abcdefg"和数字2，该函数将返回左旋转2位得到的结果"cdefgab"。
 */
public class LeftRotateString {
    //方法一（自己写的）
    public static String leftRotateString(String str,int num){
        if (str.isEmpty()||num<=0){
            return str;
        }
        String s1=str.substring(0,num);
        String s2=str.substring(num);
        StringBuffer buffer=new StringBuffer();
        buffer.append(s2);
        buffer.append(s1);
        return buffer.toString();
    }

    public static void main(String[] args) {
        String str="abcdefg";
        System.out.println(leftRotateString(str,2));
        System.out.println(leftRotateString2(str,2));//方法二
    }

    // 书上的方法
    // 由于想把它的前两个字符移到后面，我们就把前两个字符分到第一部分，把后面的所有字符都分到第二部分。
    // 我们先分别翻转这两部分，于是就得到"bagfedc"。
    // 接下来我们再翻转整个字符串，得到的"cdefgab"刚好就是把原始字符串左旋转2位的结果。
    public static String leftRotateString2(String str,int num){
        if (str.isEmpty()){
            return str;
        }
        int length=str.length();
        char[] array=str.toCharArray();
        if (length>0&&num>0&&num<length){
            int firstStart=0;
            int firstEnd=num-1;
            int secondStart=num;
            int secondEnd=length-1;
            // 翻转字符串的前面n个字符
            reverse(array,firstStart,firstEnd);
            // 翻转字符串的后面部分
            reverse(array,secondStart,secondEnd);
            // 翻转整个字符串
            reverse(array,0,length-1);
        }
        return new String(array);
    }
    public static void reverse(char[] array,int start,int end){
        while (start<end){
            char temp=array[start];
            array[start]=array[end];
            array[end]=temp;
            start++;
            end--;
        }
    }
}
