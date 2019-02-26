package com.program.solution;

public class PowerWithExponent {
    //计算指数为非负数的次方
    public double powerWithExponent(double base,int exponent){
        if (exponent==0){
            return 1.0;
        }
        if (exponent==1){
            return base;
        }
        //右移代替除以2,
        double result=powerWithExponent(base,exponent>>1);
        result *= result;
        //用位于运算符代替了求余运算符（%）来判断一个数是奇数还是偶数
        if ((exponent&1)==1){
            result*=base;
        }
        return result;
    }
}
