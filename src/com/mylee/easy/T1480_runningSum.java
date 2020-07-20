package com.mylee.easy;

import java.util.Arrays;

/**
 * 求新数组是源数组前几个数的和
 */
public class T1480_runningSum {
    public static void main(String[] args) {
        int[] nums = {1,2,3,5};
        int[] a = runningSum(nums);
        System.out.println(Arrays.toString(a));
    }

    //方法一：暴力解法时间复杂度O(n^2)
    public static int[] runningSum(int[] nums) {
        int[] a = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int sum = 0;
            for(int j=0;j<=i;j++){
                sum += nums[j];
            }
            a[i] = sum;
        }
        return a;
    }

    //方法二：动态规划 时间复杂度O(n)
    //动态求和公式：a[i] = a[i-1] + nums[i];
    public static int[] runningSum2(int[] nums) {
        int[] a = new int[nums.length];
        a[0] = nums[0];
        for(int i = 1;i < nums.length ;i++){
            a[i] = a[i-1] + nums[i];
        }
        return a;
    }

}
