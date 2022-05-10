package com.ecpe205;

import java.util.Arrays;

public class Calculator {
    public double sum(double a, double b) {
      return a + b;
    }
    public boolean isEven (int value) {
        return value % 2 == 0;
    }
    public boolean isOdd (int value) {
        return value % 2 == 1;
    }

    public int factorial(int n){
        int x=1;
        for(int i=1;i<=n;i++){
            x=x*i;
        }
        return x;
    }
    public String Palindrome(String j){
        String rev = "";

        int strLength = j.length();

        for (int i = (strLength - 1); i >=0; --i) {
            rev = rev + j.charAt(i);
        }

        return rev.toLowerCase();
    }

    public double Power(double a, double b){

        return Math.pow(a,b);
    }


}
