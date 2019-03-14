package com.program.solution;

/**
 * 最长不含重复字符的子字符串
 *
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 假设字符串中只包含从’a’到’z’的字符。
 * 例如，在字符串中”arabcacfr”，最长非重复子字符串为”acfr”，长度为4。
 */
public class LongestSubstringWithoutDup {
    public static int getLongSubstrWithoutDup(String str){
        if (str==null||str.equals("")){
            return 0;
        }
        int maxLength=0;
        int curLength=0;
        int[] positions=new int[26];
        for (int i=0;i<positions.length;i++){
            positions[i]=-1;//初始化为-1，负数表示没出现过
        }
        for (int i=0;i<str.length();i++){
            int curChar=str.charAt(i)-'a';
            int prePosition=positions[curChar];
            //当前字符与它上次出现的位置之间的距离
            int distance=i-prePosition;
            //当前字符第一次出现，或者前一个非重复字符串中没有包含当前字符
            if (prePosition<0||distance>curLength){
                curLength++;
            }else {
                //更新最长非重复子字符串的长度
                if (curLength>maxLength){
                    maxLength=curLength;
                }
                curLength=distance;
            }
            positions[curChar]=i;//更新字符出现的位置
        }
        if (curLength>maxLength){
            maxLength=curLength;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int result = getLongSubstrWithoutDup("arabcacfr");
        System.out.println(result);
    }
}
