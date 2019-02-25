package com.program.solution;

/**
 *  将字符串中的空格替换为%20
 */
public class Solution1 {
    /**
     * 使用StringBuilder的方法
     * @param inputStr
     * @return
     */
    public static String replaceSpace(String inputStr){
        if (inputStr==null||inputStr.length()==0){
            return null;
        }
        StringBuilder stringBuilder=new StringBuilder();
        for (int i=0;i<inputStr.length();i++){
            if (inputStr.charAt(i)==' '){
                stringBuilder.append("%20");
            }else {
                stringBuilder.append(inputStr.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String str1="We are happy";
        String resultStr = replaceSpace(str1);
        System.out.println(resultStr);
    }
}
