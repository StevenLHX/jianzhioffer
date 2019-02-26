package com.program.solution;

/**
 * 常规解法
 */
public class Solution_2 {
   public static int fun(int num){
       int count=0;
       int flag=1;
       while (flag!=0){
           if ((num & flag)!=0){
               count++;
           }
           flag=flag<<1;
       }
       return count;
   }
}
