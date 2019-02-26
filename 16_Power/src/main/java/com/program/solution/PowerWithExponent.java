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
        double result=powerWithExponent(base,exponent>>1);
        result *= result;
        if ((exponent&1)==1){
            result*=base;
        }
        return result;
    }
}
