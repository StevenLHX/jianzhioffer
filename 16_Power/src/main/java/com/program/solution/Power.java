package com.program.solution;

public class Power {
    //使用全局变量处理错误
    boolean invalidInput=false;

    public double power(double base,int exponent){
        if (equal(base,0.0)&&exponent<=0){
            invalidInput=true;
            return 0.0;
        }
        int absExponent=exponent;//定义正指数
        if (exponent<0){
            absExponent=-exponent;
        }
        double result=powerWithExponent(base,absExponent);
        if (exponent<0){
            result=1.0/result;
        }
        return result;
    }

    private double powerWithExponent(double base, int exponent) {
        double result=1.0;
        for (int i=1;i<=exponent;i++){
            result *=base;
        }
        return result;
    }

    //比较两个小数是否相等
    private boolean equal(double num1, double num2) {
        double tmp=num1-num2;
        if (tmp>-0.0000001&&tmp<0.0000001){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        Power test=new Power();
        double result=test.power(2.0,4);
        System.out.println("是否是非法输入："+test.invalidInput);
        System.out.println("结果是："+result);
    }
}
