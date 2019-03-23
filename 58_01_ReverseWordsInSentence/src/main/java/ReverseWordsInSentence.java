/**
 * 翻转单词顺序
 *
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student."，则输出"student. a am I"。
 */
public class ReverseWordsInSentence {
    public static void reverseWordsInSentence(String str){
        if (str.equals("")){
            return;
        }
        String[] s = str.split(" ");
        StringBuffer buffer=new StringBuffer();
        for (int i=s.length-1;i>=0;i--){
            //System.out.print(s[i]+" ");
            buffer.append(s[i]);
            if (i>0){
                buffer.append(" ");
            }
        }
        System.out.println(buffer.toString());
    }

    public static void main(String[] args) {
        String str="I am a student.";
        reverseWordsInSentence(str);//student. a am I
        System.out.println(reverseWordsInSentence2(str));//方法二
    }

    //书上的方法
    // 对每个单词进行反转得到"I ma a .tneduts"
    // 反转整个字符串得到"student. a am I"
    public static String reverseWordsInSentence2(String str){
        if (str.isEmpty()){
            return str;
        }
        char[] seq=str.toCharArray();
        int length=seq.length;
        int start=0;
        int end=0;
        //这里一定要含有等于，因为要判断是否是最后一个单词，从而可以处理最后一个单词
        while (end<=length){
            // 当已经遍历到字符串的最后一个字符，或者当前字符是空格时
            // 则对空格前的单词进行反转，即"am"反转为"ma"
            // 一定要把判断是否是结尾放在前面，否则seq[end]会报错，因为数组的有效索引是从0开始的
            // 反转后修改单词的起始指针为空格的下一个字符
            // 如果不符合条件，则移动指针继续判断下一个字符
            if (end==length||seq[end]==' '){
                reverse(seq,start,end-1);
                start=end+1;
            }
            end++;
        }
        reverse(seq,0,length-1);
        return new String(seq);
    }
    public static void reverse(char[] seq,int start,int end){//反转数组
        while (start<end){
            char temp=seq[start];
            seq[start]=seq[end];
            seq[end]=temp;
            start++;
            end--;
        }
    }
}
