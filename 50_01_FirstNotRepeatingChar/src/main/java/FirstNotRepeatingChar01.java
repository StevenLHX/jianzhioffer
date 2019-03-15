import java.util.HashSet;

/**
 * 第一个只出现一次的字符
 *
 * 复杂度O（n2）的解法
 * 字符串中第一个只出现一次的字符
 * 例如：在字符串中找出第一个只出现一次的字符。如输入“abaccdeff”，则输出“b”。
 */
public class FirstNotRepeatingChar01 {
    public static int findFirstNotRepeatingChar(String str){
        if (str==null){
            return -1;
        }
        String result;
        char[] ch=str.toCharArray();
        HashSet<Character> hs=new HashSet<>();
        for (int i=0;i<str.length()-1;i++){
            for (int j=i+1;j<ch.length;j++){
               if (hs.contains(ch[i])){
                   break;
               }
               if (ch[i]==ch[j]){
                   hs.add(ch[i]);
                   break;
               }
               if (j==ch.length-1){
                   return i;
               }
            }
        }
        return -1;
    }

    public static int findFirstNotRepeatingChar2(String str){
        if (str==null){
            return -1;
        }
        char[] ch=str.toCharArray();
        for (int i=0;i<str.length()-1;i++){
            for (int j=i+1;j<ch.length;j++){
                if (ch[i]==ch[j]){
                    break;
                }
                if (j==ch.length-1){
                    return i;
                }
            }
        }
        return -1;
    }

    public static int findFirstNotRepeatingChar3(String str){
        if (str==null){
            return -1;
        }
        for (int i=0;i<str.length();i++){
            for (int j=i+1;j<str.length();j++){
                if (str.charAt(i)==str.charAt(j)){
                    break;
                }
                if (j==str.length()-1){
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String str="abaccdeff";
        int index = findFirstNotRepeatingChar(str);
        System.out.println(str.charAt(index));
        int r2=findFirstNotRepeatingChar2(str);
        System.out.println(str.charAt(r2));
        int r3=findFirstNotRepeatingChar3(str);
        System.out.println(str.charAt(r3));
    }

}
