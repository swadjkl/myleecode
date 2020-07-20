package com.mylee;

public class T0070_climbStairs {
    public static void main(String[] args){
        int n = climbStairs(101);
        System.out.println(n);
    }

    public static int climbStairs(int n) {
        if (n <= 1)
            return 1;
        else if (n == 2)
            return 2;
        else {
            int res = 0;
            int i = 1, j = 2;
            int k = 3;
            while (k <= n) {
                res = i + j;
                i = j;
                j = res;
                k++;
            }
            return res;
        }
    }
}
