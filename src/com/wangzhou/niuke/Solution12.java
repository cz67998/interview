package com.wangzhou.niuke;

import java.math.BigDecimal;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/26
 * Time:8:41
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution12 {
    public double Power(double base, int exponent) {
        double p = 1;
        if(exponent==0){
            return 1.0;
        }else if(exponent>0){
            for (int i = 0; i < exponent; i++) {
                p *= base;
            }
            return p;
        }else {
            for (int i = 0; i >exponent; i--) {
                p *= base;
            }
            return 1/p;
        }

    }

    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal(0.1);
        System.out.println();
    }

}
